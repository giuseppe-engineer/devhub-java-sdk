# LoginApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**login**](LoginApi.md#login) | **POST** /api/v1/login | The service authenticates the API Client by username and password |
| [**refreshToken**](LoginApi.md#refreshToken) | **POST** /api/v1/refresh-token | Refresh JWT access token using a valid refresh token |



## login

> AuthResponse login(authRequest)

The service authenticates the API Client by username and password

It returns the Bearer token in case of valid credentials, unauthorized (401) otherwise

### Example

```java
// Import classes:
import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.ApiException;
import com.devhubapi.sdk.Configuration;
import com.devhubapi.sdk.auth.*;
import com.devhubapi.sdk.models.*;
import com.devhubapi.sdk.api.LoginApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        LoginApi apiInstance = new LoginApi(defaultClient);
        AuthRequest authRequest = new AuthRequest(); // AuthRequest | 
        try {
            AuthResponse result = apiInstance.login(authRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling LoginApi#login");
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
| **authRequest** | [**AuthRequest**](AuthRequest.md)|  | |

### Return type

[**AuthResponse**](AuthResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Valid credentials |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |


## refreshToken

> AuthResponse refreshToken(refreshTokenRequest)

Refresh JWT access token using a valid refresh token

Returns a new access token and optionally a new refresh token

### Example

```java
// Import classes:
import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.ApiException;
import com.devhubapi.sdk.Configuration;
import com.devhubapi.sdk.auth.*;
import com.devhubapi.sdk.models.*;
import com.devhubapi.sdk.api.LoginApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        LoginApi apiInstance = new LoginApi(defaultClient);
        RefreshTokenRequest refreshTokenRequest = new RefreshTokenRequest(); // RefreshTokenRequest | 
        try {
            AuthResponse result = apiInstance.refreshToken(refreshTokenRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling LoginApi#refreshToken");
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
| **refreshTokenRequest** | [**RefreshTokenRequest**](RefreshTokenRequest.md)|  | |

### Return type

[**AuthResponse**](AuthResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | New access token issued |  -  |
| **401** | Unauthorized |  -  |

