package com.devhubapi.sdk.module.tools.builder;

import com.devhubapi.sdk.api.ToolsApi;
import com.devhubapi.sdk.client.DevHubClientException;
import com.devhubapi.sdk.model.UUIDResponse;
import com.devhubapi.sdk.model.DevHubErrorResponse;
import java.time.LocalDateTime;
import org.springframework.web.reactive.function.client.WebClientResponseException;

/**
 * Builder for UUID v4 generation.
 */
public class UuidV4Builder {

    private final ToolsApi api;
    private int count = 1;

    public UuidV4Builder(ToolsApi api) {
        this.api = api;
    }

    /**
     * Number of UUIDs to generate (1–100).
     */
    public UuidV4Builder count(int count) {
        if (count <= 0 || count > 100) {
            throw buildClientParseException("/api/v1/tools/uuid", "count must be between 1 and 100");
        }
        this.count = count;
        return this;
    }

    public UUIDResponse generate() throws DevHubClientException {
        try {
            return api.generateUuid("v4", count, null, null).block();
        } catch (WebClientResponseException ex) {
            throw new DevHubClientException(ex);
        }
    }

    // =========================
    // Helpers
    // =========================

    private DevHubClientException buildClientParseException(String path, String message) {
        DevHubErrorResponse error = new DevHubErrorResponse();
        error.setError(message);
        error.setStatus(400);
        error.setPath(path);
        error.setTimestamp(LocalDateTime.now().toString());
        return new DevHubClientException(error, 400);
    }
}