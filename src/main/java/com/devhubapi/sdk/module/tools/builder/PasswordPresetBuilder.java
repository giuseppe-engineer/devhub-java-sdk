package com.devhubapi.sdk.module.tools.builder;

import com.devhubapi.sdk.api.ToolsApi;
import com.devhubapi.sdk.client.DevHubClientException;
import com.devhubapi.sdk.model.PasswordRequest;
import com.devhubapi.sdk.model.PasswordResponse;
import com.devhubapi.sdk.module.tools.PasswordStrength;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class PasswordPresetBuilder {

    private final ToolsApi api;
    private final PasswordRequest request;

    public PasswordPresetBuilder(ToolsApi api, PasswordStrength strength) {
        this.api = api;

        this.request = new PasswordRequest();
        this.request.setStrength(strength.name());
    }

    /**
     * Excludes specific special characters from generation.
     */
    public PasswordPresetBuilder exclude(String excluded) {
        request.setExcludedSpecials(excluded);
        return this;
    }

    /**
     * Executes password generation.
     */
    public String generate() throws DevHubClientException {
        try {
            PasswordResponse response = api.generatePassword(request).block();
            return response.getPassword();
        } catch (WebClientResponseException ex) {
            throw new DevHubClientException(ex);
        }
    }
}