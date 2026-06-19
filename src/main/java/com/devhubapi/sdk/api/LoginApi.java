package com.devhubapi.sdk.api;

import com.devhubapi.sdk.ApiClient;

import com.devhubapi.sdk.model.AuthRequest;
import com.devhubapi.sdk.model.AuthResponse;
import com.devhubapi.sdk.model.DevHubErrorResponse;
import com.devhubapi.sdk.model.RefreshTokenRequest;

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
public class LoginApi {
    private ApiClient apiClient;

    public LoginApi() {
        this(new ApiClient());
    }

    public LoginApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * The service authenticates the API Client by username and password
     * It returns the Bearer token in case of valid credentials, unauthorized (401) otherwise
     * <p><b>200</b> - Valid credentials
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * @param authRequest The authRequest parameter
     * @return AuthResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec loginRequestCreation(@jakarta.annotation.Nonnull AuthRequest authRequest) throws WebClientResponseException {
        Object postBody = authRequest;
        // verify the required parameter 'authRequest' is set
        if (authRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'authRequest' when calling login", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<AuthResponse> localVarReturnType = new ParameterizedTypeReference<AuthResponse>() {};
        return apiClient.invokeAPI("/api/v1/login", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * The service authenticates the API Client by username and password
     * It returns the Bearer token in case of valid credentials, unauthorized (401) otherwise
     * <p><b>200</b> - Valid credentials
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * @param authRequest The authRequest parameter
     * @return AuthResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<AuthResponse> login(@jakarta.annotation.Nonnull AuthRequest authRequest) throws WebClientResponseException {
        ParameterizedTypeReference<AuthResponse> localVarReturnType = new ParameterizedTypeReference<AuthResponse>() {};
        return loginRequestCreation(authRequest).bodyToMono(localVarReturnType);
    }

    /**
     * The service authenticates the API Client by username and password
     * It returns the Bearer token in case of valid credentials, unauthorized (401) otherwise
     * <p><b>200</b> - Valid credentials
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * @param authRequest The authRequest parameter
     * @return ResponseEntity&lt;AuthResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<AuthResponse>> loginWithHttpInfo(@jakarta.annotation.Nonnull AuthRequest authRequest) throws WebClientResponseException {
        ParameterizedTypeReference<AuthResponse> localVarReturnType = new ParameterizedTypeReference<AuthResponse>() {};
        return loginRequestCreation(authRequest).toEntity(localVarReturnType);
    }

    /**
     * The service authenticates the API Client by username and password
     * It returns the Bearer token in case of valid credentials, unauthorized (401) otherwise
     * <p><b>200</b> - Valid credentials
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * @param authRequest The authRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec loginWithResponseSpec(@jakarta.annotation.Nonnull AuthRequest authRequest) throws WebClientResponseException {
        return loginRequestCreation(authRequest);
    }

    /**
     * Refresh JWT access token using a valid refresh token
     * Returns a new access token and optionally a new refresh token
     * <p><b>200</b> - New access token issued
     * <p><b>401</b> - Unauthorized
     * @param refreshTokenRequest The refreshTokenRequest parameter
     * @return AuthResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec refreshTokenRequestCreation(@jakarta.annotation.Nonnull RefreshTokenRequest refreshTokenRequest) throws WebClientResponseException {
        Object postBody = refreshTokenRequest;
        // verify the required parameter 'refreshTokenRequest' is set
        if (refreshTokenRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'refreshTokenRequest' when calling refreshToken", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<AuthResponse> localVarReturnType = new ParameterizedTypeReference<AuthResponse>() {};
        return apiClient.invokeAPI("/api/v1/refresh-token", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Refresh JWT access token using a valid refresh token
     * Returns a new access token and optionally a new refresh token
     * <p><b>200</b> - New access token issued
     * <p><b>401</b> - Unauthorized
     * @param refreshTokenRequest The refreshTokenRequest parameter
     * @return AuthResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<AuthResponse> refreshToken(@jakarta.annotation.Nonnull RefreshTokenRequest refreshTokenRequest) throws WebClientResponseException {
        ParameterizedTypeReference<AuthResponse> localVarReturnType = new ParameterizedTypeReference<AuthResponse>() {};
        return refreshTokenRequestCreation(refreshTokenRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Refresh JWT access token using a valid refresh token
     * Returns a new access token and optionally a new refresh token
     * <p><b>200</b> - New access token issued
     * <p><b>401</b> - Unauthorized
     * @param refreshTokenRequest The refreshTokenRequest parameter
     * @return ResponseEntity&lt;AuthResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<AuthResponse>> refreshTokenWithHttpInfo(@jakarta.annotation.Nonnull RefreshTokenRequest refreshTokenRequest) throws WebClientResponseException {
        ParameterizedTypeReference<AuthResponse> localVarReturnType = new ParameterizedTypeReference<AuthResponse>() {};
        return refreshTokenRequestCreation(refreshTokenRequest).toEntity(localVarReturnType);
    }

    /**
     * Refresh JWT access token using a valid refresh token
     * Returns a new access token and optionally a new refresh token
     * <p><b>200</b> - New access token issued
     * <p><b>401</b> - Unauthorized
     * @param refreshTokenRequest The refreshTokenRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec refreshTokenWithResponseSpec(@jakarta.annotation.Nonnull RefreshTokenRequest refreshTokenRequest) throws WebClientResponseException {
        return refreshTokenRequestCreation(refreshTokenRequest);
    }
}
