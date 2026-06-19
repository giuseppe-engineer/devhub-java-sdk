# DataProtectionApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**sanitize**](DataProtectionApi.md#sanitize) | **POST** /api/v1/data-protection/sanitize | Sanitize and secure input data across multiple contexts |
| [**validate**](DataProtectionApi.md#validate) | **POST** /api/v1/data-protection/validate | Validate input against a set of rules |



## sanitize

> SanitizationResult sanitize(sanitizationRequest)

Sanitize and secure input data across multiple contexts

&lt;p&gt;This API sanitizes input data based on the specified context (HTML, JSON, CSV, LOG) and optional post-processing operations. It is designed to prevent common security risks such as XSS, CSV injection, log injection, and sensitive data exposure.&lt;/p&gt;&lt;h4&gt;Key Features&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Context-aware sanitization (HTML, JSON, CSV, LOG)&lt;/li&gt;&lt;li&gt;Detection and mitigation of security threats (XSS, injection, PII exposure)&lt;/li&gt;&lt;li&gt;Post-processing transformations (whitespace normalization, lowercase, accent removal)&lt;/li&gt;&lt;li&gt;Detailed audit output: issues detected, actions applied, explanations&lt;/li&gt;&lt;li&gt;Risk scoring system (LOW, MEDIUM, HIGH)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Sanitize user-generated HTML content before rendering&lt;/li&gt;&lt;li&gt;Prevent CSV injection before exporting data to Excel&lt;/li&gt;&lt;li&gt;Clean and normalize logs to prevent log forging attacks&lt;/li&gt;&lt;li&gt;Mask sensitive data such as emails and phone numbers&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Request Parameters&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;input&lt;/b&gt;: Raw input string to sanitize&lt;/li&gt;&lt;li&gt;&lt;b&gt;context&lt;/b&gt;: Target context (HTML, JSON, CSV, LOG)&lt;/li&gt;&lt;li&gt;&lt;b&gt;mode&lt;/b&gt;: Sanitization mode (RELAXED, STRICT, HARDENING) necessary just for HTML context, ignored otherwise. Default value RELAXED&lt;/li&gt;&lt;li&gt;&lt;b&gt;operations&lt;/b&gt;: Optional list of transformations (NORMALIZE_WHITESPACE, LOWERCASE, REMOVE_ACCENTS, REMOVE_PII)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Response Fields&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;sanitized&lt;/b&gt;: Final processed output&lt;/li&gt;&lt;li&gt;&lt;b&gt;contextApplied&lt;/b&gt;: Applied context&lt;/li&gt;&lt;li&gt;&lt;b&gt;issuesDetected&lt;/b&gt;: Security or data issues found&lt;/li&gt;&lt;li&gt;&lt;b&gt;actionsApplied&lt;/b&gt;: Operations and sanitization steps executed&lt;/li&gt;&lt;li&gt;&lt;b&gt;explanations&lt;/b&gt;: Human-readable explanations for detected issues&lt;/li&gt;&lt;li&gt;&lt;b&gt;riskLevel&lt;/b&gt;: LOW, MEDIUM, HIGH&lt;/li&gt;&lt;li&gt;&lt;b&gt;riskScore&lt;/b&gt;: Numeric risk score (0–100)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.

### Example

```java
// Import classes:
import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.ApiException;
import com.devhubapi.sdk.Configuration;
import com.devhubapi.sdk.auth.*;
import com.devhubapi.sdk.models.*;
import com.devhubapi.sdk.api.DataProtectionApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        DataProtectionApi apiInstance = new DataProtectionApi(defaultClient);
        SanitizationRequest sanitizationRequest = new SanitizationRequest(); // SanitizationRequest | Sanitization request payload. Provide input data, target context, optional mode and operations.
        try {
            SanitizationResult result = apiInstance.sanitize(sanitizationRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DataProtectionApi#sanitize");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **sanitizationRequest** | [**SanitizationRequest**](SanitizationRequest.md)| Sanitization request payload. Provide input data, target context, optional mode and operations. | |

### Return type

[**SanitizationResult**](SanitizationResult.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Sanitization completed successfully |  -  |
| **400** | Invalid input or CSV formatting options |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **429** | Too many requests |  -  |
| **500** | Internal server error |  -  |


## validate

> ValidateResponse validate(validateRequest)

Validate input against a set of rules

&lt;p&gt;This API validates input data against a configurable set of rules without modifying the original value. It is designed to enforce data integrity, ensure format correctness, and detect potentially unsafe input such as malicious patterns.&lt;/p&gt;&lt;h4&gt;Key Features&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Supports multiple validation rules (EMAIL, PHONE, URL, REGEX, etc.)&lt;/li&gt;&lt;li&gt;Flexible rule configuration with parameters (e.g. MIN_LENGTH:8, MAX_LENGTH:50)&lt;/li&gt;&lt;li&gt;Fail-fast or full validation modes&lt;/li&gt;&lt;li&gt;Built-in security checks (XSS and SQL injection detection)&lt;/li&gt;&lt;li&gt;Extensible validation engine for custom rules&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Validate user input in forms (email, password, phone, etc.)&lt;/li&gt;&lt;li&gt;Enforce backend validation rules before processing data&lt;/li&gt;&lt;li&gt;Detect potentially malicious input (XSS, SQL injection)&lt;/li&gt;&lt;li&gt;Apply centralized validation logic across multiple services&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Request Parameters&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;input&lt;/b&gt;: Raw input string to validate&lt;/li&gt;&lt;li&gt;&lt;b&gt;rules&lt;/b&gt;: List of validation rules to apply (e.g. REQUIRED, EMAIL, MIN_LENGTH:8, REGEX:...)&lt;/li&gt;&lt;li&gt;&lt;b&gt;failFast&lt;/b&gt;: If true, stops validation at the first detected error (default: false)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Supported Rules&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;REQUIRED&lt;/b&gt;: Ensures input is not null or empty&lt;/li&gt;&lt;li&gt;&lt;b&gt;EMAIL&lt;/b&gt;: Validates email format&lt;/li&gt;&lt;li&gt;&lt;b&gt;PHONE&lt;/b&gt;: Validates phone number format&lt;/li&gt;&lt;li&gt;&lt;b&gt;URL&lt;/b&gt;: Validates URL format&lt;/li&gt;&lt;li&gt;&lt;b&gt;MIN_LENGTH:n&lt;/b&gt;: Minimum input length&lt;/li&gt;&lt;li&gt;&lt;b&gt;MAX_LENGTH:n&lt;/b&gt;: Maximum input length&lt;/li&gt;&lt;li&gt;&lt;b&gt;REGEX:pattern&lt;/b&gt;: Custom regex validation&lt;/li&gt;&lt;li&gt;&lt;b&gt;NO_XSS&lt;/b&gt;: Detects potential XSS patterns&lt;/li&gt;&lt;li&gt;&lt;b&gt;NO_SQL_INJECTION&lt;/b&gt;: Detects SQL injection patterns&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.

### Example

```java
// Import classes:
import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.ApiException;
import com.devhubapi.sdk.Configuration;
import com.devhubapi.sdk.auth.*;
import com.devhubapi.sdk.models.*;
import com.devhubapi.sdk.api.DataProtectionApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        DataProtectionApi apiInstance = new DataProtectionApi(defaultClient);
        ValidateRequest validateRequest = new ValidateRequest(); // ValidateRequest | Validate request payload. Provide input data and list of rules necessary to validate data.
        try {
            ValidateResponse result = apiInstance.validate(validateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DataProtectionApi#validate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **validateRequest** | [**ValidateRequest**](ValidateRequest.md)| Validate request payload. Provide input data and list of rules necessary to validate data. | |

### Return type

[**ValidateResponse**](ValidateResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Validation completed successfully |  -  |
| **400** | Invalid input or CSV formatting options |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **429** | Too many requests |  -  |
| **500** | Internal server error |  -  |

