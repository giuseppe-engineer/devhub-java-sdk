package com.devhubapi.sdk.module.protect.builder;

import com.devhubapi.sdk.api.DataProtectionApi;
import com.devhubapi.sdk.client.DevHubClientException;
import com.devhubapi.sdk.model.ValidateRequest;
import com.devhubapi.sdk.model.ValidateResponse;
import com.devhubapi.sdk.model.DevHubErrorResponse;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Fluent builder for configuring and executing validation operations using DevHubAPI.
 *
 * <p>
 * This builder provides a developer-friendly DSL (Domain Specific Language) to define
 * validation rules in a readable and chainable way, without manually constructing
 * {@link ValidateRequest} objects.
 * </p>
 *
 * <h3>Use case</h3>
 * <ul>
 *     <li>Validate user input before processing or persistence</li>
 *     <li>Apply multiple validation rules in a fluent and expressive way</li>
 *     <li>Enforce security constraints such as XSS and SQL injection detection</li>
 * </ul>
 *
 * <h3>Key Features</h3>
 * <ul>
 *     <li>Fluent API for chaining validation rules</li>
 *     <li>Support for parameterized rules (e.g. MIN_LENGTH, MAX_LENGTH, REGEX)</li>
 *     <li>Fail-fast or fail-slow execution modes</li>
 *     <li>Automatic validation checks before execution</li>
 * </ul>
 *
 * <h3>Example</h3>
 * <pre>{@code
 * ValidateResponse response = client.protect()
 *     .validate("test@email.com")
 *     .required()
 *     .email()
 *     .maxLength(100)
 *     .execute();
 * }</pre>
 *
 * <h3>Security Example</h3>
 * <pre>{@code
 * ValidateResponse response = client.protect()
 *     .validate("<script>alert(1)</script>")
 *     .noXss()
 *     .noSqlInjection()
 *     .execute();
 * }</pre>
 *
 * <h3>Regex Example</h3>
 * <pre>{@code
 * ValidateResponse response = client.protect()
 *     .validate("ABC123")
 *     .regex("^[A-Z0-9]+$")
 *     .execute();
 * }</pre>
 *
 * <p>
 * The builder internally constructs a {@link ValidateRequest} and delegates execution
 * to the DevHubAPI via {@link DataProtectionApi}.
 * </p>
 *
 * <p>
 * At least one validation rule must be specified before execution, otherwise an exception is thrown.
 * </p>
 *
 * <p>
 * This class is not thread-safe and should be used per request.
 * </p>
 */
public class ValidationBuilder {

    private final DataProtectionApi api;
    private final ValidateRequest request;

    public ValidationBuilder(DataProtectionApi api, String input) {
        this.api = api;

        this.request = new ValidateRequest();
        this.request.setInput(input);
        this.request.setRules(new ArrayList<>());
    }

    // ============================================================
    // ===================== BASIC RULES ===========================
    // ============================================================

    /**
     * Adds the REQUIRED rule.
     * Ensures the input is not null or empty.
     *
     * @return this builder instance for chaining
     */
    public ValidationBuilder required() {
        addRule("REQUIRED");
        return this;
    }

   /**
    * Adds the EMAIL rule.
    * Validates that the input is a valid email format.
    *
    * @return this builder instance for chaining
    */
    public ValidationBuilder email() {
        addRule("EMAIL");
        return this;
    }

   /**
    * Adds the PHONE rule.
    * Validates that the input is a valid phone number.
    *
    * @return this builder instance for chaining
    */
    public ValidationBuilder phone() {
        addRule("PHONE");
        return this;
    }

   /**
    * Adds the URL rule.
    * Validates that the input is a valid URL.
    *
    * @return this builder instance for chaining
    */
    public ValidationBuilder url() {
        addRule("URL");
        return this;
    }

    // ============================================================
    // ===================== LENGTH RULES ==========================
    // ============================================================

   /**
    * Adds a minimum length constraint.
    *
    * @param value the minimum allowed length (must be > 0)
    * @return this builder instance for chaining
    * @throws DevHubClientException if value is not positive
    */
    public ValidationBuilder minLength(int value) {
        validatePositive(value, "minLength");
        addRule("MIN_LENGTH:" + value);
        return this;
    }

