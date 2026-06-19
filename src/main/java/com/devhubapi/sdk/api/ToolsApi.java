package com.devhubapi.sdk.api;

import com.devhubapi.sdk.ApiClient;

import com.devhubapi.sdk.model.DevHubErrorResponse;
import com.devhubapi.sdk.model.PasswordRequest;
import com.devhubapi.sdk.model.PasswordResponse;
import com.devhubapi.sdk.model.Text;
import com.devhubapi.sdk.model.UUIDResponse;

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
public class ToolsApi {
    private ApiClient apiClient;

    public ToolsApi() {
        this(new ApiClient());
    }

    public ToolsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Generate a random password
     * Generates a secure and customizable password using either predefined strength presets or manual composition rules.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Four strength presets: &lt;b&gt;WEAK&lt;/b&gt;, &lt;b&gt;MEDIUM&lt;/b&gt;, &lt;b&gt;STRONG&lt;/b&gt;, &lt;b&gt;ULTRA&lt;/b&gt;&lt;/li&gt;&lt;li&gt;Optional manual configuration (letters, numbers, special characters)&lt;/li&gt;&lt;li&gt;Selective exclusion of specific special characters&lt;/li&gt;&lt;li&gt;Uses &lt;code&gt;SecureRandom&lt;/code&gt; for cryptographic-grade randomness&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Behavior:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;If &lt;code&gt;strength&lt;/code&gt; is provided, manual parameters are ignored.&lt;/li&gt;&lt;li&gt;When using a predefined strength, at least one character per category is guaranteed.&lt;/li&gt;&lt;li&gt;Excluded special characters are fully removed from generation.&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - Password successfully generated
     * <p><b>400</b> - Invalid input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many request
     * <p><b>500</b> - Internal Server Error
     * @param passwordRequest The passwordRequest parameter
     * @return PasswordResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec generatePasswordRequestCreation(@jakarta.annotation.Nonnull PasswordRequest passwordRequest) throws WebClientResponseException {
        Object postBody = passwordRequest;
        // verify the required parameter 'passwordRequest' is set
        if (passwordRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'passwordRequest' when calling generatePassword", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PasswordResponse> localVarReturnType = new ParameterizedTypeReference<PasswordResponse>() {};
        return apiClient.invokeAPI("/api/v1/tools/password", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Generate a random password
     * Generates a secure and customizable password using either predefined strength presets or manual composition rules.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Four strength presets: &lt;b&gt;WEAK&lt;/b&gt;, &lt;b&gt;MEDIUM&lt;/b&gt;, &lt;b&gt;STRONG&lt;/b&gt;, &lt;b&gt;ULTRA&lt;/b&gt;&lt;/li&gt;&lt;li&gt;Optional manual configuration (letters, numbers, special characters)&lt;/li&gt;&lt;li&gt;Selective exclusion of specific special characters&lt;/li&gt;&lt;li&gt;Uses &lt;code&gt;SecureRandom&lt;/code&gt; for cryptographic-grade randomness&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Behavior:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;If &lt;code&gt;strength&lt;/code&gt; is provided, manual parameters are ignored.&lt;/li&gt;&lt;li&gt;When using a predefined strength, at least one character per category is guaranteed.&lt;/li&gt;&lt;li&gt;Excluded special characters are fully removed from generation.&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - Password successfully generated
     * <p><b>400</b> - Invalid input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many request
     * <p><b>500</b> - Internal Server Error
     * @param passwordRequest The passwordRequest parameter
     * @return PasswordResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PasswordResponse> generatePassword(@jakarta.annotation.Nonnull PasswordRequest passwordRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PasswordResponse> localVarReturnType = new ParameterizedTypeReference<PasswordResponse>() {};
        return generatePasswordRequestCreation(passwordRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Generate a random password
     * Generates a secure and customizable password using either predefined strength presets or manual composition rules.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Four strength presets: &lt;b&gt;WEAK&lt;/b&gt;, &lt;b&gt;MEDIUM&lt;/b&gt;, &lt;b&gt;STRONG&lt;/b&gt;, &lt;b&gt;ULTRA&lt;/b&gt;&lt;/li&gt;&lt;li&gt;Optional manual configuration (letters, numbers, special characters)&lt;/li&gt;&lt;li&gt;Selective exclusion of specific special characters&lt;/li&gt;&lt;li&gt;Uses &lt;code&gt;SecureRandom&lt;/code&gt; for cryptographic-grade randomness&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Behavior:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;If &lt;code&gt;strength&lt;/code&gt; is provided, manual parameters are ignored.&lt;/li&gt;&lt;li&gt;When using a predefined strength, at least one character per category is guaranteed.&lt;/li&gt;&lt;li&gt;Excluded special characters are fully removed from generation.&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - Password successfully generated
     * <p><b>400</b> - Invalid input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many request
     * <p><b>500</b> - Internal Server Error
     * @param passwordRequest The passwordRequest parameter
     * @return ResponseEntity&lt;PasswordResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PasswordResponse>> generatePasswordWithHttpInfo(@jakarta.annotation.Nonnull PasswordRequest passwordRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PasswordResponse> localVarReturnType = new ParameterizedTypeReference<PasswordResponse>() {};
        return generatePasswordRequestCreation(passwordRequest).toEntity(localVarReturnType);
    }

    /**
     * Generate a random password
     * Generates a secure and customizable password using either predefined strength presets or manual composition rules.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Four strength presets: &lt;b&gt;WEAK&lt;/b&gt;, &lt;b&gt;MEDIUM&lt;/b&gt;, &lt;b&gt;STRONG&lt;/b&gt;, &lt;b&gt;ULTRA&lt;/b&gt;&lt;/li&gt;&lt;li&gt;Optional manual configuration (letters, numbers, special characters)&lt;/li&gt;&lt;li&gt;Selective exclusion of specific special characters&lt;/li&gt;&lt;li&gt;Uses &lt;code&gt;SecureRandom&lt;/code&gt; for cryptographic-grade randomness&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Behavior:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;If &lt;code&gt;strength&lt;/code&gt; is provided, manual parameters are ignored.&lt;/li&gt;&lt;li&gt;When using a predefined strength, at least one character per category is guaranteed.&lt;/li&gt;&lt;li&gt;Excluded special characters are fully removed from generation.&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - Password successfully generated
     * <p><b>400</b> - Invalid input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many request
     * <p><b>500</b> - Internal Server Error
     * @param passwordRequest The passwordRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec generatePasswordWithResponseSpec(@jakarta.annotation.Nonnull PasswordRequest passwordRequest) throws WebClientResponseException {
        return generatePasswordRequestCreation(passwordRequest);
    }

    /**
     * Generate UUID (v4 or v5)
     * Generates UUID version 4 (random) or version 5 (deterministic, namespace-based).&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Generate between 1 and 100 UUIDs for v4&lt;/li&gt;&lt;li&gt;Generate deterministic UUID v5 using namespace + name&lt;/li&gt;&lt;li&gt;Suitable for unique identifiers or reproducible resource IDs&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Behavior:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Default version is &lt;b&gt;v4&lt;/b&gt;&lt;/li&gt;&lt;li&gt;For &lt;b&gt;v5&lt;/b&gt;, both &lt;code&gt;namespace&lt;/code&gt; and &lt;code&gt;name&lt;/code&gt; are required&lt;/li&gt;&lt;li&gt;UUID v5 is deterministic: same namespace + name → same UUID&lt;/li&gt;&lt;li&gt;For v5, &lt;code&gt;count&lt;/code&gt; must be exactly &lt;b&gt;1&lt;/b&gt;&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - UUID(s) successfully generated
     * <p><b>400</b> - Invalid input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many request
     * <p><b>500</b> - Internal Server Error
     * @param version UID version to generate. Must be &lt;b&gt;v4&lt;/b&gt; for random UUID (non-deterministic) or &lt;b&gt;v5&lt;/b&gt; for namespaced UUID (deterministic, based on namespace + name). Default value is &lt;code&gt;v4&lt;/code&gt;
     * @param count Number of UUIDs to generate. Must be between &lt;b&gt;1&lt;/b&gt; and &lt;b&gt;100&lt;/b&gt; for &lt;b&gt;v4&lt;/b&gt; and exactly &lt;b&gt;1&lt;/b&gt; to &lt;b&gt;v5&lt;/b&gt; (deterministic generation). Default value is &lt;code&gt;1&lt;/code&gt;
     * @param namespace Required only for &lt;b&gt;v5&lt;/b&gt; (namespaced deterministic generation). No strict UUID format required
     * @param name Name value used for UUID v5 generation. Required only when &lt;code&gt;version &#x3D; v5&lt;/code&gt;. The same &lt;code&gt;namespace&lt;/code&gt; + &lt;code&gt;name&lt;/code&gt; combination will always generate the same UUID
     * @return UUIDResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec generateUuidRequestCreation(@jakarta.annotation.Nullable String version, @jakarta.annotation.Nullable Integer count, @jakarta.annotation.Nullable String namespace, @jakarta.annotation.Nullable String name) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "count", count));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "namespace", namespace));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<UUIDResponse> localVarReturnType = new ParameterizedTypeReference<UUIDResponse>() {};
        return apiClient.invokeAPI("/api/v1/tools/uuid", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Generate UUID (v4 or v5)
     * Generates UUID version 4 (random) or version 5 (deterministic, namespace-based).&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Generate between 1 and 100 UUIDs for v4&lt;/li&gt;&lt;li&gt;Generate deterministic UUID v5 using namespace + name&lt;/li&gt;&lt;li&gt;Suitable for unique identifiers or reproducible resource IDs&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Behavior:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Default version is &lt;b&gt;v4&lt;/b&gt;&lt;/li&gt;&lt;li&gt;For &lt;b&gt;v5&lt;/b&gt;, both &lt;code&gt;namespace&lt;/code&gt; and &lt;code&gt;name&lt;/code&gt; are required&lt;/li&gt;&lt;li&gt;UUID v5 is deterministic: same namespace + name → same UUID&lt;/li&gt;&lt;li&gt;For v5, &lt;code&gt;count&lt;/code&gt; must be exactly &lt;b&gt;1&lt;/b&gt;&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - UUID(s) successfully generated
     * <p><b>400</b> - Invalid input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many request
     * <p><b>500</b> - Internal Server Error
     * @param version UID version to generate. Must be &lt;b&gt;v4&lt;/b&gt; for random UUID (non-deterministic) or &lt;b&gt;v5&lt;/b&gt; for namespaced UUID (deterministic, based on namespace + name). Default value is &lt;code&gt;v4&lt;/code&gt;
     * @param count Number of UUIDs to generate. Must be between &lt;b&gt;1&lt;/b&gt; and &lt;b&gt;100&lt;/b&gt; for &lt;b&gt;v4&lt;/b&gt; and exactly &lt;b&gt;1&lt;/b&gt; to &lt;b&gt;v5&lt;/b&gt; (deterministic generation). Default value is &lt;code&gt;1&lt;/code&gt;
     * @param namespace Required only for &lt;b&gt;v5&lt;/b&gt; (namespaced deterministic generation). No strict UUID format required
     * @param name Name value used for UUID v5 generation. Required only when &lt;code&gt;version &#x3D; v5&lt;/code&gt;. The same &lt;code&gt;namespace&lt;/code&gt; + &lt;code&gt;name&lt;/code&gt; combination will always generate the same UUID
     * @return UUIDResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<UUIDResponse> generateUuid(@jakarta.annotation.Nullable String version, @jakarta.annotation.Nullable Integer count, @jakarta.annotation.Nullable String namespace, @jakarta.annotation.Nullable String name) throws WebClientResponseException {
        ParameterizedTypeReference<UUIDResponse> localVarReturnType = new ParameterizedTypeReference<UUIDResponse>() {};
        return generateUuidRequestCreation(version, count, namespace, name).bodyToMono(localVarReturnType);
    }

    /**
     * Generate UUID (v4 or v5)
     * Generates UUID version 4 (random) or version 5 (deterministic, namespace-based).&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Generate between 1 and 100 UUIDs for v4&lt;/li&gt;&lt;li&gt;Generate deterministic UUID v5 using namespace + name&lt;/li&gt;&lt;li&gt;Suitable for unique identifiers or reproducible resource IDs&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Behavior:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Default version is &lt;b&gt;v4&lt;/b&gt;&lt;/li&gt;&lt;li&gt;For &lt;b&gt;v5&lt;/b&gt;, both &lt;code&gt;namespace&lt;/code&gt; and &lt;code&gt;name&lt;/code&gt; are required&lt;/li&gt;&lt;li&gt;UUID v5 is deterministic: same namespace + name → same UUID&lt;/li&gt;&lt;li&gt;For v5, &lt;code&gt;count&lt;/code&gt; must be exactly &lt;b&gt;1&lt;/b&gt;&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - UUID(s) successfully generated
     * <p><b>400</b> - Invalid input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many request
     * <p><b>500</b> - Internal Server Error
     * @param version UID version to generate. Must be &lt;b&gt;v4&lt;/b&gt; for random UUID (non-deterministic) or &lt;b&gt;v5&lt;/b&gt; for namespaced UUID (deterministic, based on namespace + name). Default value is &lt;code&gt;v4&lt;/code&gt;
     * @param count Number of UUIDs to generate. Must be between &lt;b&gt;1&lt;/b&gt; and &lt;b&gt;100&lt;/b&gt; for &lt;b&gt;v4&lt;/b&gt; and exactly &lt;b&gt;1&lt;/b&gt; to &lt;b&gt;v5&lt;/b&gt; (deterministic generation). Default value is &lt;code&gt;1&lt;/code&gt;
     * @param namespace Required only for &lt;b&gt;v5&lt;/b&gt; (namespaced deterministic generation). No strict UUID format required
     * @param name Name value used for UUID v5 generation. Required only when &lt;code&gt;version &#x3D; v5&lt;/code&gt;. The same &lt;code&gt;namespace&lt;/code&gt; + &lt;code&gt;name&lt;/code&gt; combination will always generate the same UUID
     * @return ResponseEntity&lt;UUIDResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<UUIDResponse>> generateUuidWithHttpInfo(@jakarta.annotation.Nullable String version, @jakarta.annotation.Nullable Integer count, @jakarta.annotation.Nullable String namespace, @jakarta.annotation.Nullable String name) throws WebClientResponseException {
        ParameterizedTypeReference<UUIDResponse> localVarReturnType = new ParameterizedTypeReference<UUIDResponse>() {};
        return generateUuidRequestCreation(version, count, namespace, name).toEntity(localVarReturnType);
    }

    /**
     * Generate UUID (v4 or v5)
     * Generates UUID version 4 (random) or version 5 (deterministic, namespace-based).&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Generate between 1 and 100 UUIDs for v4&lt;/li&gt;&lt;li&gt;Generate deterministic UUID v5 using namespace + name&lt;/li&gt;&lt;li&gt;Suitable for unique identifiers or reproducible resource IDs&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Behavior:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Default version is &lt;b&gt;v4&lt;/b&gt;&lt;/li&gt;&lt;li&gt;For &lt;b&gt;v5&lt;/b&gt;, both &lt;code&gt;namespace&lt;/code&gt; and &lt;code&gt;name&lt;/code&gt; are required&lt;/li&gt;&lt;li&gt;UUID v5 is deterministic: same namespace + name → same UUID&lt;/li&gt;&lt;li&gt;For v5, &lt;code&gt;count&lt;/code&gt; must be exactly &lt;b&gt;1&lt;/b&gt;&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - UUID(s) successfully generated
     * <p><b>400</b> - Invalid input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many request
     * <p><b>500</b> - Internal Server Error
     * @param version UID version to generate. Must be &lt;b&gt;v4&lt;/b&gt; for random UUID (non-deterministic) or &lt;b&gt;v5&lt;/b&gt; for namespaced UUID (deterministic, based on namespace + name). Default value is &lt;code&gt;v4&lt;/code&gt;
     * @param count Number of UUIDs to generate. Must be between &lt;b&gt;1&lt;/b&gt; and &lt;b&gt;100&lt;/b&gt; for &lt;b&gt;v4&lt;/b&gt; and exactly &lt;b&gt;1&lt;/b&gt; to &lt;b&gt;v5&lt;/b&gt; (deterministic generation). Default value is &lt;code&gt;1&lt;/code&gt;
     * @param namespace Required only for &lt;b&gt;v5&lt;/b&gt; (namespaced deterministic generation). No strict UUID format required
     * @param name Name value used for UUID v5 generation. Required only when &lt;code&gt;version &#x3D; v5&lt;/code&gt;. The same &lt;code&gt;namespace&lt;/code&gt; + &lt;code&gt;name&lt;/code&gt; combination will always generate the same UUID
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec generateUuidWithResponseSpec(@jakarta.annotation.Nullable String version, @jakarta.annotation.Nullable Integer count, @jakarta.annotation.Nullable String namespace, @jakarta.annotation.Nullable String name) throws WebClientResponseException {
        return generateUuidRequestCreation(version, count, namespace, name);
    }

    /**
     * Minify CSS
     * Minifies a CSS string using YUI Compressor for reliable and optimized output.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Removes unnecessary whitespace and comments&lt;/li&gt;&lt;li&gt;Removes redundant semicolons&lt;/li&gt;&lt;li&gt;Fully compatible with valid CSS3 syntax&lt;/li&gt;&lt;li&gt;Optimized for production deployment and automation pipelines&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Maximum input size: 10MiB&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - CSS successfully minified
     * <p><b>400</b> - Invalid input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many request
     * <p><b>500</b> - Internal Server Error
     * @param body The body parameter
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec minifyCssRequestCreation(@jakarta.annotation.Nonnull String body) throws WebClientResponseException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new WebClientResponseException("Missing the required parameter 'body' when calling minifyCss", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "text/plain", "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "text/plain"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/api/v1/tools/minify-css", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Minify CSS
     * Minifies a CSS string using YUI Compressor for reliable and optimized output.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Removes unnecessary whitespace and comments&lt;/li&gt;&lt;li&gt;Removes redundant semicolons&lt;/li&gt;&lt;li&gt;Fully compatible with valid CSS3 syntax&lt;/li&gt;&lt;li&gt;Optimized for production deployment and automation pipelines&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Maximum input size: 10MiB&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - CSS successfully minified
     * <p><b>400</b> - Invalid input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many request
     * <p><b>500</b> - Internal Server Error
     * @param body The body parameter
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<String> minifyCss(@jakarta.annotation.Nonnull String body) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return minifyCssRequestCreation(body).bodyToMono(localVarReturnType);
    }

    /**
     * Minify CSS
     * Minifies a CSS string using YUI Compressor for reliable and optimized output.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Removes unnecessary whitespace and comments&lt;/li&gt;&lt;li&gt;Removes redundant semicolons&lt;/li&gt;&lt;li&gt;Fully compatible with valid CSS3 syntax&lt;/li&gt;&lt;li&gt;Optimized for production deployment and automation pipelines&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Maximum input size: 10MiB&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - CSS successfully minified
     * <p><b>400</b> - Invalid input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many request
     * <p><b>500</b> - Internal Server Error
     * @param body The body parameter
     * @return ResponseEntity&lt;String&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<String>> minifyCssWithHttpInfo(@jakarta.annotation.Nonnull String body) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return minifyCssRequestCreation(body).toEntity(localVarReturnType);
    }

    /**
     * Minify CSS
     * Minifies a CSS string using YUI Compressor for reliable and optimized output.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Removes unnecessary whitespace and comments&lt;/li&gt;&lt;li&gt;Removes redundant semicolons&lt;/li&gt;&lt;li&gt;Fully compatible with valid CSS3 syntax&lt;/li&gt;&lt;li&gt;Optimized for production deployment and automation pipelines&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Maximum input size: 10MiB&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - CSS successfully minified
     * <p><b>400</b> - Invalid input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many request
     * <p><b>500</b> - Internal Server Error
     * @param body The body parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec minifyCssWithResponseSpec(@jakarta.annotation.Nonnull String body) throws WebClientResponseException {
        return minifyCssRequestCreation(body);
    }

    /**
     * Minify JavaScript
     * Minifies a JavaScript string to reduce size and optimize delivery for frontend applications.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Removes unnecessary whitespace and comments&lt;/li&gt;&lt;li&gt;Optimizes output for production environments&lt;/li&gt;&lt;li&gt;Preserves valid JavaScript semantics&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation &amp; Security:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Maximum input size: 10MiB&lt;/li&gt;&lt;li&gt;Performs advanced security analysis to detect potentially unsafe constructs&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - JavaScript successfully minified
     * <p><b>400</b> - Invalid input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many request
     * <p><b>500</b> - Internal Server Error
     * @param body The body parameter
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec minifyJsRequestCreation(@jakarta.annotation.Nonnull String body) throws WebClientResponseException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new WebClientResponseException("Missing the required parameter 'body' when calling minifyJs", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "text/plain", "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "text/plain"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/api/v1/tools/minify-js", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Minify JavaScript
     * Minifies a JavaScript string to reduce size and optimize delivery for frontend applications.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Removes unnecessary whitespace and comments&lt;/li&gt;&lt;li&gt;Optimizes output for production environments&lt;/li&gt;&lt;li&gt;Preserves valid JavaScript semantics&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation &amp; Security:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Maximum input size: 10MiB&lt;/li&gt;&lt;li&gt;Performs advanced security analysis to detect potentially unsafe constructs&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - JavaScript successfully minified
     * <p><b>400</b> - Invalid input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many request
     * <p><b>500</b> - Internal Server Error
     * @param body The body parameter
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<String> minifyJs(@jakarta.annotation.Nonnull String body) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return minifyJsRequestCreation(body).bodyToMono(localVarReturnType);
    }

    /**
     * Minify JavaScript
     * Minifies a JavaScript string to reduce size and optimize delivery for frontend applications.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Removes unnecessary whitespace and comments&lt;/li&gt;&lt;li&gt;Optimizes output for production environments&lt;/li&gt;&lt;li&gt;Preserves valid JavaScript semantics&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation &amp; Security:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Maximum input size: 10MiB&lt;/li&gt;&lt;li&gt;Performs advanced security analysis to detect potentially unsafe constructs&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - JavaScript successfully minified
     * <p><b>400</b> - Invalid input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many request
     * <p><b>500</b> - Internal Server Error
     * @param body The body parameter
     * @return ResponseEntity&lt;String&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<String>> minifyJsWithHttpInfo(@jakarta.annotation.Nonnull String body) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return minifyJsRequestCreation(body).toEntity(localVarReturnType);
    }

    /**
     * Minify JavaScript
     * Minifies a JavaScript string to reduce size and optimize delivery for frontend applications.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Removes unnecessary whitespace and comments&lt;/li&gt;&lt;li&gt;Optimizes output for production environments&lt;/li&gt;&lt;li&gt;Preserves valid JavaScript semantics&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation &amp; Security:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Maximum input size: 10MiB&lt;/li&gt;&lt;li&gt;Performs advanced security analysis to detect potentially unsafe constructs&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.
     * <p><b>200</b> - JavaScript successfully minified
     * <p><b>400</b> - Invalid input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many request
     * <p><b>500</b> - Internal Server Error
     * @param body The body parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec minifyJsWithResponseSpec(@jakarta.annotation.Nonnull String body) throws WebClientResponseException {
        return minifyJsRequestCreation(body);
    }

    /**
     * Reverse a text
     * Reverses the provided text string and returns the reversed value.
     * <p><b>200</b> - Text successfully reversed
     * <p><b>400</b> - Invalid input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many request
     * <p><b>500</b> - Internal Server Error
     * @param text The text parameter
     * @return Text
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec reverseRequestCreation(@jakarta.annotation.Nonnull Text text) throws WebClientResponseException {
        Object postBody = text;
        // verify the required parameter 'text' is set
        if (text == null) {
            throw new WebClientResponseException("Missing the required parameter 'text' when calling reverse", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<Text> localVarReturnType = new ParameterizedTypeReference<Text>() {};
        return apiClient.invokeAPI("/api/v1/tools/reverse", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Reverse a text
     * Reverses the provided text string and returns the reversed value.
     * <p><b>200</b> - Text successfully reversed
     * <p><b>400</b> - Invalid input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many request
     * <p><b>500</b> - Internal Server Error
     * @param text The text parameter
     * @return Text
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Text> reverse(@jakarta.annotation.Nonnull Text text) throws WebClientResponseException {
        ParameterizedTypeReference<Text> localVarReturnType = new ParameterizedTypeReference<Text>() {};
        return reverseRequestCreation(text).bodyToMono(localVarReturnType);
    }

    /**
     * Reverse a text
     * Reverses the provided text string and returns the reversed value.
     * <p><b>200</b> - Text successfully reversed
     * <p><b>400</b> - Invalid input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many request
     * <p><b>500</b> - Internal Server Error
     * @param text The text parameter
     * @return ResponseEntity&lt;Text&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Text>> reverseWithHttpInfo(@jakarta.annotation.Nonnull Text text) throws WebClientResponseException {
        ParameterizedTypeReference<Text> localVarReturnType = new ParameterizedTypeReference<Text>() {};
        return reverseRequestCreation(text).toEntity(localVarReturnType);
    }

    /**
     * Reverse a text
     * Reverses the provided text string and returns the reversed value.
     * <p><b>200</b> - Text successfully reversed
     * <p><b>400</b> - Invalid input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many request
     * <p><b>500</b> - Internal Server Error
     * @param text The text parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec reverseWithResponseSpec(@jakarta.annotation.Nonnull Text text) throws WebClientResponseException {
        return reverseRequestCreation(text);
    }
}
