package com.devhubapi.sdk.module.protect.builder;

import com.devhubapi.sdk.api.DataProtectionApi;
import com.devhubapi.sdk.client.DevHubClientException;
import com.devhubapi.sdk.model.SanitizationRequest;
import com.devhubapi.sdk.model.SanitizationResult;
import com.devhubapi.sdk.module.ProtectDataModule;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.ArrayList;
import java.util.List;

/**
 * Fluent builder for configuring and executing sanitization operations using DevHubAPI.
 *
 * <p>
 * This builder provides a developer-friendly DSL (Domain Specific Language) to define
 * sanitization rules in a readable and chainable way, without manually constructing
 * {@link SanitizationRequest} objects.
 * </p>
 *
 * <h3>Use case</h3>
 * <ul>
 *     <li>Normalize and clean user input before processing or storage</li>
 *     <li>Apply multiple sanitization operations in a readable fluent style</li>
 *     <li>Ensure consistent sanitization across different input contexts (HTML, JSON, CSV, LOG)</li>
 * </ul>
 *
 * <h3>Key Features</h3>
 * <ul>
 *     <li>Fluent API for chaining sanitization operations</li>
 *     <li>Context-aware configuration (e.g. HTML mode)</li>
 *     <li>Automatic default handling (e.g. HTML mode fallback)</li>
 *     <li>Safe execution with centralized error handling</li>
 * </ul>
 *
 * <h3>Example</h3>
 * <pre>{@code
 * SanitizationResult result = client.protect()
 *     .sanitizeHtml("   Ciao   MONDO   ")
 *     .lowercase()
 *     .normalizeWhitespace()
 *     .execute();
 * }</pre>
 *
 * <h3>HTML Mode Example</h3>
 * <pre>{@code
 * SanitizationResult result = client.protect()
 *     .sanitizeHtml("<script>alert(1)</script>")
 *     .mode(ProtectDataModule.SanitizationHtmlMode.STRICT)
 *     .removePii()
 *     .execute();
 * }</pre>
 *
 * <p>
 * The builder internally constructs a {@link SanitizationRequest} and delegates execution
 * to the DevHubAPI via {@link DataProtectionApi}.
 * </p>
 *
 * <p>
 * This class is not thread-safe and should be used per request.
 * </p>
 */
public class SanitizationBuilder {

    private final DataProtectionApi api;
    private final SanitizationRequest request;

    public SanitizationBuilder(DataProtectionApi api,
                               String input,
                               ProtectDataModule.Context context) {

        this.api = api;

        this.request = new SanitizationRequest();
        this.request.setInput(input);
        this.request.setContext(context.name());

        // default: lista vuota (mai null)
        this.request.setOperations(new ArrayList<>());
    }

    // ============================================================
    // ===================== OPERATIONS ============================
    // ============================================================
    /**
     * Adds the LOWERCASE operation to the sanitization pipeline.
     *
     * @return this builder instance for chaining
     */
    public SanitizationBuilder lowercase() {
        addOperation(SanitizationRequest.OperationsEnum.LOWERCASE);
        return this;
    }

    /**
     * Adds the NORMALIZE_WHITESPACE operation to the sanitization pipeline.
     * Collapses multiple spaces into a single space and trims the input.
     *
     * @return this builder instance for chaining
     */
    public SanitizationBuilder normalizeWhitespace() {
        addOperation(SanitizationRequest.OperationsEnum.NORMALIZE_WHITESPACE);
        return this;
    }

    /**
     * Adds the REMOVE_ACCENTS operation to the sanitization pipeline.
     * Converts accented characters to their ASCII equivalents.
     *
     * @return this builder instance for chaining
     */
    public SanitizationBuilder removeAccents() {
        addOperation(SanitizationRequest.OperationsEnum.REMOVE_ACCENTS);
        return this;
    }

   /**
     * Adds the REMOVE_PII operation to the sanitization pipeline.
     * Attempts to remove or mask sensitive personal information.
     *
     * @return this builder instance for chaining
     */
    public SanitizationBuilder removePii() {
        addOperation(SanitizationRequest.OperationsEnum.REMOVE_PII);
        return this;
    }

    // ============================================================
    // ======================== MODE ===============================
    // ============================================================

    /**
     * Sets the sanitization mode for HTML content.
     *
     * <p>If not explicitly set, the default mode is {@code RELAXED} for HTML context.</p>
     *
     * @param mode the HTML sanitization mode
     * @return this builder instance for chaining
     */
    public SanitizationBuilder mode(ProtectDataModule.SanitizationHtmlMode mode) {
        if (mode != null) {
            request.setMode(mode.name());
        }
        return this;
    }

    // ============================================================
    // ===================== EXECUTION =============================
    // ============================================================

    /**
     * Executes the sanitization request using DevHubAPI.
     *
     * <p>
     * Applies default configurations before execution:
     * <ul>
     *     <li>Sets default HTML mode if not specified</li>
     *     <li>Ensures operations list is initialized</li>
     * </ul>
     * </p>
     *
     * @return the sanitization result returned by the API
     * @throws DevHubClientException if the API call fails or returns an error response
     */
    public SanitizationResult execute() throws DevHubClientException {

        applyDefaults();

        try {
            return api.sanitize(request).block();
        } catch (WebClientResponseException ex) {
            throw new DevHubClientException(ex);
        }
    }

    // ============================================================
    // ===================== INTERNAL ==============================
    // ============================================================

    /**
     * Adds a sanitization operation to the request.
     *
     * @param operation the operation to add
     */
    private void addOperation(SanitizationRequest.OperationsEnum operation) {
        if (request.getOperations() == null) {
            request.setOperations(new ArrayList<>());
        }
        request.getOperations().add(operation);
    }

    /**
     * Applies default values before executing the request.
     *
     * <ul>
     *     <li>Sets HTML mode to RELAXED if context is HTML and mode is not defined</li>
     *     <li>Ensures operations list is not null</li>
     * </ul>
     */
    private void applyDefaults() {

        // Default HTML mode
        if (isHtmlContext() && request.getMode() == null) {
            request.setMode(ProtectDataModule.SanitizationHtmlMode.RELAXED.name());
        }

        if (request.getOperations() == null || request.getOperations().isEmpty()) {
            request.setOperations(new ArrayList<>());
        }
    }

    private boolean isHtmlContext() {
        return ProtectDataModule.Context.HTML.name().equals(request.getContext());
    }
}