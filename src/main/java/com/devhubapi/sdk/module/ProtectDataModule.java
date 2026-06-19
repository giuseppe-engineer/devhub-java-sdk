package com.devhubapi.sdk.module;

import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.api.DataProtectionApi;
import com.devhubapi.sdk.client.DevHubClientException;
import com.devhubapi.sdk.model.SanitizationRequest;
import com.devhubapi.sdk.model.SanitizationResult;
import com.devhubapi.sdk.model.ValidateRequest;
import com.devhubapi.sdk.model.ValidateResponse;
import com.devhubapi.sdk.module.protect.builder.SanitizationBuilder;
import com.devhubapi.sdk.module.protect.builder.ValidationBuilder;
import com.devhubapi.sdk.module.protect.builder.SanitizationContextSelector;
import org.springframework.web.reactive.function.client.WebClientResponseException;

/**
 * Module providing data protection methods for DevHubAPI.
 */
public final class ProtectDataModule {

    private final DataProtectionApi api;

    /**
     * Creates a new ProtectDataModule using the given API client.
     *
     * @param apiClient the API client to use
     */
    public ProtectDataModule(ApiClient apiClient) {
        this.api = new DataProtectionApi(apiClient);
    }

    public SanitizationContextSelector sanitize(String input) {
        return new SanitizationContextSelector(api, input);
    }

    // ============================================================
    // ================= VALIDATION - DIRECT ======================
    // ============================================================

    /**
     * Starts a fluent validation flow.
     */
    public ValidationBuilder validate(String input) {
        return new ValidationBuilder(api, input);
    }

    // ============================================================
    // ===================== ENUMS ================================
    // ============================================================

    public enum Context {
        HTML,
        CSV,
        JSON,
        LOG
    }

    public enum SanitizationHtmlMode {
        RELAXED,
        STRICT,
        HARDENING
    }
}