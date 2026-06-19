package com.devhubapi.sdk.client;

import com.devhubapi.sdk.model.DevHubErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class DevHubClientException extends RuntimeException {

    private final DevHubErrorResponse errorResponse;
    private final int statusCode;

    public DevHubClientException(DevHubErrorResponse errorResponse, int statusCode) {
        super(errorResponse != null ? errorResponse.getError() : null);
        this.errorResponse = errorResponse;
        this.statusCode = statusCode;
    }

    public DevHubClientException(String message, int statusCode) {
        super(message);
        this.errorResponse = null;
        this.statusCode = statusCode;
    }

    public DevHubClientException(WebClientResponseException ex) {
        super(ex.getMessage(), ex);
        this.statusCode = ex.getStatusCode().value();
        this.errorResponse = parseError(ex.getResponseBodyAsString());
    }

    private DevHubErrorResponse parseError(String body) {
        try {
            if (body == null || body.isBlank()) return null;
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(body, DevHubErrorResponse.class);
        } catch (Exception e) {
            return null;
        }
    }

    public DevHubErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public int getStatusCode() {
        return statusCode;
    }
}