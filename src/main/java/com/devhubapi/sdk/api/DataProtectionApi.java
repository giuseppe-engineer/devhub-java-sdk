package com.devhubapi.sdk.api;

import com.devhubapi.sdk.ApiClient;

import com.devhubapi.sdk.model.DevHubErrorResponse;
import com.devhubapi.sdk.model.SanitizationRequest;
import com.devhubapi.sdk.model.SanitizationResult;
import com.devhubapi.sdk.model.ValidateRequest;
import com.devhubapi.sdk.model.ValidateResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-04-13T00:38:16.902282200+02:00[Europe/Rome]", comments = "Generator version: 7.19.0")
public class DataProtectionApi {
    private ApiClient apiClient;

    public DataProtectionApi() {
        this(new ApiClient());
    }

    public DataProtectionApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Sanitize and secure input data across multiple contexts
     * &lt;p&gt;This API sanitizes input data based on the specified context (HTML, JSON, CSV, LOG) and optional post-processing operations. It is designed to prevent common security risks such as XSS, CSV injection, log injection, and sensitive data exposure.&lt;/p&gt;&lt;h4&gt;Key Features&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Context-aware sanitization (HTML, JSON, CSV, LOG)&lt;/li&gt;&lt;li&gt;Detection and mitigation of security threats (XSS, injection, PII exposure)&lt;/li&gt;&lt;li&gt;Post-processing transformations (whitespace normalization, lowercase, accent removal)&lt;/li&gt;&lt;li&gt;Detailed audit output: issues detected, actions applied, explanations&lt;/li&gt;&lt;li&gt;Risk scoring system (LOW, MEDIUM, HIGH)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Sanitize user-generated HTML content before rendering&lt;/li&gt;&lt;li&gt;Prevent CSV injection before exporting data to Excel&lt;/li&gt;&lt;li&gt;Clean and normalize logs to prevent log forging attacks&lt;/li&gt;&lt;li&gt;Mask sensitive data such as emails and phone numbers&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Request Parameters&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;input&lt;/b&gt;: Raw input string to sanitize&lt;/li&gt;&lt;li&gt;&lt;b&gt;context&lt;/b&gt;: Target context (HTML, JSON, CSV, LOG)&lt;/li&gt;&lt;li&gt;&lt;b&gt;mode&lt;/b&gt;: Sanitization mode (RELAXED, STRICT, HARDENING) necessary just for HTML context, ignored otherwise. Default value RELAXED&lt;/li&gt;&lt;li&gt;&lt;b&gt;operations&lt;/b&gt;: Optional list of transformations (NORMALIZE_WHITESPACE, LOWERCASE, REMOVE_ACCENTS, REMOVE_PII)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Response Fields&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;sanitized&lt;/b&gt;: Final processed output&lt;/li&gt;&lt;li&gt;&lt;b&gt;contextApplied&lt;/b&gt;: Applied context&lt;/li&gt;&lt;li&gt;&lt;b&gt;issuesDetected&lt;/b&gt;: Security or data issues found&lt;/li&gt;&lt;li&gt;&lt;b&gt;actionsApplied&lt;/b&gt;: Operations and sanitization steps executed&lt;/li&gt;&lt;li&gt;&lt;b&gt;explanations&lt;/b&gt;: Human-readable explanations for detected issues&lt;/li&gt;&lt;li&gt;&lt;b&gt;riskLevel&lt;/b&gt;: LOW, MEDIUM, HIGH&lt;/li&gt;&lt;li&gt;&lt;b&gt;riskScore&lt;/b&gt;: Numeric risk score (0–100)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - Sanitization completed successfully
     * <p><b>400</b> - Invalid input or CSV formatting options
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param sanitizationRequest Sanitization request payload. Provide input data, target context, optional mode and operations.
     * @return SanitizationResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec sanitizeRequestCreation(@jakarta.annotation.Nonnull SanitizationRequest sanitizationRequest) throws WebClientResponseException {
        Object postBody = sanitizationRequest;
        // verify the required parameter 'sanitizationRequest' is set
        if (sanitizationRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'sanitizationRequest' when calling sanitize", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<SanitizationResult> localVarReturnType = new ParameterizedTypeReference<SanitizationResult>() {};
        return apiClient.invokeAPI("/api/v1/data-protection/sanitize", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Sanitize and secure input data across multiple contexts
     * &lt;p&gt;This API sanitizes input data based on the specified context (HTML, JSON, CSV, LOG) and optional post-processing operations. It is designed to prevent common security risks such as XSS, CSV injection, log injection, and sensitive data exposure.&lt;/p&gt;&lt;h4&gt;Key Features&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Context-aware sanitization (HTML, JSON, CSV, LOG)&lt;/li&gt;&lt;li&gt;Detection and mitigation of security threats (XSS, injection, PII exposure)&lt;/li&gt;&lt;li&gt;Post-processing transformations (whitespace normalization, lowercase, accent removal)&lt;/li&gt;&lt;li&gt;Detailed audit output: issues detected, actions applied, explanations&lt;/li&gt;&lt;li&gt;Risk scoring system (LOW, MEDIUM, HIGH)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Sanitize user-generated HTML content before rendering&lt;/li&gt;&lt;li&gt;Prevent CSV injection before exporting data to Excel&lt;/li&gt;&lt;li&gt;Clean and normalize logs to prevent log forging attacks&lt;/li&gt;&lt;li&gt;Mask sensitive data such as emails and phone numbers&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Request Parameters&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;input&lt;/b&gt;: Raw input string to sanitize&lt;/li&gt;&lt;li&gt;&lt;b&gt;context&lt;/b&gt;: Target context (HTML, JSON, CSV, LOG)&lt;/li&gt;&lt;li&gt;&lt;b&gt;mode&lt;/b&gt;: Sanitization mode (RELAXED, STRICT, HARDENING) necessary just for HTML context, ignored otherwise. Default value RELAXED&lt;/li&gt;&lt;li&gt;&lt;b&gt;operations&lt;/b&gt;: Optional list of transformations (NORMALIZE_WHITESPACE, LOWERCASE, REMOVE_ACCENTS, REMOVE_PII)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Response Fields&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;sanitized&lt;/b&gt;: Final processed output&lt;/li&gt;&lt;li&gt;&lt;b&gt;contextApplied&lt;/b&gt;: Applied context&lt;/li&gt;&lt;li&gt;&lt;b&gt;issuesDetected&lt;/b&gt;: Security or data issues found&lt;/li&gt;&lt;li&gt;&lt;b&gt;actionsApplied&lt;/b&gt;: Operations and sanitization steps executed&lt;/li&gt;&lt;li&gt;&lt;b&gt;explanations&lt;/b&gt;: Human-readable explanations for detected issues&lt;/li&gt;&lt;li&gt;&lt;b&gt;riskLevel&lt;/b&gt;: LOW, MEDIUM, HIGH&lt;/li&gt;&lt;li&gt;&lt;b&gt;riskScore&lt;/b&gt;: Numeric risk score (0–100)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - Sanitization completed successfully
     * <p><b>400</b> - Invalid input or CSV formatting options
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param sanitizationRequest Sanitization request payload. Provide input data, target context, optional mode and operations.
     * @return SanitizationResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<SanitizationResult> sanitize(@jakarta.annotation.Nonnull SanitizationRequest sanitizationRequest) throws WebClientResponseException {
        ParameterizedTypeReference<SanitizationResult> localVarReturnType = new ParameterizedTypeReference<SanitizationResult>() {};
        return sanitizeRequestCreation(sanitizationRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Sanitize and secure input data across multiple contexts
     * &lt;p&gt;This API sanitizes input data based on the specified context (HTML, JSON, CSV, LOG) and optional post-processing operations. It is designed to prevent common security risks such as XSS, CSV injection, log injection, and sensitive data exposure.&lt;/p&gt;&lt;h4&gt;Key Features&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Context-aware sanitization (HTML, JSON, CSV, LOG)&lt;/li&gt;&lt;li&gt;Detection and mitigation of security threats (XSS, injection, PII exposure)&lt;/li&gt;&lt;li&gt;Post-processing transformations (whitespace normalization, lowercase, accent removal)&lt;/li&gt;&lt;li&gt;Detailed audit output: issues detected, actions applied, explanations&lt;/li&gt;&lt;li&gt;Risk scoring system (LOW, MEDIUM, HIGH)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Sanitize user-generated HTML content before rendering&lt;/li&gt;&lt;li&gt;Prevent CSV injection before exporting data to Excel&lt;/li&gt;&lt;li&gt;Clean and normalize logs to prevent log forging attacks&lt;/li&gt;&lt;li&gt;Mask sensitive data such as emails and phone numbers&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Request Parameters&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;input&lt;/b&gt;: Raw input string to sanitize&lt;/li&gt;&lt;li&gt;&lt;b&gt;context&lt;/b&gt;: Target context (HTML, JSON, CSV, LOG)&lt;/li&gt;&lt;li&gt;&lt;b&gt;mode&lt;/b&gt;: Sanitization mode (RELAXED, STRICT, HARDENING) necessary just for HTML context, ignored otherwise. Default value RELAXED&lt;/li&gt;&lt;li&gt;&lt;b&gt;operations&lt;/b&gt;: Optional list of transformations (NORMALIZE_WHITESPACE, LOWERCASE, REMOVE_ACCENTS, REMOVE_PII)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Response Fields&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;sanitized&lt;/b&gt;: Final processed output&lt;/li&gt;&lt;li&gt;&lt;b&gt;contextApplied&lt;/b&gt;: Applied context&lt;/li&gt;&lt;li&gt;&lt;b&gt;issuesDetected&lt;/b&gt;: Security or data issues found&lt;/li&gt;&lt;li&gt;&lt;b&gt;actionsApplied&lt;/b&gt;: Operations and sanitization steps executed&lt;/li&gt;&lt;li&gt;&lt;b&gt;explanations&lt;/b&gt;: Human-readable explanations for detected issues&lt;/li&gt;&lt;li&gt;&lt;b&gt;riskLevel&lt;/b&gt;: LOW, MEDIUM, HIGH&lt;/li&gt;&lt;li&gt;&lt;b&gt;riskScore&lt;/b&gt;: Numeric risk score (0–100)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - Sanitization completed successfully
     * <p><b>400</b> - Invalid input or CSV formatting options
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param sanitizationRequest Sanitization request payload. Provide input data, target context, optional mode and operations.
     * @return ResponseEntity&lt;SanitizationResult&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<SanitizationResult>> sanitizeWithHttpInfo(@jakarta.annotation.Nonnull SanitizationRequest sanitizationRequest) throws WebClientResponseException {
        ParameterizedTypeReference<SanitizationResult> localVarReturnType = new ParameterizedTypeReference<SanitizationResult>() {};
        return sanitizeRequestCreation(sanitizationRequest).toEntity(localVarReturnType);
    }

    /**
     * Sanitize and secure input data across multiple contexts
     * &lt;p&gt;This API sanitizes input data based on the specified context (HTML, JSON, CSV, LOG) and optional post-processing operations. It is designed to prevent common security risks such as XSS, CSV injection, log injection, and sensitive data exposure.&lt;/p&gt;&lt;h4&gt;Key Features&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Context-aware sanitization (HTML, JSON, CSV, LOG)&lt;/li&gt;&lt;li&gt;Detection and mitigation of security threats (XSS, injection, PII exposure)&lt;/li&gt;&lt;li&gt;Post-processing transformations (whitespace normalization, lowercase, accent removal)&lt;/li&gt;&lt;li&gt;Detailed audit output: issues detected, actions applied, explanations&lt;/li&gt;&lt;li&gt;Risk scoring system (LOW, MEDIUM, HIGH)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Sanitize user-generated HTML content before rendering&lt;/li&gt;&lt;li&gt;Prevent CSV injection before exporting data to Excel&lt;/li&gt;&lt;li&gt;Clean and normalize logs to prevent log forging attacks&lt;/li&gt;&lt;li&gt;Mask sensitive data such as emails and phone numbers&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Request Parameters&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;input&lt;/b&gt;: Raw input string to sanitize&lt;/li&gt;&lt;li&gt;&lt;b&gt;context&lt;/b&gt;: Target context (HTML, JSON, CSV, LOG)&lt;/li&gt;&lt;li&gt;&lt;b&gt;mode&lt;/b&gt;: Sanitization mode (RELAXED, STRICT, HARDENING) necessary just for HTML context, ignored otherwise. Default value RELAXED&lt;/li&gt;&lt;li&gt;&lt;b&gt;operations&lt;/b&gt;: Optional list of transformations (NORMALIZE_WHITESPACE, LOWERCASE, REMOVE_ACCENTS, REMOVE_PII)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Response Fields&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;sanitized&lt;/b&gt;: Final processed output&lt;/li&gt;&lt;li&gt;&lt;b&gt;contextApplied&lt;/b&gt;: Applied context&lt;/li&gt;&lt;li&gt;&lt;b&gt;issuesDetected&lt;/b&gt;: Security or data issues found&lt;/li&gt;&lt;li&gt;&lt;b&gt;actionsApplied&lt;/b&gt;: Operations and sanitization steps executed&lt;/li&gt;&lt;li&gt;&lt;b&gt;explanations&lt;/b&gt;: Human-readable explanations for detected issues&lt;/li&gt;&lt;li&gt;&lt;b&gt;riskLevel&lt;/b&gt;: LOW, MEDIUM, HIGH&lt;/li&gt;&lt;li&gt;&lt;b&gt;riskScore&lt;/b&gt;: Numeric risk score (0–100)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - Sanitization completed successfully
     * <p><b>400</b> - Invalid input or CSV formatting options
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param sanitizationRequest Sanitization request payload. Provide input data, target context, optional mode and operations.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec sanitizeWithResponseSpec(@jakarta.annotation.Nonnull SanitizationRequest sanitizationRequest) throws WebClientResponseException {
        return sanitizeRequestCreation(sanitizationRequest);
    }

    /**
     * Validate input against a set of rules
     * &lt;p&gt;This API validates input data against a configurable set of rules without modifying the original value. It is designed to enforce data integrity, ensure format correctness, and detect potentially unsafe input such as malicious patterns.&lt;/p&gt;&lt;h4&gt;Key Features&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Supports multiple validation rules (EMAIL, PHONE, URL, REGEX, etc.)&lt;/li&gt;&lt;li&gt;Flexible rule configuration with parameters (e.g. MIN_LENGTH:8, MAX_LENGTH:50)&lt;/li&gt;&lt;li&gt;Fail-fast or full validation modes&lt;/li&gt;&lt;li&gt;Built-in security checks (XSS and SQL injection detection)&lt;/li&gt;&lt;li&gt;Extensible validation engine for custom rules&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Validate user input in forms (email, password, phone, etc.)&lt;/li&gt;&lt;li&gt;Enforce backend validation rules before processing data&lt;/li&gt;&lt;li&gt;Detect potentially malicious input (XSS, SQL injection)&lt;/li&gt;&lt;li&gt;Apply centralized validation logic across multiple services&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Request Parameters&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;input&lt;/b&gt;: Raw input string to validate&lt;/li&gt;&lt;li&gt;&lt;b&gt;rules&lt;/b&gt;: List of validation rules to apply (e.g. REQUIRED, EMAIL, MIN_LENGTH:8, REGEX:...)&lt;/li&gt;&lt;li&gt;&lt;b&gt;failFast&lt;/b&gt;: If true, stops validation at the first detected error (default: false)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Supported Rules&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;REQUIRED&lt;/b&gt;: Ensures input is not null or empty&lt;/li&gt;&lt;li&gt;&lt;b&gt;EMAIL&lt;/b&gt;: Validates email format&lt;/li&gt;&lt;li&gt;&lt;b&gt;PHONE&lt;/b&gt;: Validates phone number format&lt;/li&gt;&lt;li&gt;&lt;b&gt;URL&lt;/b&gt;: Validates URL format&lt;/li&gt;&lt;li&gt;&lt;b&gt;MIN_LENGTH:n&lt;/b&gt;: Minimum input length&lt;/li&gt;&lt;li&gt;&lt;b&gt;MAX_LENGTH:n&lt;/b&gt;: Maximum input length&lt;/li&gt;&lt;li&gt;&lt;b&gt;REGEX:pattern&lt;/b&gt;: Custom regex validation&lt;/li&gt;&lt;li&gt;&lt;b&gt;NO_XSS&lt;/b&gt;: Detects potential XSS patterns&lt;/li&gt;&lt;li&gt;&lt;b&gt;NO_SQL_INJECTION&lt;/b&gt;: Detects SQL injection patterns&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - Validation completed successfully
     * <p><b>400</b> - Invalid input or CSV formatting options
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param validateRequest Validate request payload. Provide input data and list of rules necessary to validate data.
     * @return ValidateResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec validateRequestCreation(@jakarta.annotation.Nonnull ValidateRequest validateRequest) throws WebClientResponseException {
        Object postBody = validateRequest;
        // verify the required parameter 'validateRequest' is set
        if (validateRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'validateRequest' when calling validate", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<ValidateResponse> localVarReturnType = new ParameterizedTypeReference<ValidateResponse>() {};
        return apiClient.invokeAPI("/api/v1/data-protection/validate", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Validate input against a set of rules
     * &lt;p&gt;This API validates input data against a configurable set of rules without modifying the original value. It is designed to enforce data integrity, ensure format correctness, and detect potentially unsafe input such as malicious patterns.&lt;/p&gt;&lt;h4&gt;Key Features&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Supports multiple validation rules (EMAIL, PHONE, URL, REGEX, etc.)&lt;/li&gt;&lt;li&gt;Flexible rule configuration with parameters (e.g. MIN_LENGTH:8, MAX_LENGTH:50)&lt;/li&gt;&lt;li&gt;Fail-fast or full validation modes&lt;/li&gt;&lt;li&gt;Built-in security checks (XSS and SQL injection detection)&lt;/li&gt;&lt;li&gt;Extensible validation engine for custom rules&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Validate user input in forms (email, password, phone, etc.)&lt;/li&gt;&lt;li&gt;Enforce backend validation rules before processing data&lt;/li&gt;&lt;li&gt;Detect potentially malicious input (XSS, SQL injection)&lt;/li&gt;&lt;li&gt;Apply centralized validation logic across multiple services&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Request Parameters&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;input&lt;/b&gt;: Raw input string to validate&lt;/li&gt;&lt;li&gt;&lt;b&gt;rules&lt;/b&gt;: List of validation rules to apply (e.g. REQUIRED, EMAIL, MIN_LENGTH:8, REGEX:...)&lt;/li&gt;&lt;li&gt;&lt;b&gt;failFast&lt;/b&gt;: If true, stops validation at the first detected error (default: false)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Supported Rules&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;REQUIRED&lt;/b&gt;: Ensures input is not null or empty&lt;/li&gt;&lt;li&gt;&lt;b&gt;EMAIL&lt;/b&gt;: Validates email format&lt;/li&gt;&lt;li&gt;&lt;b&gt;PHONE&lt;/b&gt;: Validates phone number format&lt;/li&gt;&lt;li&gt;&lt;b&gt;URL&lt;/b&gt;: Validates URL format&lt;/li&gt;&lt;li&gt;&lt;b&gt;MIN_LENGTH:n&lt;/b&gt;: Minimum input length&lt;/li&gt;&lt;li&gt;&lt;b&gt;MAX_LENGTH:n&lt;/b&gt;: Maximum input length&lt;/li&gt;&lt;li&gt;&lt;b&gt;REGEX:pattern&lt;/b&gt;: Custom regex validation&lt;/li&gt;&lt;li&gt;&lt;b&gt;NO_XSS&lt;/b&gt;: Detects potential XSS patterns&lt;/li&gt;&lt;li&gt;&lt;b&gt;NO_SQL_INJECTION&lt;/b&gt;: Detects SQL injection patterns&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - Validation completed successfully
     * <p><b>400</b> - Invalid input or CSV formatting options
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param validateRequest Validate request payload. Provide input data and list of rules necessary to validate data.
     * @return ValidateResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ValidateResponse> validate(@jakarta.annotation.Nonnull ValidateRequest validateRequest) throws WebClientResponseException {
        ParameterizedTypeReference<ValidateResponse> localVarReturnType = new ParameterizedTypeReference<ValidateResponse>() {};
        return validateRequestCreation(validateRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Validate input against a set of rules
     * &lt;p&gt;This API validates input data against a configurable set of rules without modifying the original value. It is designed to enforce data integrity, ensure format correctness, and detect potentially unsafe input such as malicious patterns.&lt;/p&gt;&lt;h4&gt;Key Features&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Supports multiple validation rules (EMAIL, PHONE, URL, REGEX, etc.)&lt;/li&gt;&lt;li&gt;Flexible rule configuration with parameters (e.g. MIN_LENGTH:8, MAX_LENGTH:50)&lt;/li&gt;&lt;li&gt;Fail-fast or full validation modes&lt;/li&gt;&lt;li&gt;Built-in security checks (XSS and SQL injection detection)&lt;/li&gt;&lt;li&gt;Extensible validation engine for custom rules&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Validate user input in forms (email, password, phone, etc.)&lt;/li&gt;&lt;li&gt;Enforce backend validation rules before processing data&lt;/li&gt;&lt;li&gt;Detect potentially malicious input (XSS, SQL injection)&lt;/li&gt;&lt;li&gt;Apply centralized validation logic across multiple services&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Request Parameters&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;input&lt;/b&gt;: Raw input string to validate&lt;/li&gt;&lt;li&gt;&lt;b&gt;rules&lt;/b&gt;: List of validation rules to apply (e.g. REQUIRED, EMAIL, MIN_LENGTH:8, REGEX:...)&lt;/li&gt;&lt;li&gt;&lt;b&gt;failFast&lt;/b&gt;: If true, stops validation at the first detected error (default: false)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Supported Rules&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;REQUIRED&lt;/b&gt;: Ensures input is not null or empty&lt;/li&gt;&lt;li&gt;&lt;b&gt;EMAIL&lt;/b&gt;: Validates email format&lt;/li&gt;&lt;li&gt;&lt;b&gt;PHONE&lt;/b&gt;: Validates phone number format&lt;/li&gt;&lt;li&gt;&lt;b&gt;URL&lt;/b&gt;: Validates URL format&lt;/li&gt;&lt;li&gt;&lt;b&gt;MIN_LENGTH:n&lt;/b&gt;: Minimum input length&lt;/li&gt;&lt;li&gt;&lt;b&gt;MAX_LENGTH:n&lt;/b&gt;: Maximum input length&lt;/li&gt;&lt;li&gt;&lt;b&gt;REGEX:pattern&lt;/b&gt;: Custom regex validation&lt;/li&gt;&lt;li&gt;&lt;b&gt;NO_XSS&lt;/b&gt;: Detects potential XSS patterns&lt;/li&gt;&lt;li&gt;&lt;b&gt;NO_SQL_INJECTION&lt;/b&gt;: Detects SQL injection patterns&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - Validation completed successfully
     * <p><b>400</b> - Invalid input or CSV formatting options
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param validateRequest Validate request payload. Provide input data and list of rules necessary to validate data.
     * @return ResponseEntity&lt;ValidateResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ValidateResponse>> validateWithHttpInfo(@jakarta.annotation.Nonnull ValidateRequest validateRequest) throws WebClientResponseException {
        ParameterizedTypeReference<ValidateResponse> localVarReturnType = new ParameterizedTypeReference<ValidateResponse>() {};
        return validateRequestCreation(validateRequest).toEntity(localVarReturnType);
    }

    /**
     * Validate input against a set of rules
     * &lt;p&gt;This API validates input data against a configurable set of rules without modifying the original value. It is designed to enforce data integrity, ensure format correctness, and detect potentially unsafe input such as malicious patterns.&lt;/p&gt;&lt;h4&gt;Key Features&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Supports multiple validation rules (EMAIL, PHONE, URL, REGEX, etc.)&lt;/li&gt;&lt;li&gt;Flexible rule configuration with parameters (e.g. MIN_LENGTH:8, MAX_LENGTH:50)&lt;/li&gt;&lt;li&gt;Fail-fast or full validation modes&lt;/li&gt;&lt;li&gt;Built-in security checks (XSS and SQL injection detection)&lt;/li&gt;&lt;li&gt;Extensible validation engine for custom rules&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Validate user input in forms (email, password, phone, etc.)&lt;/li&gt;&lt;li&gt;Enforce backend validation rules before processing data&lt;/li&gt;&lt;li&gt;Detect potentially malicious input (XSS, SQL injection)&lt;/li&gt;&lt;li&gt;Apply centralized validation logic across multiple services&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Request Parameters&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;input&lt;/b&gt;: Raw input string to validate&lt;/li&gt;&lt;li&gt;&lt;b&gt;rules&lt;/b&gt;: List of validation rules to apply (e.g. REQUIRED, EMAIL, MIN_LENGTH:8, REGEX:...)&lt;/li&gt;&lt;li&gt;&lt;b&gt;failFast&lt;/b&gt;: If true, stops validation at the first detected error (default: false)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Supported Rules&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;REQUIRED&lt;/b&gt;: Ensures input is not null or empty&lt;/li&gt;&lt;li&gt;&lt;b&gt;EMAIL&lt;/b&gt;: Validates email format&lt;/li&gt;&lt;li&gt;&lt;b&gt;PHONE&lt;/b&gt;: Validates phone number format&lt;/li&gt;&lt;li&gt;&lt;b&gt;URL&lt;/b&gt;: Validates URL format&lt;/li&gt;&lt;li&gt;&lt;b&gt;MIN_LENGTH:n&lt;/b&gt;: Minimum input length&lt;/li&gt;&lt;li&gt;&lt;b&gt;MAX_LENGTH:n&lt;/b&gt;: Maximum input length&lt;/li&gt;&lt;li&gt;&lt;b&gt;REGEX:pattern&lt;/b&gt;: Custom regex validation&lt;/li&gt;&lt;li&gt;&lt;b&gt;NO_XSS&lt;/b&gt;: Detects potential XSS patterns&lt;/li&gt;&lt;li&gt;&lt;b&gt;NO_SQL_INJECTION&lt;/b&gt;: Detects SQL injection patterns&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - Validation completed successfully
     * <p><b>400</b> - Invalid input or CSV formatting options
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param validateRequest Validate request payload. Provide input data and list of rules necessary to validate data.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec validateWithResponseSpec(@jakarta.annotation.Nonnull ValidateRequest validateRequest) throws WebClientResponseException {
        return validateRequestCreation(validateRequest);
    }
}
