# DataConversionsApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**convertCsvToJson**](DataConversionsApi.md#convertCsvToJson) | **POST** /api/v1/convert/data/csv-to-json | Convert CSV text to JSON array with type inference |
| [**convertHtmlToMarkdown**](DataConversionsApi.md#convertHtmlToMarkdown) | **POST** /api/v1/convert/data/html-to-md | Convert HTML to Markdown |
| [**convertJsonToCsv**](DataConversionsApi.md#convertJsonToCsv) | **POST** /api/v1/convert/data/json-to-csv | Convert JSON array to CSV |
| [**convertJsonToXml**](DataConversionsApi.md#convertJsonToXml) | **POST** /api/v1/convert/data/json-to-xml | Convert JSON to XML |
| [**convertJsonToYaml**](DataConversionsApi.md#convertJsonToYaml) | **POST** /api/v1/convert/data/json-to-yaml | Convert JSON content to YAML format |
| [**convertMarkdownToHtml**](DataConversionsApi.md#convertMarkdownToHtml) | **POST** /api/v1/convert/data/md-to-html | Convert Markdown to HTML |
| [**convertXmlToJson**](DataConversionsApi.md#convertXmlToJson) | **POST** /api/v1/convert/data/xml-to-json | Convert XML to JSON |
| [**convertYamlToJson**](DataConversionsApi.md#convertYamlToJson) | **POST** /api/v1/convert/data/yaml-to-json | Convert YAML content to JSON format |



## convertCsvToJson

> List&lt;Object&gt; convertCsvToJson(body, delimiter, quoteMode, quoteChar, trimFields, inferTypes)

Convert CSV text to JSON array with type inference

This endpoint converts a CSV text payload into a JSON array of objects. CSV parsing behavior can be customized using query parameters such as delimiter, quote mode, and header handling. The first CSV row must contain column headers.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Supports CSV input as plain text (not file upload)&lt;/li&gt;&lt;li&gt;Custom delimiter: comma, semicolon, pipe, tab&lt;/li&gt;&lt;li&gt;Configurable quote mode and quote character&lt;/li&gt;&lt;li&gt;Mandatory header row to ensure deterministic JSON output&lt;/li&gt;&lt;li&gt;Automatic type inference (boolean, number, date, datetime)&lt;/li&gt;&lt;li&gt;Empty fields are converted to &lt;code&gt;null&lt;/code&gt;&lt;/li&gt;&lt;li&gt;Numeric values with leading zeros are preserved as strings&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Convert user-uploaded CSV data to structured JSON&lt;/li&gt;&lt;li&gt;Normalize CSV datasets for API consumption&lt;/li&gt;&lt;li&gt;Preprocess tabular data for analytics or validation&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;/csv-to-json?delimiter&#x3D;COMMA&amp;quoteMode&#x3D;MINIMAL&amp;quoteChar&#x3D;DOUBLE_QUOTE&lt;/code&gt;&lt;br/&gt;Standard CSV with quoted fields containing commas&lt;/li&gt;&lt;li&gt;&lt;code&gt;/csv-to-json?delimiter&#x3D;SEMICOLON&amp;quoteMode&#x3D;NONE&lt;/code&gt;&lt;br/&gt;Excel-compatible CSV with no quoting&lt;/li&gt;&lt;li&gt;&lt;code&gt;/csv-to-json?delimiter&#x3D;PIPE&amp;firstRowAsHeader&#x3D;false&lt;/code&gt;&lt;br/&gt;Pipe-delimited CSV without header row&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;This endpoint requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the &lt;code&gt;Authorization&lt;/code&gt; header.

### Example

```java
// Import classes:
import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.ApiException;
import com.devhubapi.sdk.Configuration;
import com.devhubapi.sdk.auth.*;
import com.devhubapi.sdk.models.*;
import com.devhubapi.sdk.api.DataConversionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        DataConversionsApi apiInstance = new DataConversionsApi(defaultClient);
        String body = id;name;age;isActive
1;Alice;28;true
2;Bob;00031;false
3;Charlie;;true; // String | 
        String delimiter = "COMMA"; // String | CSV delimiter character. Default value is SEMICOLON.
        String quoteMode = "ALL"; // String | Defines how quoted fields are handled. Default value is NONE.
        String quoteChar = "DOUBLE_QUOTE"; // String | Character used to quote CSV fields. Ignored if quoteMode is NONE.
        Boolean trimFields = true; // Boolean | Trim leading and trailing whitespace from field values. Default: true.
        Boolean inferTypes = true; // Boolean | Automatically infer field types (boolean, number, date). Default: true.
        try {
            List<Object> result = apiInstance.convertCsvToJson(body, delimiter, quoteMode, quoteChar, trimFields, inferTypes);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DataConversionsApi#convertCsvToJson");
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
| **delimiter** | **String**| CSV delimiter character. Default value is SEMICOLON. | [optional] [default to SEMICOLON] [enum: COMMA, SEMICOLON, PIPE, TAB] |
| **quoteMode** | **String**| Defines how quoted fields are handled. Default value is NONE. | [optional] [default to NONE] [enum: ALL, ALL_NON_NULL, MINIMAL, NON_NUMERIC, NONE] |
| **quoteChar** | **String**| Character used to quote CSV fields. Ignored if quoteMode is NONE. | [optional] [enum: DOUBLE_QUOTE, SINGLE_QUOTE, BACKTICK] |
| **trimFields** | **Boolean**| Trim leading and trailing whitespace from field values. Default: true. | [optional] [default to true] |
| **inferTypes** | **Boolean**| Automatically infer field types (boolean, number, date). Default: true. | [optional] [default to true] |

### Return type

**List&lt;Object&gt;**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: text/plain
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | CSV successfully converted to JSON |  -  |
| **400** | Invalid CSV input or invalid parsing options |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **413** | Payload too large |  -  |
| **429** | Too many requests |  -  |
| **500** | Internal server error |  -  |


## convertHtmlToMarkdown

> String convertHtmlToMarkdown(body)

Convert HTML to Markdown

This endpoint accepts structured HTML content and converts it into clean, readable Markdown. The conversion is deterministic and developer-friendly, producing Markdown suitable for versioning, storage, or further processing.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Accepts raw HTML content as &lt;code&gt;text/plain&lt;/code&gt;&lt;/li&gt;&lt;li&gt;Converts structured HTML into clean and readable Markdown&lt;/li&gt;&lt;li&gt;Deterministic conversion with predictable output&lt;/li&gt;&lt;li&gt;Supports common HTML elements: headings, lists, links, code blocks, tables&lt;/li&gt;&lt;li&gt;Unsupported or unsafe HTML elements, and all CSS (inline or external), are ignored without failing conversion&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Migrate HTML-based documentation to Markdown&lt;/li&gt;&lt;li&gt;Convert content from WYSIWYG editors into Markdown format&lt;/li&gt;&lt;li&gt;Store CMS-generated HTML content as versionable Markdown&lt;/li&gt;&lt;li&gt;Normalize HTML input for developer-focused documentation pipelines&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;&amp;lt;h1&amp;gt;Title&amp;lt;/h1&amp;gt;&amp;lt;p&amp;gt;Hello &amp;lt;strong&amp;gt;world&amp;lt;/strong&amp;gt;&amp;lt;/p&amp;gt;&lt;/code&gt;&lt;br/&gt;Returns:&lt;br/&gt;&lt;code&gt;# Title&lt;br&gt;&lt;br&gt;Hello **world**&lt;/code&gt;&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Important Notes:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Request body must be &lt;code&gt;text/plain&lt;/code&gt;&lt;/li&gt;&lt;li&gt;HTML input is normalized server-side to remove non-semantic whitespace for consistent Markdown output&lt;/li&gt;&lt;li&gt;Whitespace that is part of the HTML (e.g., after &lt;code&gt;&amp;lt;br&amp;gt;&lt;/code&gt;) is preserved&lt;/li&gt;&lt;li&gt;Clients must not alter or sanitize the input payload&lt;/li&gt;&lt;li&gt;Client-side tools (e.g., Postman) may modify raw text if content type is incorrect&lt;/li&gt;&lt;li&gt;Structural conversion only; HTML is not executed, rendered, or sanitized&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.

### Example

```java
// Import classes:
import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.ApiException;
import com.devhubapi.sdk.Configuration;
import com.devhubapi.sdk.auth.*;
import com.devhubapi.sdk.models.*;
import com.devhubapi.sdk.api.DataConversionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        DataConversionsApi apiInstance = new DataConversionsApi(defaultClient);
        String body = <h1>Hello World</h1>
<p>This is a <strong>HTML</strong> example.</p>
<ul><li>Item 1</li><li>Item 2</li></ul>; // String | 
        try {
            String result = apiInstance.convertHtmlToMarkdown(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DataConversionsApi#convertHtmlToMarkdown");
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
- **Accept**: text/markdown, application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Markdown successfully generated |  -  |
| **400** | Invalid or empty HTML content |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **413** | Payload too large |  -  |
| **429** | Too many requests |  -  |
| **500** | Internal server error |  -  |


## convertJsonToCsv

> String convertJsonToCsv(requestBody, delimiter, quoteMode, quoteChar)

Convert JSON array to CSV

This endpoint converts a JSON array of flat objects into a CSV text with customizable formatting.&lt;br/&gt;The CSV output is compatible with Excel by default using semicolon as delimiter.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Custom CSV formatting via query parameters&lt;/li&gt;&lt;li&gt;Supported delimiters: COMMA, SEMICOLON, PIPE, TAB&lt;/li&gt;&lt;li&gt;Configurable quote mode and quote character&lt;/li&gt;&lt;li&gt;Automatic header detection from the first JSON object&lt;/li&gt;&lt;li&gt;Missing fields rendered as empty cells&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Export frontend JSON data to CSV/Excel&lt;/li&gt;&lt;li&gt;Generate reports from API responses&lt;/li&gt;&lt;li&gt;Transform logs or datasets into tabular format&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;/json-to-csv?delimiter&#x3D;SEMICOLON&lt;/code&gt; – Excel-compatible CSV using semicolon delimiter&lt;/li&gt;&lt;li&gt;&lt;code&gt;/json-to-csv?delimiter&#x3D;COMMA&amp;quoteMode&#x3D;NON_NUMERIC&amp;quoteChar&#x3D;DOUBLE_QUOTE&lt;/code&gt; – Quote all non-numeric values using double quotes&lt;/li&gt;&lt;li&gt;&lt;code&gt;/json-to-csv?delimiter&#x3D;PIPE&amp;quoteMode&#x3D;ALL&amp;quoteChar&#x3D;SINGLE_QUOTE&lt;/code&gt; – Pipe-delimited CSV with all values quoted&lt;/li&gt;&lt;li&gt;&lt;code&gt;/json-to-csv?delimiter&#x3D;TAB&amp;quoteMode&#x3D;NONE&lt;/code&gt; – Tab-separated values with no quoting&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.

### Example

```java
// Import classes:
import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.ApiException;
import com.devhubapi.sdk.Configuration;
import com.devhubapi.sdk.auth.*;
import com.devhubapi.sdk.models.*;
import com.devhubapi.sdk.api.DataConversionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        DataConversionsApi apiInstance = new DataConversionsApi(defaultClient);
        List<Map<String, Object>> requestBody = [{"username":"alice","age":28,"premium":true},{"username":"bob","age":31,"premium":false}]; // List<Map<String, Object>> | JSON array of objects to convert
        String delimiter = "COMMA"; // String | CSV delimiter. Default: SEMICOLON
        String quoteMode = "ALL"; // String | Quote mode for CSV values. Default: NONE
        String quoteChar = "DOUBLE_QUOTE"; // String | Character to quote fields (ignored if quoteMode is NONE)
        try {
            String result = apiInstance.convertJsonToCsv(requestBody, delimiter, quoteMode, quoteChar);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DataConversionsApi#convertJsonToCsv");
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
| **requestBody** | [**List&lt;Map&lt;String, Object&gt;&gt;**](Map.md)| JSON array of objects to convert | |
| **delimiter** | **String**| CSV delimiter. Default: SEMICOLON | [optional] [default to SEMICOLON] [enum: COMMA, SEMICOLON, PIPE, TAB] |
| **quoteMode** | **String**| Quote mode for CSV values. Default: NONE | [optional] [default to NONE] [enum: ALL, ALL_NON_NULL, MINIMAL, NON_NUMERIC, NONE] |
| **quoteChar** | **String**| Character to quote fields (ignored if quoteMode is NONE) | [optional] [enum: DOUBLE_QUOTE, SINGLE_QUOTE, BACKTICK] |

### Return type

**String**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: text/csv, application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | CSV successfully generated |  -  |
| **400** | Invalid input or CSV formatting options |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **429** | Too many requests |  -  |
| **500** | Internal server error |  -  |


## convertJsonToXml

> String convertJsonToXml(body, arrayMode)

Convert JSON to XML

This endpoint converts a well-formed JSON object or array into an XML document.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Preserves JSON hierarchy and structure in XML format&lt;/li&gt;&lt;li&gt;Supports nested objects, arrays, and primitive values&lt;/li&gt;&lt;li&gt;If the input JSON has a single top-level property, it is used as the XML root element. If multiple properties or an array are present, a synthetic &lt;code&gt;&amp;lt;root&amp;gt;&lt;/code&gt; element is generated&lt;/li&gt;&lt;li&gt;Outputs indented, human-readable XML&lt;/li&gt;&lt;li&gt;Supports XML attributes using &lt;code&gt;@attribute&lt;/code&gt; notation&lt;/li&gt;&lt;li&gt;Supports text nodes using &lt;code&gt;#text&lt;/code&gt; notation&lt;/li&gt;&lt;li&gt;Automatically escapes XML-sensitive characters in values&lt;/li&gt;&lt;li&gt;Configurable array handling via &lt;code&gt;arrayMode&lt;/code&gt; parameter (&lt;code&gt;FLAT&lt;/code&gt; or &lt;code&gt;WRAPPED&lt;/code&gt;)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Generate XML from JSON configuration or API responses&lt;/li&gt;&lt;li&gt;Integrate RESTful JSON data with legacy XML-based systems&lt;/li&gt;&lt;li&gt;Transform microservice outputs for SOAP or XML-driven workflows&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;The input is strictly validated to ensure it is a valid JSON document.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;This endpoint requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the &lt;code&gt;Authorization&lt;/code&gt; header.

### Example

```java
// Import classes:
import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.ApiException;
import com.devhubapi.sdk.Configuration;
import com.devhubapi.sdk.auth.*;
import com.devhubapi.sdk.models.*;
import com.devhubapi.sdk.api.DataConversionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        DataConversionsApi apiInstance = new DataConversionsApi(defaultClient);
        String body = {"user":{"name":"Alice","age":30,"roles":["admin","editor"]},"active":true,"createdAt":"2025-11-01T12:30:00Z"}; // String | 
        String arrayMode = "FLAT"; // String | Controls how JSON arrays are represented in the generated XML output.<br/><ul><li><code>FLAT</code>: each array element is rendered as a repeated XML element with the same tag name</li><li><code>WRAPPED</code>: array elements are wrapped inside a parent element and rendered as <code>&lt;item&gt;</code> child nodes</li></ul>If not specified, the default behavior is <code>FLAT</code>.
        try {
            String result = apiInstance.convertJsonToXml(body, arrayMode);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DataConversionsApi#convertJsonToXml");
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
| **arrayMode** | **String**| Controls how JSON arrays are represented in the generated XML output.&lt;br/&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;FLAT&lt;/code&gt;: each array element is rendered as a repeated XML element with the same tag name&lt;/li&gt;&lt;li&gt;&lt;code&gt;WRAPPED&lt;/code&gt;: array elements are wrapped inside a parent element and rendered as &lt;code&gt;&amp;lt;item&amp;gt;&lt;/code&gt; child nodes&lt;/li&gt;&lt;/ul&gt;If not specified, the default behavior is &lt;code&gt;FLAT&lt;/code&gt;. | [optional] [default to FLAT] [enum: FLAT, WRAPPED] |

### Return type

**String**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/xml, application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Conversion successful |  -  |
| **400** | Invalid or empty JSON input |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **429** | Too many requests |  -  |
| **500** | Internal server error |  -  |


## convertJsonToYaml

> String convertJsonToYaml(body)

Convert JSON content to YAML format

This endpoint accepts a valid JSON string and converts it into a YAML-formatted output. &lt;br/&gt;The converted YAML is returned as plain text using the application/yaml media type.&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Validates input to ensure it is a well-formed JSON document before conversion&lt;/li&gt;&lt;li&gt;Supports any valid JSON structure (objects, arrays, nested data)&lt;/li&gt;&lt;li&gt;Preserves data types, structure, and indentation&lt;/li&gt;&lt;li&gt;Minimizes unnecessary quotes while maintaining semantic correctness&lt;/li&gt;&lt;li&gt;Generates YAML compatible with common configuration formats and parsers&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Convert API responses or configuration data to YAML for improved readability&lt;/li&gt;&lt;li&gt;Generate YAML files for CI/CD pipelines, Docker Compose, or Kubernetes&lt;/li&gt;&lt;li&gt;Quickly reformat JSON configuration data for Spring Boot applications&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Input JSON:&lt;br/&gt;&lt;code&gt;{\&quot;server\&quot;:{\&quot;port\&quot;:8080}}&lt;/code&gt;&lt;br/&gt;Output YAML:&lt;br/&gt;&lt;code&gt;server:   port: 8080&lt;/code&gt;&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;The input payload is strictly validated to ensure it represents a valid JSON document.&lt;br/&gt;&lt;h4&gt;Important Notes:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Request body must be valid JSON&lt;/li&gt;&lt;li&gt;Clients must not modify or sanitize the payload&lt;/li&gt;&lt;li&gt;Structural conversion only; YAML is generated from JSON and no execution occurs&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.

### Example

```java
// Import classes:
import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.ApiException;
import com.devhubapi.sdk.Configuration;
import com.devhubapi.sdk.auth.*;
import com.devhubapi.sdk.models.*;
import com.devhubapi.sdk.api.DataConversionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        DataConversionsApi apiInstance = new DataConversionsApi(defaultClient);
        String body = {"server":{"port":8080,"compression":{"enabled":true,"mime-types":["application/json","text/html"]}},"spring":{"profiles":{"active":"prod"},"datasource":{"url":"jdbc:postgresql://localhost:5432/app","username":"app_user","password":"secret"}}}; // String | 
        try {
            String result = apiInstance.convertJsonToYaml(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DataConversionsApi#convertJsonToYaml");
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

- **Content-Type**: application/json
- **Accept**: application/yaml, application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | JSON successfully converted into YAML format |  -  |
| **400** | Invalid or empty JSON input |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **429** | Too many requests |  -  |
| **500** | Internal server error |  -  |


## convertMarkdownToHtml

> String convertMarkdownToHtml(body, theme)

Convert Markdown to HTML

This endpoint accepts raw Markdown content and converts it into sanitized HTML. The generated HTML can be styled using predefined CSS themes.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Accepts raw Markdown as &lt;code&gt;text/plain&lt;/code&gt;&lt;/li&gt;&lt;li&gt;Converts Markdown into sanitized HTML&lt;/li&gt;&lt;li&gt;Supports predefined CSS themes: LIGHT, DARK&lt;/li&gt;&lt;li&gt;Conversion results can be cached for performance&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Render Markdown documentation in web apps&lt;/li&gt;&lt;li&gt;Convert README files into styled HTML pages&lt;/li&gt;&lt;li&gt;Generate HTML previews with light or dark theme&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;/md-to-html&lt;/code&gt; – Renders HTML with default theme&lt;/li&gt;&lt;li&gt;&lt;code&gt;/md-to-html?theme&#x3D;DARK&lt;/code&gt; – Renders HTML with dark theme&lt;/li&gt;&lt;li&gt;&lt;code&gt;/md-to-html?theme&#x3D;LIGHT&lt;/code&gt; – Renders HTML with light theme&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Important Notes:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Request body must be &lt;code&gt;text/plain&lt;/code&gt;&lt;/li&gt;&lt;li&gt;Clients must not alter the payload before sending&lt;/li&gt;&lt;li&gt;Client tools (e.g., Postman) may modify raw text if content type is incorrect&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.

### Example

```java
// Import classes:
import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.ApiException;
import com.devhubapi.sdk.Configuration;
import com.devhubapi.sdk.auth.*;
import com.devhubapi.sdk.models.*;
import com.devhubapi.sdk.api.DataConversionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        DataConversionsApi apiInstance = new DataConversionsApi(defaultClient);
        String body = # Hello World
This is **Markdown** example.
- Item 1
- Item 2; // String | 
        String theme = "NONE"; // String | CSS theme applied to generated HTML. Default is NONE.
        try {
            String result = apiInstance.convertMarkdownToHtml(body, theme);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DataConversionsApi#convertMarkdownToHtml");
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
| **theme** | **String**| CSS theme applied to generated HTML. Default is NONE. | [optional] [default to NONE] [enum: NONE, LIGHT, DARK] |

### Return type

**String**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: text/plain
- **Accept**: text/html, application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | HTML successfully generated |  -  |
| **400** | Invalid or empty Markdown content |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **413** | Payload too large |  -  |
| **429** | Too many requests |  -  |
| **500** | Internal server error |  -  |


## convertXmlToJson

> String convertXmlToJson(body, forceArray, stripNamespaces)

Convert XML to JSON

This endpoint converts a well-formed XML document into a JSON representation, preserving structure, hierarchy, attributes, and text content.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Preserves XML element hierarchy and structure&lt;/li&gt;&lt;li&gt;Converts XML attributes using &lt;code&gt;@attribute&lt;/code&gt; notation&lt;/li&gt;&lt;li&gt;Supports text nodes and mixed content using &lt;code&gt;#text&lt;/code&gt; notation&lt;/li&gt;&lt;li&gt;Automatically groups repeated XML elements into JSON arrays&lt;/li&gt;&lt;li&gt;Optional array stabilization via &lt;code&gt;forceArray&lt;/code&gt; parameter&lt;/li&gt;&lt;li&gt;Optional namespace removal via &lt;code&gt;stripNamespaces&lt;/code&gt; parameter&lt;/li&gt;&lt;li&gt;Outputs formatted, human-readable JSON&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Transform XML payloads into JSON for modern REST or frontend applications&lt;/li&gt;&lt;li&gt;Integrate legacy XML-based systems with JSON-driven architectures&lt;/li&gt;&lt;li&gt;Normalize XML responses for SDKs and strongly typed clients&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;The input payload is strictly validated to ensure it is a valid XML document.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Notes:&lt;/h4&gt;Swagger UI may display a placeholder XML example for this endpoint. This does not reflect the actual request payload handling or conversion behavior.&lt;br/&gt;When enabled, &lt;code&gt;forceArray&lt;/code&gt; ensures a stable JSON schema, which is particularly useful for strongly typed clients and SDKs.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;This endpoint requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the &lt;code&gt;Authorization&lt;/code&gt; header.

### Example

```java
// Import classes:
import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.ApiException;
import com.devhubapi.sdk.Configuration;
import com.devhubapi.sdk.auth.*;
import com.devhubapi.sdk.models.*;
import com.devhubapi.sdk.api.DataConversionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        DataConversionsApi apiInstance = new DataConversionsApi(defaultClient);
        String body = <?xml version="1.0" encoding="UTF-8"?>
<root>
  <user>
    <name>Alice</name>
    <age>30</age>
  </user>
</root>; // String | Raw XML payload to be converted into JSON.<br/><ul><li>The XML document is processed as-is</li><li>The root element is preserved as the top-level JSON key</li><li>No predefined XML schema is enforced</li><li>Mixed XML content is preserved using the <code>#text</code> field when text nodes and child elements coexist.</li><li>Empty XML elements are converted to empty JSON objects.</li><li>If an element occurs once, it is mapped as a single value; if repeated, it is mapped as an array.When <code>forceArray</code> is enabled, elements are always represented as arrays.</li><li>XML namespaces are preserved in element and attribute names.</li></ul><strong>Note:</strong><br/>Swagger UI may display a placeholder XML example (\"XML example cannot be generated; root element name is undefined\"). This is a limitation of Swagger UI and does not reflect the actual request payload accepted by the API.
        Boolean forceArray = false; // Boolean | When enabled, XML elements that may occur multiple times under the same parent are always represented as JSON arrays, even if only a single occurrence is present in the input. Singular, non-repeating elements are never converted into arrays.
        Boolean stripNamespaces = false; // Boolean | When enabled, XML namespace prefixes are removed from element and attribute names during conversion. The namespace URI information is discarded, resulting in cleaner and more readable JSON keys. When disabled, namespace prefixes are preserved. This option is useful when namespace information is not required by the consumer.
        try {
            String result = apiInstance.convertXmlToJson(body, forceArray, stripNamespaces);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DataConversionsApi#convertXmlToJson");
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
| **body** | **String**| Raw XML payload to be converted into JSON.&lt;br/&gt;&lt;ul&gt;&lt;li&gt;The XML document is processed as-is&lt;/li&gt;&lt;li&gt;The root element is preserved as the top-level JSON key&lt;/li&gt;&lt;li&gt;No predefined XML schema is enforced&lt;/li&gt;&lt;li&gt;Mixed XML content is preserved using the &lt;code&gt;#text&lt;/code&gt; field when text nodes and child elements coexist.&lt;/li&gt;&lt;li&gt;Empty XML elements are converted to empty JSON objects.&lt;/li&gt;&lt;li&gt;If an element occurs once, it is mapped as a single value; if repeated, it is mapped as an array.When &lt;code&gt;forceArray&lt;/code&gt; is enabled, elements are always represented as arrays.&lt;/li&gt;&lt;li&gt;XML namespaces are preserved in element and attribute names.&lt;/li&gt;&lt;/ul&gt;&lt;strong&gt;Note:&lt;/strong&gt;&lt;br/&gt;Swagger UI may display a placeholder XML example (\&quot;XML example cannot be generated; root element name is undefined\&quot;). This is a limitation of Swagger UI and does not reflect the actual request payload accepted by the API. | |
| **forceArray** | **Boolean**| When enabled, XML elements that may occur multiple times under the same parent are always represented as JSON arrays, even if only a single occurrence is present in the input. Singular, non-repeating elements are never converted into arrays. | [optional] [default to false] |
| **stripNamespaces** | **Boolean**| When enabled, XML namespace prefixes are removed from element and attribute names during conversion. The namespace URI information is discarded, resulting in cleaner and more readable JSON keys. When disabled, namespace prefixes are preserved. This option is useful when namespace information is not required by the consumer. | [optional] [default to false] |

### Return type

**String**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: text/plain
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Conversion successful |  -  |
| **400** | Invalid or empty or unsafe XML input |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **429** | Too many requests |  -  |
| **500** | Internal server error |  -  |


## convertYamlToJson

> String convertYamlToJson(body)

Convert YAML content to JSON format

This endpoint accepts a valid YAML document and converts it into a JSON-formatted output. &lt;br/&gt;The conversion supports YAML objects, arrays, and scalar values as root elements.&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Validates input to ensure it is a well-formed YAML document before conversion&lt;/li&gt;&lt;li&gt;Supports YAML objects, arrays, and scalar root values&lt;/li&gt;&lt;li&gt;Preserves data types, structure, and nested content&lt;/li&gt;&lt;li&gt;Handles multiline values, numeric formats, and boolean representations correctly&lt;/li&gt;&lt;li&gt;Produces human-readable, pretty-printed JSON output&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Convert YAML configuration files into JSON format&lt;/li&gt;&lt;li&gt;Reformat YAML data for APIs or systems that require JSON input&lt;/li&gt;&lt;li&gt;Validate and normalize YAML content through JSON serialization&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Input YAML:&lt;br/&gt;&lt;code&gt;server:   port: 8080   compression:     enabled: true     mime-types:       - application/json       - text/html&lt;/code&gt;&lt;br/&gt;Output JSON:&lt;br/&gt;&lt;code&gt;{\&quot;server\&quot;:{\&quot;port\&quot;:8080,\&quot;compression\&quot;:{\&quot;enabled\&quot;:true,\&quot;mime-types\&quot;:[\&quot;application/json\&quot;,\&quot;text/html\&quot;]}}}&lt;/code&gt;&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;The input payload is strictly validated to ensure it represents a valid YAML document. Invalid or empty YAML content results in a &lt;code&gt;400 Bad Request&lt;/code&gt; response.&lt;br/&gt;&lt;h4&gt;Important Notes:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Request body must be valid YAML&lt;/li&gt;&lt;li&gt;Clients must not modify or sanitize the payload&lt;/li&gt;&lt;li&gt;Structural conversion only; no execution or evaluation of YAML content occurs&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.

### Example

```java
// Import classes:
import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.ApiException;
import com.devhubapi.sdk.Configuration;
import com.devhubapi.sdk.auth.*;
import com.devhubapi.sdk.models.*;
import com.devhubapi.sdk.api.DataConversionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        DataConversionsApi apiInstance = new DataConversionsApi(defaultClient);
        String body = server:
  port: 8080
  compression:
    enabled: true
    mime-types:
      - application/json
      - text/html; // String | 
        try {
            String result = apiInstance.convertYamlToJson(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DataConversionsApi#convertYamlToJson");
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
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | YAML successfully converted into JSON format |  -  |
| **400** | Invalid or empty YAML input |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **429** | Too many requests |  -  |
| **500** | Internal server error |  -  |

