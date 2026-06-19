package com.devhubapi.sdk.module.tools.builder;

import com.devhubapi.sdk.api.ToolsApi;
import com.devhubapi.sdk.client.DevHubClientException;
import com.devhubapi.sdk.model.UUIDResponse;
import com.devhubapi.sdk.model.DevHubErrorResponse;
import java.time.LocalDateTime;
import org.springframework.web.reactive.function.client.WebClientResponseException;

/**
 * Builder for UUID v5 generation.
 */
public class UuidV5Builder {

    private final ToolsApi api;

    private String namespace;
    private String name;

    public UuidV5Builder(ToolsApi api) {
        this.api = api;
    }

    public UuidV5Builder namespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    public UuidV5Builder name(String name) {
        this.name = name;
        return this;
    }

    public UUIDResponse generate() throws DevHubClientException {

        if (namespace == null || namespace.isBlank()) {
            throw buildClientParseException("/api/v1/tools/uuid", "namespace is required for UUID v5");
        }

        if (name == null || name.isBlank()) {
            throw buildClientParseException("/api/v1/tools/uuid", "name is required for UUID v5");
        }

        try {
            return api.generateUuid("v5", 1, namespace, name).block();
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