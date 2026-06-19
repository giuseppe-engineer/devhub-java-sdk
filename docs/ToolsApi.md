# ToolsApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**generatePassword**](ToolsApi.md#generatePassword) | **POST** /api/v1/tools/password | Generate a random password |
| [**generateUuid**](ToolsApi.md#generateUuid) | **GET** /api/v1/tools/uuid | Generate UUID (v4 or v5) |
| [**minifyCss**](ToolsApi.md#minifyCss) | **POST** /api/v1/tools/minify-css | Minify CSS |
| [**minifyJs**](ToolsApi.md#minifyJs) | **POST** /api/v1/tools/minify-js | Minify JavaScript |
| [**reverse**](ToolsApi.md#reverse) | **POST** /api/v1/tools/reverse | Reverse a text |



## generatePassword

> PasswordResponse generatePassword(passwordRequest)

Generate a random password

Generates a secure and customizable password using either predefined strength presets or manual composition rules.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Four strength presets: &lt;b&gt;WEAK&lt;/b&gt;, &lt;b&gt;MEDIUM&lt;/b&gt;, &lt;b&gt;STRONG&lt;/b&gt;, &lt;b&gt;ULTRA&lt;/b&gt;&lt;/li&gt;&lt;li&gt;Optional manual configuration (letters, numbers, special characters)&lt;/li&gt;&lt;li&gt;Selective exclusion of specific special characters&lt;/li&gt;&lt;li&gt;Uses &lt;code&gt;SecureRandom&lt;/code&gt; for cryptographic-grade randomness&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Behavior:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;If &lt;code&gt;strength&lt;/code&gt; is provided, manual parameters are ignored.&lt;/li&gt;&lt;li&gt;When using a predefined strength, at least one character per category is guaranteed.&lt;/li&gt;&lt;li&gt;Excluded special characters are fully removed from generation.&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.

### Example

```java
// Import classes:
import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.ApiException;
import com.devhubapi.sdk.Configuration;
import com.devhubapi.sdk.auth.*;
import com.devhubapi.sdk.models.*;
import com.devhubapi.sdk.api.ToolsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ToolsApi apiInstance = new ToolsApi(defaultClient);
        PasswordRequest passwordRequest = new PasswordRequest(); // PasswordRequest | 
        try {
            PasswordResponse result = apiInstance.generatePassword(passwordRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ToolsApi#generatePassword");
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
| **passwordRequest** | [**PasswordRequest**](PasswordRequest.md)|  | |

### Return type

[**PasswordResponse**](PasswordResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Password successfully generated |  -  |
| **400** | Invalid input |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **429** | Too many request |  -  |
| **500** | Internal Server Error |  -  |


## generateUuid

> UUIDResponse generateUuid(version, count, namespace, name)

Generate UUID (v4 or v5)

Generates UUID version 4 (random) or version 5 (deterministic, namespace-based).&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Generate between 1 and 100 UUIDs for v4&lt;/li&gt;&lt;li&gt;Generate deterministic UUID v5 using namespace + name&lt;/li&gt;&lt;li&gt;Suitable for unique identifiers or reproducible resource IDs&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Behavior:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Default version is &lt;b&gt;v4&lt;/b&gt;&lt;/li&gt;&lt;li&gt;For &lt;b&gt;v5&lt;/b&gt;, both &lt;code&gt;namespace&lt;/code&gt; and &lt;code&gt;name&lt;/code&gt; are required&lt;/li&gt;&lt;li&gt;UUID v5 is deterministic: same namespace + name → same UUID&lt;/li&gt;&lt;li&gt;For v5, &lt;code&gt;count&lt;/code&gt; must be exactly &lt;b&gt;1&lt;/b&gt;&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.

### Example

```java
// Import classes:
import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.ApiException;
import com.devhubapi.sdk.Configuration;
import com.devhubapi.sdk.auth.*;
import com.devhubapi.sdk.models.*;
import com.devhubapi.sdk.api.ToolsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ToolsApi apiInstance = new ToolsApi(defaultClient);
        String version = "v4"; // String | UID version to generate. Must be <b>v4</b> for random UUID (non-deterministic) or <b>v5</b> for namespaced UUID (deterministic, based on namespace + name). Default value is <code>v4</code>
        Integer count = 1; // Integer | Number of UUIDs to generate. Must be between <b>1</b> and <b>100</b> for <b>v4</b> and exactly <b>1</b> to <b>v5</b> (deterministic generation). Default value is <code>1</code>
        String namespace = "namespace_example"; // String | Required only for <b>v5</b> (namespaced deterministic generation). No strict UUID format required
        String name = "name_example"; // String | Name value used for UUID v5 generation. Required only when <code>version = v5</code>. The same <code>namespace</code> + <code>name</code> combination will always generate the same UUID
        try {
            UUIDResponse result = apiInstance.generateUuid(version, count, namespace, name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ToolsApi#generateUuid");
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
| **version** | **String**| UID version to generate. Must be &lt;b&gt;v4&lt;/b&gt; for random UUID (non-deterministic) or &lt;b&gt;v5&lt;/b&gt; for namespaced UUID (deterministic, based on namespace + name). Default value is &lt;code&gt;v4&lt;/code&gt; | [optional] [default to v4] |
| **count** | **Integer**| Number of UUIDs to generate. Must be between &lt;b&gt;1&lt;/b&gt; and &lt;b&gt;100&lt;/b&gt; for &lt;b&gt;v4&lt;/b&gt; and exactly &lt;b&gt;1&lt;/b&gt; to &lt;b&gt;v5&lt;/b&gt; (deterministic generation). Default value is &lt;code&gt;1&lt;/code&gt; | [optional] [default to 1] |
| **namespace** | **String**| Required only for &lt;b&gt;v5&lt;/b&gt; (namespaced deterministic generation). No strict UUID format required | [optional] |
| **name** | **String**| Name value used for UUID v5 generation. Required only when &lt;code&gt;version &#x3D; v5&lt;/code&gt;. The same &lt;code&gt;namespace&lt;/code&gt; + &lt;code&gt;name&lt;/code&gt; combination will always generate the same UUID | [optional] |

### Return type

[**UUIDResponse**](UUIDResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | UUID(s) successfully generated |  -  |
| **400** | Invalid input |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **429** | Too many request |  -  |
| **500** | Internal Server Error |  -  |


## minifyCss

> String minifyCss(body)

Minify CSS

Minifies a CSS string using YUI Compressor for reliable and optimized output.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Removes unnecessary whitespace and comments&lt;/li&gt;&lt;li&gt;Removes redundant semicolons&lt;/li&gt;&lt;li&gt;Fully compatible with valid CSS3 syntax&lt;/li&gt;&lt;li&gt;Optimized for production deployment and automation pipelines&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Maximum input size: 10MiB&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.

### Example

```java
// Import classes:
import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.ApiException;
import com.devhubapi.sdk.Configuration;
import com.devhubapi.sdk.auth.*;
import com.devhubapi.sdk.models.*;
import com.devhubapi.sdk.api.ToolsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ToolsApi apiInstance = new ToolsApi(defaultClient);
        String body = .a { color : red}; .b { margin : 0}; // String | 
        try {
            String result = apiInstance.minifyCss(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ToolsApi#minifyCss");
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
| **body** | **String**|  | |

### Return type

**String**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: text/plain
- **Accept**: text/plain, application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | CSS successfully minified |  -  |
| **400** | Invalid input |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **413** | Payload too large |  -  |
| **429** | Too many request |  -  |
| **500** | Internal Server Error |  -  |


## minifyJs

> String minifyJs(body)

Minify JavaScript

Minifies a JavaScript string to reduce size and optimize delivery for frontend applications.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Removes unnecessary whitespace and comments&lt;/li&gt;&lt;li&gt;Optimizes output for production environments&lt;/li&gt;&lt;li&gt;Preserves valid JavaScript semantics&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation &amp; Security:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Maximum input size: 10MiB&lt;/li&gt;&lt;li&gt;Performs advanced security analysis to detect potentially unsafe constructs&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the Authorization header.

### Example

```java
// Import classes:
import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.ApiException;
import com.devhubapi.sdk.Configuration;
import com.devhubapi.sdk.auth.*;
import com.devhubapi.sdk.models.*;
import com.devhubapi.sdk.api.ToolsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ToolsApi apiInstance = new ToolsApi(defaultClient);
        String body = function myFunction() {
  document.getElementById("demo").innerHTML = "Paragraph changed.";
}; // String | 
        try {
            String result = apiInstance.minifyJs(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ToolsApi#minifyJs");
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
| **body** | **String**|  | |

### Return type

**String**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: text/plain
- **Accept**: text/plain, application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | JavaScript successfully minified |  -  |
| **400** | Invalid input |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **413** | Payload too large |  -  |
| **429** | Too many request |  -  |
| **500** | Internal Server Error |  -  |


## reverse

> Text reverse(text)

Reverse a text

Reverses the provided text string and returns the reversed value.

### Example

```java
// Import classes:
import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.ApiException;
import com.devhubapi.sdk.Configuration;
import com.devhubapi.sdk.auth.*;
import com.devhubapi.sdk.models.*;
import com.devhubapi.sdk.api.ToolsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ToolsApi apiInstance = new ToolsApi(defaultClient);
        Text text = new Text(); // Text | 
        try {
            Text result = apiInstance.reverse(text);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ToolsApi#reverse");
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
| **text** | [**Text**](Text.md)|  | |

### Return type

[**Text**](Text.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Text successfully reversed |  -  |
| **400** | Invalid input |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **413** | Payload too large |  -  |
| **429** | Too many request |  -  |
| **500** | Internal Server Error |  -  |

