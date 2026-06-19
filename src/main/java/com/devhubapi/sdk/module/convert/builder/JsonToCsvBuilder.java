package com.devhubapi.sdk.module.convert.builder;

import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.api.DataConversionsApi;
import com.devhubapi.sdk.client.DevHubClientException;
import com.devhubapi.sdk.model.DevHubErrorResponse;
import com.devhubapi.sdk.module.convert.Delimiter;
import com.devhubapi.sdk.module.convert.QuoteMode;
import com.devhubapi.sdk.module.convert.QuoteChar;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class JsonToCsvBuilder {

    private final DataConversionsApi api;
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private String jsonArray;
    private Delimiter delimiter;
    private QuoteMode quoteMode;
    private QuoteChar quoteChar;

    public JsonToCsvBuilder(DataConversionsApi api, String jsonArray) {
        this.api = api;
        this.jsonArray = jsonArray;
    }

    // ================= CONFIG =================

    public JsonToCsvBuilder delimiter(Delimiter delimiter) {
        if (delimiter != null) {
            this.delimiter = delimiter;
        }
        return this;
    }

    public JsonToCsvBuilder quoteMode(QuoteMode quoteMode) {
        if (quoteMode != null) {
            this.quoteMode = quoteMode;

            if (quoteMode == QuoteMode.NONE) {
                this.quoteChar = QuoteChar.NONE;
            }
        }
        return this;
    }

    public JsonToCsvBuilder quoteChar(QuoteChar quoteChar) {
        if (quoteChar != null) {
            this.quoteChar = quoteChar;
        }
        return this;
    }

    // ================= EXECUTION =================

    public String execute() throws DevHubClientException {
        try {
            String delimiterValue = delimiter != null ? delimiter.name() : "SEMICOLON";
            String quoteModeValue = quoteMode != null ? quoteMode.name() : "NONE";
            String quoteCharValue = quoteChar != null && !quoteChar.name().equals("NONE") ? quoteChar.name() : "";

	    List<Map<String, Object>> list = OBJECT_MAPPER.readValue(
                    jsonArray,
                    new TypeReference<List<Map<String, Object>>>() {}
            );

	    return api.convertJsonToCsv(list, delimiterValue, quoteModeValue, quoteCharValue).block();

        } catch (WebClientResponseException ex) {
            throw new DevHubClientException(ex);
        } catch (Exception ex) {
            throw buildClientParseException("/api/v1/convert/data/json-to-csv");
        }
    }

    // =========================
    // Helpers
    // =========================

    private DevHubClientException buildClientParseException(String path) {
        DevHubErrorResponse error = new DevHubErrorResponse();
        error.setError("Failed to parse JSON input");
        error.setStatus(400);
        error.setPath(path);
        error.setTimestamp(LocalDateTime.now().toString());
        return new DevHubClientException(error, 400);
    }
}