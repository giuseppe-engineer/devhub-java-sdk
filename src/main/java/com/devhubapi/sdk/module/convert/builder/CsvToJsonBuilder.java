package com.devhubapi.sdk.module.convert.builder;

import com.devhubapi.sdk.api.DataConversionsApi;
import com.devhubapi.sdk.client.DevHubClientException;
import com.devhubapi.sdk.model.DevHubErrorResponse;
import com.devhubapi.sdk.module.convert.Delimiter;
import com.devhubapi.sdk.module.convert.QuoteMode;
import com.devhubapi.sdk.module.convert.QuoteChar;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;
import java.time.LocalDateTime;

public class CsvToJsonBuilder {

    private final DataConversionsApi api;
    private final String input;
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private Delimiter delimiter = Delimiter.SEMICOLON;
    private QuoteMode quoteMode = QuoteMode.NONE;
    private QuoteChar quoteChar = QuoteChar.NONE;
    private Boolean trimFields = true;
    private Boolean inferTypes = true;

    public CsvToJsonBuilder(DataConversionsApi api, String input) {
        this.api = api;
        this.input = input;
    }

    // ============================================================
    // ===================== CONFIG ===============================
    // ============================================================

    public CsvToJsonBuilder delimiter(Delimiter delimiter) {
        if (delimiter != null) {
            this.delimiter = delimiter;
        }
        return this;
    }

    public CsvToJsonBuilder quoteMode(QuoteMode quoteMode) {
        if (quoteMode != null) {
            this.quoteMode = quoteMode;

            if (quoteMode == QuoteMode.NONE) {
                this.quoteChar = QuoteChar.NONE;
            }
        }
        return this;
    }

    public CsvToJsonBuilder quoteChar(QuoteChar quoteChar) {
        if (quoteChar != null) {
            this.quoteChar = quoteChar;
        }
        return this;
    }

    public CsvToJsonBuilder trimFields(boolean trimFields) {
        this.trimFields = trimFields;
        return this;
    }

    public CsvToJsonBuilder inferTypes(boolean inferTypes) {
        this.inferTypes = inferTypes;
        return this;
    }

    // ============================================================
    // ===================== EXECUTION =============================
    // ============================================================

    public String execute() throws DevHubClientException {
        try {
	    List<Object> list = api.convertCsvToJson(
                    input,
                    delimiter.name(),
                    quoteMode.name(),
                    quoteChar.name().equals("NONE") ? null : quoteChar.name(),
                    trimFields,
                    inferTypes
            )
            .collectList()
            .block();

            return OBJECT_MAPPER.writeValueAsString(list);
        } catch (WebClientResponseException ex) {
            throw new DevHubClientException(ex);
        } catch (Exception e) {
            throw buildClientParseException("/api/v1/convert/data/csv-to-json");
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