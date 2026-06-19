package com.devhubapi.sdk.module.tools.builder;

import com.devhubapi.sdk.api.ToolsApi;
import com.devhubapi.sdk.client.DevHubClientException;
import com.devhubapi.sdk.model.PasswordRequest;
import com.devhubapi.sdk.model.PasswordResponse;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class PasswordCustomBuilder {

    private final ToolsApi api;
    private final PasswordRequest request;

    public PasswordCustomBuilder(ToolsApi api) {
        this.api = api;

        this.request = new PasswordRequest();
        this.request.setStrength(null); // importante: niente preset
    }

    public PasswordCustomBuilder length(int length) {
        request.setLength(length);
        return this;
    }

    public PasswordCustomBuilder includeLetters(boolean value) {
        request.setIncludeLetters(value);
        return this;
    }

    public PasswordCustomBuilder includeNumbers(boolean value) {
        request.setIncludeNumbers(value);
        return this;
    }

    public PasswordCustomBuilder includeSpecials(boolean value) {
        request.setIncludeSpecials(value);
        return this;
    }

    public PasswordCustomBuilder exclude(String excluded) {
        request.setExcludedSpecials(excluded);
        return this;
    }

    public String generate() throws DevHubClientException {
        try {
            PasswordResponse response = api.generatePassword(request).block();
            return response.getPassword();
        } catch (WebClientResponseException ex) {
            throw new DevHubClientException(ex);
        }
    }
}