   /**
    * Adds a maximum length constraint.
    *
    * @param value the maximum allowed length (must be > 0)
    * @return this builder instance for chaining
    * @throws DevHubClientException if value is not positive
    */
    public ValidationBuilder maxLength(int value) {
        validatePositive(value, "maxLength");
        addRule("MAX_LENGTH:" + value);
        return this;
    }

    // ============================================================
    // ===================== SECURITY RULES ========================
    // ============================================================

   /**
    * Adds the NO_XSS rule.
    * Detects potential cross-site scripting (XSS) patterns in the input.
    *
    * @return this builder instance for chaining
    */
    public ValidationBuilder noXss() {
        addRule("NO_XSS");
        return this;
    }

   /**
    * Adds the NO_SQL_INJECTION rule.
    * Detects potential SQL injection patterns in the input.
    *
    * @return this builder instance for chaining
    */
    public ValidationBuilder noSqlInjection() {
        addRule("NO_SQL_INJECTION");
        return this;
    }

    // ============================================================
    // ===================== CUSTOM ================================
    // ============================================================
  
    /**
    * Adds a custom REGEX validation rule.
    *
    * @param pattern the regex pattern to validate against
    * @return this builder instance for chaining
    * @throws DevHubClientException if the pattern is null or empty
    */
    public ValidationBuilder regex(String pattern) {
        if (pattern == null || pattern.isBlank()) {
	    throw buildClientParseException("/api/v1/data-protection/validate", "Regex pattern cannot be null or empty");
        }
        addRule("REGEX:" + pattern);
        return this;
    }

    // ============================================================
    // ===================== FAIL FAST =============================
    // ============================================================

   /**
    * Enables fail-fast mode.
    *
    * <p>
    * Validation will stop at the first rule failure.
    * </p>
    *
    * @return this builder instance for chaining
   */
    public ValidationBuilder failFast() {
        request.setFailFast(true);
        return this;
    }

   /**
    * Enables fail-slow mode.
    *
    * <p>
    * Validation will evaluate all rules and return all detected errors.
    * This is the default behavior.
    * </p>
    *
    * @return this builder instance for chaining
    */
    public ValidationBuilder failSlow() {
        request.setFailFast(false);
        return this;
    }

    // ============================================================
    // ===================== EXECUTION =============================
    // ============================================================

   /**
    * Executes the validation request using DevHubAPI.
    *
    * <p>
    * Applies default configurations before execution:
    * <ul>
    *     <li>Ensures at least one validation rule is defined</li>
    *     <li>Sets failFast to false if not explicitly configured</li>
    * </ul>
    * </p>
    *
    * @return the validation response returned by the API
    * @throws DevHubClientException if the API call fails or returns an error response
    * @throws IllegalStateException if no validation rules are defined
    */
    public ValidateResponse execute() throws DevHubClientException {

        applyDefaults();

        try {
            return api.validate(request).block();
        } catch (WebClientResponseException ex) {
            throw new DevHubClientException(ex);
        }
    }

    // ============================================================
    // ===================== INTERNAL ==============================
    // ============================================================

   /**
    * Adds a validation rule to the request, avoiding duplicates.
    *
    * @param rule the rule to add
    */
    private void addRule(String rule) {
       if (request.getRules() == null) {
          request.setRules(new ArrayList<>());
       }

       if (!request.getRules().contains(rule)) {
          request.getRules().add(rule);
       }
    }

   /**
    * Validates that a numeric parameter is positive.
    *
    * @param value the value to check
    * @param field the field name (used in error messages)
    * @throws DevHubClientException if value is less than or equal to zero
    */
    private void validatePositive(int value, String field) {
        if (value <= 0) {
            throw buildClientParseException("/api/v1/data-protection/validate", field + " must be > 0");
        }
    }

   /**
    * Applies default values before executing the request.
    *
    * <ul>
    *     <li>Ensures at least one validation rule is present</li>
    *     <li>Sets failFast to false if not specified</li>
    * </ul>
    */
    private void applyDefaults() {

        // almeno una rule obbligatoria
        if (request.getRules() == null || request.getRules().isEmpty()) {
            //throw new IllegalStateException("At least one validation rule must be specified");
	    throw buildClientParseException("/api/v1/data-protection/validate", "At least one validation rule must be specified");
        }

        // default failFast = false (se non specificato)
        if (request.getFailFast() == null) {
            request.setFailFast(false);
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