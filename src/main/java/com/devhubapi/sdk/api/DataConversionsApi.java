package com.devhubapi.sdk.api;

import com.devhubapi.sdk.ApiClient;

import com.devhubapi.sdk.model.DevHubErrorResponse;

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
public class DataConversionsApi {
    private ApiClient apiClient;

    public DataConversionsApi() {
        this(new ApiClient());
    }

    public DataConversionsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Convert CSV text to JSON array with type inference
     * This endpoint converts a CSV text payload into a JSON array of objects. CSV parsing behavior can be customized using query parameters such as delimiter, quote mode, and header handling. The first CSV row must contain column headers.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Supports CSV input as plain text (not file upload)&lt;/li&gt;&lt;li&gt;Custom delimiter: comma, semicolon, pipe, tab&lt;/li&gt;&lt;li&gt;Configurable quote mode and quote character&lt;/li&gt;&lt;li&gt;Mandatory header row to ensure deterministic JSON output&lt;/li&gt;&lt;li&gt;Automatic type inference (boolean, number, date, datetime)&lt;/li&gt;&lt;li&gt;Empty fields are converted to &lt;code&gt;null&lt;/code&gt;&lt;/li&gt;&lt;li&gt;Numeric values with leading zeros are preserved as strings&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Convert user-uploaded CSV data to structured JSON&lt;/li&gt;&lt;li&gt;Normalize CSV datasets for API consumption&lt;/li&gt;&lt;li&gt;Preprocess tabular data for analytics or validation&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;/csv-to-json?delimiter&#x3D;COMMA&amp;quoteMode&#x3D;MINIMAL&amp;quoteChar&#x3D;DOUBLE_QUOTE&lt;/code&gt;&lt;br/&gt;Standard CSV with quoted fields containing commas&lt;/li&gt;&lt;li&gt;&lt;code&gt;/csv-to-json?delimiter&#x3D;SEMICOLON&amp;quoteMode&#x3D;NONE&lt;/code&gt;&lt;br/&gt;Excel-compatible CSV with no quoting&lt;/li&gt;&lt;li&gt;&lt;code&gt;/csv-to-json?delimiter&#x3D;PIPE&amp;firstRowAsHeader&#x3D;false&lt;/code&gt;&lt;br/&gt;Pipe-delimited CSV without header row&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;This endpoint requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - CSV successfully converted to JSON
     * <p><b>400</b> - Invalid CSV input or invalid parsing options
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @param delimiter CSV delimiter character. Default value is SEMICOLON.
     * @param quoteMode Defines how quoted fields are handled. Default value is NONE.
     * @param quoteChar Character used to quote CSV fields. Ignored if quoteMode is NONE.
     * @param trimFields Trim leading and trailing whitespace from field values. Default: true.
     * @param inferTypes Automatically infer field types (boolean, number, date). Default: true.
     * @return List&lt;Object&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec convertCsvToJsonRequestCreation(@jakarta.annotation.Nonnull String body, @jakarta.annotation.Nullable String delimiter, @jakarta.annotation.Nullable String quoteMode, @jakarta.annotation.Nullable String quoteChar, @jakarta.annotation.Nullable Boolean trimFields, @jakarta.annotation.Nullable Boolean inferTypes) throws WebClientResponseException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new WebClientResponseException("Missing the required parameter 'body' when calling convertCsvToJson", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "delimiter", delimiter));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "quoteMode", quoteMode));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "quoteChar", quoteChar));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "trimFields", trimFields));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "inferTypes", inferTypes));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "text/plain"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI("/api/v1/convert/data/csv-to-json", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Convert CSV text to JSON array with type inference
     * This endpoint converts a CSV text payload into a JSON array of objects. CSV parsing behavior can be customized using query parameters such as delimiter, quote mode, and header handling. The first CSV row must contain column headers.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Supports CSV input as plain text (not file upload)&lt;/li&gt;&lt;li&gt;Custom delimiter: comma, semicolon, pipe, tab&lt;/li&gt;&lt;li&gt;Configurable quote mode and quote character&lt;/li&gt;&lt;li&gt;Mandatory header row to ensure deterministic JSON output&lt;/li&gt;&lt;li&gt;Automatic type inference (boolean, number, date, datetime)&lt;/li&gt;&lt;li&gt;Empty fields are converted to &lt;code&gt;null&lt;/code&gt;&lt;/li&gt;&lt;li&gt;Numeric values with leading zeros are preserved as strings&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Convert user-uploaded CSV data to structured JSON&lt;/li&gt;&lt;li&gt;Normalize CSV datasets for API consumption&lt;/li&gt;&lt;li&gt;Preprocess tabular data for analytics or validation&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;/csv-to-json?delimiter&#x3D;COMMA&amp;quoteMode&#x3D;MINIMAL&amp;quoteChar&#x3D;DOUBLE_QUOTE&lt;/code&gt;&lt;br/&gt;Standard CSV with quoted fields containing commas&lt;/li&gt;&lt;li&gt;&lt;code&gt;/csv-to-json?delimiter&#x3D;SEMICOLON&amp;quoteMode&#x3D;NONE&lt;/code&gt;&lt;br/&gt;Excel-compatible CSV with no quoting&lt;/li&gt;&lt;li&gt;&lt;code&gt;/csv-to-json?delimiter&#x3D;PIPE&amp;firstRowAsHeader&#x3D;false&lt;/code&gt;&lt;br/&gt;Pipe-delimited CSV without header row&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;This endpoint requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - CSV successfully converted to JSON
     * <p><b>400</b> - Invalid CSV input or invalid parsing options
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @param delimiter CSV delimiter character. Default value is SEMICOLON.
     * @param quoteMode Defines how quoted fields are handled. Default value is NONE.
     * @param quoteChar Character used to quote CSV fields. Ignored if quoteMode is NONE.
     * @param trimFields Trim leading and trailing whitespace from field values. Default: true.
     * @param inferTypes Automatically infer field types (boolean, number, date). Default: true.
     * @return List&lt;Object&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Flux<Object> convertCsvToJson(@jakarta.annotation.Nonnull String body, @jakarta.annotation.Nullable String delimiter, @jakarta.annotation.Nullable String quoteMode, @jakarta.annotation.Nullable String quoteChar, @jakarta.annotation.Nullable Boolean trimFields, @jakarta.annotation.Nullable Boolean inferTypes) throws WebClientResponseException {
        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return convertCsvToJsonRequestCreation(body, delimiter, quoteMode, quoteChar, trimFields, inferTypes).bodyToFlux(localVarReturnType);
    }

    /**
     * Convert CSV text to JSON array with type inference
     * This endpoint converts a CSV text payload into a JSON array of objects. CSV parsing behavior can be customized using query parameters such as delimiter, quote mode, and header handling. The first CSV row must contain column headers.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Supports CSV input as plain text (not file upload)&lt;/li&gt;&lt;li&gt;Custom delimiter: comma, semicolon, pipe, tab&lt;/li&gt;&lt;li&gt;Configurable quote mode and quote character&lt;/li&gt;&lt;li&gt;Mandatory header row to ensure deterministic JSON output&lt;/li&gt;&lt;li&gt;Automatic type inference (boolean, number, date, datetime)&lt;/li&gt;&lt;li&gt;Empty fields are converted to &lt;code&gt;null&lt;/code&gt;&lt;/li&gt;&lt;li&gt;Numeric values with leading zeros are preserved as strings&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Convert user-uploaded CSV data to structured JSON&lt;/li&gt;&lt;li&gt;Normalize CSV datasets for API consumption&lt;/li&gt;&lt;li&gt;Preprocess tabular data for analytics or validation&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;/csv-to-json?delimiter&#x3D;COMMA&amp;quoteMode&#x3D;MINIMAL&amp;quoteChar&#x3D;DOUBLE_QUOTE&lt;/code&gt;&lt;br/&gt;Standard CSV with quoted fields containing commas&lt;/li&gt;&lt;li&gt;&lt;code&gt;/csv-to-json?delimiter&#x3D;SEMICOLON&amp;quoteMode&#x3D;NONE&lt;/code&gt;&lt;br/&gt;Excel-compatible CSV with no quoting&lt;/li&gt;&lt;li&gt;&lt;code&gt;/csv-to-json?delimiter&#x3D;PIPE&amp;firstRowAsHeader&#x3D;false&lt;/code&gt;&lt;br/&gt;Pipe-delimited CSV without header row&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;This endpoint requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - CSV successfully converted to JSON
     * <p><b>400</b> - Invalid CSV input or invalid parsing options
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @param delimiter CSV delimiter character. Default value is SEMICOLON.
     * @param quoteMode Defines how quoted fields are handled. Default value is NONE.
     * @param quoteChar Character used to quote CSV fields. Ignored if quoteMode is NONE.
     * @param trimFields Trim leading and trailing whitespace from field values. Default: true.
     * @param inferTypes Automatically infer field types (boolean, number, date). Default: true.
     * @return ResponseEntity&lt;List&lt;Object&gt;&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<List<Object>>> convertCsvToJsonWithHttpInfo(@jakarta.annotation.Nonnull String body, @jakarta.annotation.Nullable String delimiter, @jakarta.annotation.Nullable String quoteMode, @jakarta.annotation.Nullable String quoteChar, @jakarta.annotation.Nullable Boolean trimFields, @jakarta.annotation.Nullable Boolean inferTypes) throws WebClientResponseException {
        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return convertCsvToJsonRequestCreation(body, delimiter, quoteMode, quoteChar, trimFields, inferTypes).toEntityList(localVarReturnType);
    }

    /**
     * Convert CSV text to JSON array with type inference
     * This endpoint converts a CSV text payload into a JSON array of objects. CSV parsing behavior can be customized using query parameters such as delimiter, quote mode, and header handling. The first CSV row must contain column headers.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Supports CSV input as plain text (not file upload)&lt;/li&gt;&lt;li&gt;Custom delimiter: comma, semicolon, pipe, tab&lt;/li&gt;&lt;li&gt;Configurable quote mode and quote character&lt;/li&gt;&lt;li&gt;Mandatory header row to ensure deterministic JSON output&lt;/li&gt;&lt;li&gt;Automatic type inference (boolean, number, date, datetime)&lt;/li&gt;&lt;li&gt;Empty fields are converted to &lt;code&gt;null&lt;/code&gt;&lt;/li&gt;&lt;li&gt;Numeric values with leading zeros are preserved as strings&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Convert user-uploaded CSV data to structured JSON&lt;/li&gt;&lt;li&gt;Normalize CSV datasets for API consumption&lt;/li&gt;&lt;li&gt;Preprocess tabular data for analytics or validation&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;/csv-to-json?delimiter&#x3D;COMMA&amp;quoteMode&#x3D;MINIMAL&amp;quoteChar&#x3D;DOUBLE_QUOTE&lt;/code&gt;&lt;br/&gt;Standard CSV with quoted fields containing commas&lt;/li&gt;&lt;li&gt;&lt;code&gt;/csv-to-json?delimiter&#x3D;SEMICOLON&amp;quoteMode&#x3D;NONE&lt;/code&gt;&lt;br/&gt;Excel-compatible CSV with no quoting&lt;/li&gt;&lt;li&gt;&lt;code&gt;/csv-to-json?delimiter&#x3D;PIPE&amp;firstRowAsHeader&#x3D;false&lt;/code&gt;&lt;br/&gt;Pipe-delimited CSV without header row&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;This endpoint requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - CSV successfully converted to JSON
     * <p><b>400</b> - Invalid CSV input or invalid parsing options
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @param delimiter CSV delimiter character. Default value is SEMICOLON.
     * @param quoteMode Defines how quoted fields are handled. Default value is NONE.
     * @param quoteChar Character used to quote CSV fields. Ignored if quoteMode is NONE.
     * @param trimFields Trim leading and trailing whitespace from field values. Default: true.
     * @param inferTypes Automatically infer field types (boolean, number, date). Default: true.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec convertCsvToJsonWithResponseSpec(@jakarta.annotation.Nonnull String body, @jakarta.annotation.Nullable String delimiter, @jakarta.annotation.Nullable String quoteMode, @jakarta.annotation.Nullable String quoteChar, @jakarta.annotation.Nullable Boolean trimFields, @jakarta.annotation.Nullable Boolean inferTypes) throws WebClientResponseException {
        return convertCsvToJsonRequestCreation(body, delimiter, quoteMode, quoteChar, trimFields, inferTypes);
    }

    /**
     * Convert HTML to Markdown
     * This endpoint accepts structured HTML content and converts it into clean, readable Markdown. The conversion is deterministic and developer-friendly, producing Markdown suitable for versioning, storage, or further processing.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Accepts raw HTML content as &lt;code&gt;text/plain&lt;/code&gt;&lt;/li&gt;&lt;li&gt;Converts structured HTML into clean and readable Markdown&lt;/li&gt;&lt;li&gt;Deterministic conversion with predictable output&lt;/li&gt;&lt;li&gt;Supports common HTML elements: headings, lists, links, code blocks, tables&lt;/li&gt;&lt;li&gt;Unsupported or unsafe HTML elements, and all CSS (inline or external), are ignored without failing conversion&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Migrate HTML-based documentation to Markdown&lt;/li&gt;&lt;li&gt;Convert content from WYSIWYG editors into Markdown format&lt;/li&gt;&lt;li&gt;Store CMS-generated HTML content as versionable Markdown&lt;/li&gt;&lt;li&gt;Normalize HTML input for developer-focused documentation pipelines&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;&amp;lt;h1&amp;gt;Title&amp;lt;/h1&amp;gt;&amp;lt;p&amp;gt;Hello &amp;lt;strong&amp;gt;world&amp;lt;/strong&amp;gt;&amp;lt;/p&amp;gt;&lt;/code&gt;&lt;br/&gt;Returns:&lt;br/&gt;&lt;code&gt;# Title&lt;br&gt;&lt;br&gt;Hello **world**&lt;/code&gt;&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Important Notes:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Request body must be &lt;code&gt;text/plain&lt;/code&gt;&lt;/li&gt;&lt;li&gt;HTML input is normalized server-side to remove non-semantic whitespace for consistent Markdown output&lt;/li&gt;&lt;li&gt;Whitespace that is part of the HTML (e.g., after &lt;code&gt;&amp;lt;br&amp;gt;&lt;/code&gt;) is preserved&lt;/li&gt;&lt;li&gt;Clients must not alter or sanitize the input payload&lt;/li&gt;&lt;li&gt;Client-side tools (e.g., Postman) may modify raw text if content type is incorrect&lt;/li&gt;&lt;li&gt;Structural conversion only; HTML is not executed, rendered, or sanitized&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - Markdown successfully generated
     * <p><b>400</b> - Invalid or empty HTML content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec convertHtmlToMarkdownRequestCreation(@jakarta.annotation.Nonnull String body) throws WebClientResponseException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new WebClientResponseException("Missing the required parameter 'body' when calling convertHtmlToMarkdown", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "text/markdown", "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "text/plain"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/api/v1/convert/data/html-to-md", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Convert HTML to Markdown
     * This endpoint accepts structured HTML content and converts it into clean, readable Markdown. The conversion is deterministic and developer-friendly, producing Markdown suitable for versioning, storage, or further processing.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Accepts raw HTML content as &lt;code&gt;text/plain&lt;/code&gt;&lt;/li&gt;&lt;li&gt;Converts structured HTML into clean and readable Markdown&lt;/li&gt;&lt;li&gt;Deterministic conversion with predictable output&lt;/li&gt;&lt;li&gt;Supports common HTML elements: headings, lists, links, code blocks, tables&lt;/li&gt;&lt;li&gt;Unsupported or unsafe HTML elements, and all CSS (inline or external), are ignored without failing conversion&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Migrate HTML-based documentation to Markdown&lt;/li&gt;&lt;li&gt;Convert content from WYSIWYG editors into Markdown format&lt;/li&gt;&lt;li&gt;Store CMS-generated HTML content as versionable Markdown&lt;/li&gt;&lt;li&gt;Normalize HTML input for developer-focused documentation pipelines&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;&amp;lt;h1&amp;gt;Title&amp;lt;/h1&amp;gt;&amp;lt;p&amp;gt;Hello &amp;lt;strong&amp;gt;world&amp;lt;/strong&amp;gt;&amp;lt;/p&amp;gt;&lt;/code&gt;&lt;br/&gt;Returns:&lt;br/&gt;&lt;code&gt;# Title&lt;br&gt;&lt;br&gt;Hello **world**&lt;/code&gt;&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Important Notes:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Request body must be &lt;code&gt;text/plain&lt;/code&gt;&lt;/li&gt;&lt;li&gt;HTML input is normalized server-side to remove non-semantic whitespace for consistent Markdown output&lt;/li&gt;&lt;li&gt;Whitespace that is part of the HTML (e.g., after &lt;code&gt;&amp;lt;br&amp;gt;&lt;/code&gt;) is preserved&lt;/li&gt;&lt;li&gt;Clients must not alter or sanitize the input payload&lt;/li&gt;&lt;li&gt;Client-side tools (e.g., Postman) may modify raw text if content type is incorrect&lt;/li&gt;&lt;li&gt;Structural conversion only; HTML is not executed, rendered, or sanitized&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - Markdown successfully generated
     * <p><b>400</b> - Invalid or empty HTML content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<String> convertHtmlToMarkdown(@jakarta.annotation.Nonnull String body) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return convertHtmlToMarkdownRequestCreation(body).bodyToMono(localVarReturnType);
    }

    /**
     * Convert HTML to Markdown
     * This endpoint accepts structured HTML content and converts it into clean, readable Markdown. The conversion is deterministic and developer-friendly, producing Markdown suitable for versioning, storage, or further processing.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Accepts raw HTML content as &lt;code&gt;text/plain&lt;/code&gt;&lt;/li&gt;&lt;li&gt;Converts structured HTML into clean and readable Markdown&lt;/li&gt;&lt;li&gt;Deterministic conversion with predictable output&lt;/li&gt;&lt;li&gt;Supports common HTML elements: headings, lists, links, code blocks, tables&lt;/li&gt;&lt;li&gt;Unsupported or unsafe HTML elements, and all CSS (inline or external), are ignored without failing conversion&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Migrate HTML-based documentation to Markdown&lt;/li&gt;&lt;li&gt;Convert content from WYSIWYG editors into Markdown format&lt;/li&gt;&lt;li&gt;Store CMS-generated HTML content as versionable Markdown&lt;/li&gt;&lt;li&gt;Normalize HTML input for developer-focused documentation pipelines&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;&amp;lt;h1&amp;gt;Title&amp;lt;/h1&amp;gt;&amp;lt;p&amp;gt;Hello &amp;lt;strong&amp;gt;world&amp;lt;/strong&amp;gt;&amp;lt;/p&amp;gt;&lt;/code&gt;&lt;br/&gt;Returns:&lt;br/&gt;&lt;code&gt;# Title&lt;br&gt;&lt;br&gt;Hello **world**&lt;/code&gt;&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Important Notes:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Request body must be &lt;code&gt;text/plain&lt;/code&gt;&lt;/li&gt;&lt;li&gt;HTML input is normalized server-side to remove non-semantic whitespace for consistent Markdown output&lt;/li&gt;&lt;li&gt;Whitespace that is part of the HTML (e.g., after &lt;code&gt;&amp;lt;br&amp;gt;&lt;/code&gt;) is preserved&lt;/li&gt;&lt;li&gt;Clients must not alter or sanitize the input payload&lt;/li&gt;&lt;li&gt;Client-side tools (e.g., Postman) may modify raw text if content type is incorrect&lt;/li&gt;&lt;li&gt;Structural conversion only; HTML is not executed, rendered, or sanitized&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - Markdown successfully generated
     * <p><b>400</b> - Invalid or empty HTML content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @return ResponseEntity&lt;String&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<String>> convertHtmlToMarkdownWithHttpInfo(@jakarta.annotation.Nonnull String body) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return convertHtmlToMarkdownRequestCreation(body).toEntity(localVarReturnType);
    }

    /**
     * Convert HTML to Markdown
     * This endpoint accepts structured HTML content and converts it into clean, readable Markdown. The conversion is deterministic and developer-friendly, producing Markdown suitable for versioning, storage, or further processing.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Accepts raw HTML content as &lt;code&gt;text/plain&lt;/code&gt;&lt;/li&gt;&lt;li&gt;Converts structured HTML into clean and readable Markdown&lt;/li&gt;&lt;li&gt;Deterministic conversion with predictable output&lt;/li&gt;&lt;li&gt;Supports common HTML elements: headings, lists, links, code blocks, tables&lt;/li&gt;&lt;li&gt;Unsupported or unsafe HTML elements, and all CSS (inline or external), are ignored without failing conversion&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Migrate HTML-based documentation to Markdown&lt;/li&gt;&lt;li&gt;Convert content from WYSIWYG editors into Markdown format&lt;/li&gt;&lt;li&gt;Store CMS-generated HTML content as versionable Markdown&lt;/li&gt;&lt;li&gt;Normalize HTML input for developer-focused documentation pipelines&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;&amp;lt;h1&amp;gt;Title&amp;lt;/h1&amp;gt;&amp;lt;p&amp;gt;Hello &amp;lt;strong&amp;gt;world&amp;lt;/strong&amp;gt;&amp;lt;/p&amp;gt;&lt;/code&gt;&lt;br/&gt;Returns:&lt;br/&gt;&lt;code&gt;# Title&lt;br&gt;&lt;br&gt;Hello **world**&lt;/code&gt;&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Important Notes:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Request body must be &lt;code&gt;text/plain&lt;/code&gt;&lt;/li&gt;&lt;li&gt;HTML input is normalized server-side to remove non-semantic whitespace for consistent Markdown output&lt;/li&gt;&lt;li&gt;Whitespace that is part of the HTML (e.g., after &lt;code&gt;&amp;lt;br&amp;gt;&lt;/code&gt;) is preserved&lt;/li&gt;&lt;li&gt;Clients must not alter or sanitize the input payload&lt;/li&gt;&lt;li&gt;Client-side tools (e.g., Postman) may modify raw text if content type is incorrect&lt;/li&gt;&lt;li&gt;Structural conversion only; HTML is not executed, rendered, or sanitized&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - Markdown successfully generated
     * <p><b>400</b> - Invalid or empty HTML content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec convertHtmlToMarkdownWithResponseSpec(@jakarta.annotation.Nonnull String body) throws WebClientResponseException {
        return convertHtmlToMarkdownRequestCreation(body);
    }

    /**
     * Convert JSON array to CSV
     * This endpoint converts a JSON array of flat objects into a CSV text with customizable formatting.&lt;br/&gt;The CSV output is compatible with Excel by default using semicolon as delimiter.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Custom CSV formatting via query parameters&lt;/li&gt;&lt;li&gt;Supported delimiters: COMMA, SEMICOLON, PIPE, TAB&lt;/li&gt;&lt;li&gt;Configurable quote mode and quote character&lt;/li&gt;&lt;li&gt;Automatic header detection from the first JSON object&lt;/li&gt;&lt;li&gt;Missing fields rendered as empty cells&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Export frontend JSON data to CSV/Excel&lt;/li&gt;&lt;li&gt;Generate reports from API responses&lt;/li&gt;&lt;li&gt;Transform logs or datasets into tabular format&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;/json-to-csv?delimiter&#x3D;SEMICOLON&lt;/code&gt; – Excel-compatible CSV using semicolon delimiter&lt;/li&gt;&lt;li&gt;&lt;code&gt;/json-to-csv?delimiter&#x3D;COMMA&amp;quoteMode&#x3D;NON_NUMERIC&amp;quoteChar&#x3D;DOUBLE_QUOTE&lt;/code&gt; – Quote all non-numeric values using double quotes&lt;/li&gt;&lt;li&gt;&lt;code&gt;/json-to-csv?delimiter&#x3D;PIPE&amp;quoteMode&#x3D;ALL&amp;quoteChar&#x3D;SINGLE_QUOTE&lt;/code&gt; – Pipe-delimited CSV with all values quoted&lt;/li&gt;&lt;li&gt;&lt;code&gt;/json-to-csv?delimiter&#x3D;TAB&amp;quoteMode&#x3D;NONE&lt;/code&gt; – Tab-separated values with no quoting&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - CSV successfully generated
     * <p><b>400</b> - Invalid input or CSV formatting options
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param requestBody JSON array of objects to convert
     * @param delimiter CSV delimiter. Default: SEMICOLON
     * @param quoteMode Quote mode for CSV values. Default: NONE
     * @param quoteChar Character to quote fields (ignored if quoteMode is NONE)
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec convertJsonToCsvRequestCreation(@jakarta.annotation.Nonnull List<Map<String, Object>> requestBody, @jakarta.annotation.Nullable String delimiter, @jakarta.annotation.Nullable String quoteMode, @jakarta.annotation.Nullable String quoteChar) throws WebClientResponseException {
        Object postBody = requestBody;
        // verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new WebClientResponseException("Missing the required parameter 'requestBody' when calling convertJsonToCsv", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "delimiter", delimiter));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "quoteMode", quoteMode));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "quoteChar", quoteChar));

        final String[] localVarAccepts = { 
            "text/csv", "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/api/v1/convert/data/json-to-csv", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Convert JSON array to CSV
     * This endpoint converts a JSON array of flat objects into a CSV text with customizable formatting.&lt;br/&gt;The CSV output is compatible with Excel by default using semicolon as delimiter.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Custom CSV formatting via query parameters&lt;/li&gt;&lt;li&gt;Supported delimiters: COMMA, SEMICOLON, PIPE, TAB&lt;/li&gt;&lt;li&gt;Configurable quote mode and quote character&lt;/li&gt;&lt;li&gt;Automatic header detection from the first JSON object&lt;/li&gt;&lt;li&gt;Missing fields rendered as empty cells&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Export frontend JSON data to CSV/Excel&lt;/li&gt;&lt;li&gt;Generate reports from API responses&lt;/li&gt;&lt;li&gt;Transform logs or datasets into tabular format&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;/json-to-csv?delimiter&#x3D;SEMICOLON&lt;/code&gt; – Excel-compatible CSV using semicolon delimiter&lt;/li&gt;&lt;li&gt;&lt;code&gt;/json-to-csv?delimiter&#x3D;COMMA&amp;quoteMode&#x3D;NON_NUMERIC&amp;quoteChar&#x3D;DOUBLE_QUOTE&lt;/code&gt; – Quote all non-numeric values using double quotes&lt;/li&gt;&lt;li&gt;&lt;code&gt;/json-to-csv?delimiter&#x3D;PIPE&amp;quoteMode&#x3D;ALL&amp;quoteChar&#x3D;SINGLE_QUOTE&lt;/code&gt; – Pipe-delimited CSV with all values quoted&lt;/li&gt;&lt;li&gt;&lt;code&gt;/json-to-csv?delimiter&#x3D;TAB&amp;quoteMode&#x3D;NONE&lt;/code&gt; – Tab-separated values with no quoting&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - CSV successfully generated
     * <p><b>400</b> - Invalid input or CSV formatting options
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param requestBody JSON array of objects to convert
     * @param delimiter CSV delimiter. Default: SEMICOLON
     * @param quoteMode Quote mode for CSV values. Default: NONE
     * @param quoteChar Character to quote fields (ignored if quoteMode is NONE)
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<String> convertJsonToCsv(@jakarta.annotation.Nonnull List<Map<String, Object>> requestBody, @jakarta.annotation.Nullable String delimiter, @jakarta.annotation.Nullable String quoteMode, @jakarta.annotation.Nullable String quoteChar) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return convertJsonToCsvRequestCreation(requestBody, delimiter, quoteMode, quoteChar).bodyToMono(localVarReturnType);
    }

    /**
     * Convert JSON array to CSV
     * This endpoint converts a JSON array of flat objects into a CSV text with customizable formatting.&lt;br/&gt;The CSV output is compatible with Excel by default using semicolon as delimiter.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Custom CSV formatting via query parameters&lt;/li&gt;&lt;li&gt;Supported delimiters: COMMA, SEMICOLON, PIPE, TAB&lt;/li&gt;&lt;li&gt;Configurable quote mode and quote character&lt;/li&gt;&lt;li&gt;Automatic header detection from the first JSON object&lt;/li&gt;&lt;li&gt;Missing fields rendered as empty cells&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Export frontend JSON data to CSV/Excel&lt;/li&gt;&lt;li&gt;Generate reports from API responses&lt;/li&gt;&lt;li&gt;Transform logs or datasets into tabular format&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;/json-to-csv?delimiter&#x3D;SEMICOLON&lt;/code&gt; – Excel-compatible CSV using semicolon delimiter&lt;/li&gt;&lt;li&gt;&lt;code&gt;/json-to-csv?delimiter&#x3D;COMMA&amp;quoteMode&#x3D;NON_NUMERIC&amp;quoteChar&#x3D;DOUBLE_QUOTE&lt;/code&gt; – Quote all non-numeric values using double quotes&lt;/li&gt;&lt;li&gt;&lt;code&gt;/json-to-csv?delimiter&#x3D;PIPE&amp;quoteMode&#x3D;ALL&amp;quoteChar&#x3D;SINGLE_QUOTE&lt;/code&gt; – Pipe-delimited CSV with all values quoted&lt;/li&gt;&lt;li&gt;&lt;code&gt;/json-to-csv?delimiter&#x3D;TAB&amp;quoteMode&#x3D;NONE&lt;/code&gt; – Tab-separated values with no quoting&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - CSV successfully generated
     * <p><b>400</b> - Invalid input or CSV formatting options
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param requestBody JSON array of objects to convert
     * @param delimiter CSV delimiter. Default: SEMICOLON
     * @param quoteMode Quote mode for CSV values. Default: NONE
     * @param quoteChar Character to quote fields (ignored if quoteMode is NONE)
     * @return ResponseEntity&lt;String&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<String>> convertJsonToCsvWithHttpInfo(@jakarta.annotation.Nonnull List<Map<String, Object>> requestBody, @jakarta.annotation.Nullable String delimiter, @jakarta.annotation.Nullable String quoteMode, @jakarta.annotation.Nullable String quoteChar) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return convertJsonToCsvRequestCreation(requestBody, delimiter, quoteMode, quoteChar).toEntity(localVarReturnType);
    }

    /**
     * Convert JSON array to CSV
     * This endpoint converts a JSON array of flat objects into a CSV text with customizable formatting.&lt;br/&gt;The CSV output is compatible with Excel by default using semicolon as delimiter.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Custom CSV formatting via query parameters&lt;/li&gt;&lt;li&gt;Supported delimiters: COMMA, SEMICOLON, PIPE, TAB&lt;/li&gt;&lt;li&gt;Configurable quote mode and quote character&lt;/li&gt;&lt;li&gt;Automatic header detection from the first JSON object&lt;/li&gt;&lt;li&gt;Missing fields rendered as empty cells&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Export frontend JSON data to CSV/Excel&lt;/li&gt;&lt;li&gt;Generate reports from API responses&lt;/li&gt;&lt;li&gt;Transform logs or datasets into tabular format&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;/json-to-csv?delimiter&#x3D;SEMICOLON&lt;/code&gt; – Excel-compatible CSV using semicolon delimiter&lt;/li&gt;&lt;li&gt;&lt;code&gt;/json-to-csv?delimiter&#x3D;COMMA&amp;quoteMode&#x3D;NON_NUMERIC&amp;quoteChar&#x3D;DOUBLE_QUOTE&lt;/code&gt; – Quote all non-numeric values using double quotes&lt;/li&gt;&lt;li&gt;&lt;code&gt;/json-to-csv?delimiter&#x3D;PIPE&amp;quoteMode&#x3D;ALL&amp;quoteChar&#x3D;SINGLE_QUOTE&lt;/code&gt; – Pipe-delimited CSV with all values quoted&lt;/li&gt;&lt;li&gt;&lt;code&gt;/json-to-csv?delimiter&#x3D;TAB&amp;quoteMode&#x3D;NONE&lt;/code&gt; – Tab-separated values with no quoting&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - CSV successfully generated
     * <p><b>400</b> - Invalid input or CSV formatting options
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param requestBody JSON array of objects to convert
     * @param delimiter CSV delimiter. Default: SEMICOLON
     * @param quoteMode Quote mode for CSV values. Default: NONE
     * @param quoteChar Character to quote fields (ignored if quoteMode is NONE)
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec convertJsonToCsvWithResponseSpec(@jakarta.annotation.Nonnull List<Map<String, Object>> requestBody, @jakarta.annotation.Nullable String delimiter, @jakarta.annotation.Nullable String quoteMode, @jakarta.annotation.Nullable String quoteChar) throws WebClientResponseException {
        return convertJsonToCsvRequestCreation(requestBody, delimiter, quoteMode, quoteChar);
    }

    /**
     * Convert JSON to XML
     * This endpoint converts a well-formed JSON object or array into an XML document.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Preserves JSON hierarchy and structure in XML format&lt;/li&gt;&lt;li&gt;Supports nested objects, arrays, and primitive values&lt;/li&gt;&lt;li&gt;If the input JSON has a single top-level property, it is used as the XML root element. If multiple properties or an array are present, a synthetic &lt;code&gt;&amp;lt;root&amp;gt;&lt;/code&gt; element is generated&lt;/li&gt;&lt;li&gt;Outputs indented, human-readable XML&lt;/li&gt;&lt;li&gt;Supports XML attributes using &lt;code&gt;@attribute&lt;/code&gt; notation&lt;/li&gt;&lt;li&gt;Supports text nodes using &lt;code&gt;#text&lt;/code&gt; notation&lt;/li&gt;&lt;li&gt;Automatically escapes XML-sensitive characters in values&lt;/li&gt;&lt;li&gt;Configurable array handling via &lt;code&gt;arrayMode&lt;/code&gt; parameter (&lt;code&gt;FLAT&lt;/code&gt; or &lt;code&gt;WRAPPED&lt;/code&gt;)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Generate XML from JSON configuration or API responses&lt;/li&gt;&lt;li&gt;Integrate RESTful JSON data with legacy XML-based systems&lt;/li&gt;&lt;li&gt;Transform microservice outputs for SOAP or XML-driven workflows&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;The input is strictly validated to ensure it is a valid JSON document.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;This endpoint requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - Conversion successful
     * <p><b>400</b> - Invalid or empty JSON input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @param arrayMode Controls how JSON arrays are represented in the generated XML output.&lt;br/&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;FLAT&lt;/code&gt;: each array element is rendered as a repeated XML element with the same tag name&lt;/li&gt;&lt;li&gt;&lt;code&gt;WRAPPED&lt;/code&gt;: array elements are wrapped inside a parent element and rendered as &lt;code&gt;&amp;lt;item&amp;gt;&lt;/code&gt; child nodes&lt;/li&gt;&lt;/ul&gt;If not specified, the default behavior is &lt;code&gt;FLAT&lt;/code&gt;.
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec convertJsonToXmlRequestCreation(@jakarta.annotation.Nonnull String body, @jakarta.annotation.Nullable String arrayMode) throws WebClientResponseException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new WebClientResponseException("Missing the required parameter 'body' when calling convertJsonToXml", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "arrayMode", arrayMode));

        final String[] localVarAccepts = { 
            "application/xml", "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/api/v1/convert/data/json-to-xml", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Convert JSON to XML
     * This endpoint converts a well-formed JSON object or array into an XML document.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Preserves JSON hierarchy and structure in XML format&lt;/li&gt;&lt;li&gt;Supports nested objects, arrays, and primitive values&lt;/li&gt;&lt;li&gt;If the input JSON has a single top-level property, it is used as the XML root element. If multiple properties or an array are present, a synthetic &lt;code&gt;&amp;lt;root&amp;gt;&lt;/code&gt; element is generated&lt;/li&gt;&lt;li&gt;Outputs indented, human-readable XML&lt;/li&gt;&lt;li&gt;Supports XML attributes using &lt;code&gt;@attribute&lt;/code&gt; notation&lt;/li&gt;&lt;li&gt;Supports text nodes using &lt;code&gt;#text&lt;/code&gt; notation&lt;/li&gt;&lt;li&gt;Automatically escapes XML-sensitive characters in values&lt;/li&gt;&lt;li&gt;Configurable array handling via &lt;code&gt;arrayMode&lt;/code&gt; parameter (&lt;code&gt;FLAT&lt;/code&gt; or &lt;code&gt;WRAPPED&lt;/code&gt;)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Generate XML from JSON configuration or API responses&lt;/li&gt;&lt;li&gt;Integrate RESTful JSON data with legacy XML-based systems&lt;/li&gt;&lt;li&gt;Transform microservice outputs for SOAP or XML-driven workflows&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;The input is strictly validated to ensure it is a valid JSON document.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;This endpoint requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - Conversion successful
     * <p><b>400</b> - Invalid or empty JSON input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @param arrayMode Controls how JSON arrays are represented in the generated XML output.&lt;br/&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;FLAT&lt;/code&gt;: each array element is rendered as a repeated XML element with the same tag name&lt;/li&gt;&lt;li&gt;&lt;code&gt;WRAPPED&lt;/code&gt;: array elements are wrapped inside a parent element and rendered as &lt;code&gt;&amp;lt;item&amp;gt;&lt;/code&gt; child nodes&lt;/li&gt;&lt;/ul&gt;If not specified, the default behavior is &lt;code&gt;FLAT&lt;/code&gt;.
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<String> convertJsonToXml(@jakarta.annotation.Nonnull String body, @jakarta.annotation.Nullable String arrayMode) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return convertJsonToXmlRequestCreation(body, arrayMode).bodyToMono(localVarReturnType);
    }

    /**
     * Convert JSON to XML
     * This endpoint converts a well-formed JSON object or array into an XML document.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Preserves JSON hierarchy and structure in XML format&lt;/li&gt;&lt;li&gt;Supports nested objects, arrays, and primitive values&lt;/li&gt;&lt;li&gt;If the input JSON has a single top-level property, it is used as the XML root element. If multiple properties or an array are present, a synthetic &lt;code&gt;&amp;lt;root&amp;gt;&lt;/code&gt; element is generated&lt;/li&gt;&lt;li&gt;Outputs indented, human-readable XML&lt;/li&gt;&lt;li&gt;Supports XML attributes using &lt;code&gt;@attribute&lt;/code&gt; notation&lt;/li&gt;&lt;li&gt;Supports text nodes using &lt;code&gt;#text&lt;/code&gt; notation&lt;/li&gt;&lt;li&gt;Automatically escapes XML-sensitive characters in values&lt;/li&gt;&lt;li&gt;Configurable array handling via &lt;code&gt;arrayMode&lt;/code&gt; parameter (&lt;code&gt;FLAT&lt;/code&gt; or &lt;code&gt;WRAPPED&lt;/code&gt;)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Generate XML from JSON configuration or API responses&lt;/li&gt;&lt;li&gt;Integrate RESTful JSON data with legacy XML-based systems&lt;/li&gt;&lt;li&gt;Transform microservice outputs for SOAP or XML-driven workflows&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;The input is strictly validated to ensure it is a valid JSON document.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;This endpoint requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - Conversion successful
     * <p><b>400</b> - Invalid or empty JSON input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @param arrayMode Controls how JSON arrays are represented in the generated XML output.&lt;br/&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;FLAT&lt;/code&gt;: each array element is rendered as a repeated XML element with the same tag name&lt;/li&gt;&lt;li&gt;&lt;code&gt;WRAPPED&lt;/code&gt;: array elements are wrapped inside a parent element and rendered as &lt;code&gt;&amp;lt;item&amp;gt;&lt;/code&gt; child nodes&lt;/li&gt;&lt;/ul&gt;If not specified, the default behavior is &lt;code&gt;FLAT&lt;/code&gt;.
     * @return ResponseEntity&lt;String&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<String>> convertJsonToXmlWithHttpInfo(@jakarta.annotation.Nonnull String body, @jakarta.annotation.Nullable String arrayMode) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return convertJsonToXmlRequestCreation(body, arrayMode).toEntity(localVarReturnType);
    }

    /**
     * Convert JSON to XML
     * This endpoint converts a well-formed JSON object or array into an XML document.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Preserves JSON hierarchy and structure in XML format&lt;/li&gt;&lt;li&gt;Supports nested objects, arrays, and primitive values&lt;/li&gt;&lt;li&gt;If the input JSON has a single top-level property, it is used as the XML root element. If multiple properties or an array are present, a synthetic &lt;code&gt;&amp;lt;root&amp;gt;&lt;/code&gt; element is generated&lt;/li&gt;&lt;li&gt;Outputs indented, human-readable XML&lt;/li&gt;&lt;li&gt;Supports XML attributes using &lt;code&gt;@attribute&lt;/code&gt; notation&lt;/li&gt;&lt;li&gt;Supports text nodes using &lt;code&gt;#text&lt;/code&gt; notation&lt;/li&gt;&lt;li&gt;Automatically escapes XML-sensitive characters in values&lt;/li&gt;&lt;li&gt;Configurable array handling via &lt;code&gt;arrayMode&lt;/code&gt; parameter (&lt;code&gt;FLAT&lt;/code&gt; or &lt;code&gt;WRAPPED&lt;/code&gt;)&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Generate XML from JSON configuration or API responses&lt;/li&gt;&lt;li&gt;Integrate RESTful JSON data with legacy XML-based systems&lt;/li&gt;&lt;li&gt;Transform microservice outputs for SOAP or XML-driven workflows&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;The input is strictly validated to ensure it is a valid JSON document.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;This endpoint requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - Conversion successful
     * <p><b>400</b> - Invalid or empty JSON input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @param arrayMode Controls how JSON arrays are represented in the generated XML output.&lt;br/&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;FLAT&lt;/code&gt;: each array element is rendered as a repeated XML element with the same tag name&lt;/li&gt;&lt;li&gt;&lt;code&gt;WRAPPED&lt;/code&gt;: array elements are wrapped inside a parent element and rendered as &lt;code&gt;&amp;lt;item&amp;gt;&lt;/code&gt; child nodes&lt;/li&gt;&lt;/ul&gt;If not specified, the default behavior is &lt;code&gt;FLAT&lt;/code&gt;.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec convertJsonToXmlWithResponseSpec(@jakarta.annotation.Nonnull String body, @jakarta.annotation.Nullable String arrayMode) throws WebClientResponseException {
        return convertJsonToXmlRequestCreation(body, arrayMode);
    }

    /**
     * Convert JSON content to YAML format
     * This endpoint accepts a valid JSON string and converts it into a YAML-formatted output. &lt;br/&gt;The converted YAML is returned as plain text using the application/yaml media type.&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Validates input to ensure it is a well-formed JSON document before conversion&lt;/li&gt;&lt;li&gt;Supports any valid JSON structure (objects, arrays, nested data)&lt;/li&gt;&lt;li&gt;Preserves data types, structure, and indentation&lt;/li&gt;&lt;li&gt;Minimizes unnecessary quotes while maintaining semantic correctness&lt;/li&gt;&lt;li&gt;Generates YAML compatible with common configuration formats and parsers&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Convert API responses or configuration data to YAML for improved readability&lt;/li&gt;&lt;li&gt;Generate YAML files for CI/CD pipelines, Docker Compose, or Kubernetes&lt;/li&gt;&lt;li&gt;Quickly reformat JSON configuration data for Spring Boot applications&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Input JSON:&lt;br/&gt;&lt;code&gt;{\&quot;server\&quot;:{\&quot;port\&quot;:8080}}&lt;/code&gt;&lt;br/&gt;Output YAML:&lt;br/&gt;&lt;code&gt;server:   port: 8080&lt;/code&gt;&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;The input payload is strictly validated to ensure it represents a valid JSON document.&lt;br/&gt;&lt;h4&gt;Important Notes:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Request body must be valid JSON&lt;/li&gt;&lt;li&gt;Clients must not modify or sanitize the payload&lt;/li&gt;&lt;li&gt;Structural conversion only; YAML is generated from JSON and no execution occurs&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - JSON successfully converted into YAML format
     * <p><b>400</b> - Invalid or empty JSON input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec convertJsonToYamlRequestCreation(@jakarta.annotation.Nonnull String body) throws WebClientResponseException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new WebClientResponseException("Missing the required parameter 'body' when calling convertJsonToYaml", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/yaml", "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/api/v1/convert/data/json-to-yaml", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Convert JSON content to YAML format
     * This endpoint accepts a valid JSON string and converts it into a YAML-formatted output. &lt;br/&gt;The converted YAML is returned as plain text using the application/yaml media type.&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Validates input to ensure it is a well-formed JSON document before conversion&lt;/li&gt;&lt;li&gt;Supports any valid JSON structure (objects, arrays, nested data)&lt;/li&gt;&lt;li&gt;Preserves data types, structure, and indentation&lt;/li&gt;&lt;li&gt;Minimizes unnecessary quotes while maintaining semantic correctness&lt;/li&gt;&lt;li&gt;Generates YAML compatible with common configuration formats and parsers&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Convert API responses or configuration data to YAML for improved readability&lt;/li&gt;&lt;li&gt;Generate YAML files for CI/CD pipelines, Docker Compose, or Kubernetes&lt;/li&gt;&lt;li&gt;Quickly reformat JSON configuration data for Spring Boot applications&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Input JSON:&lt;br/&gt;&lt;code&gt;{\&quot;server\&quot;:{\&quot;port\&quot;:8080}}&lt;/code&gt;&lt;br/&gt;Output YAML:&lt;br/&gt;&lt;code&gt;server:   port: 8080&lt;/code&gt;&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;The input payload is strictly validated to ensure it represents a valid JSON document.&lt;br/&gt;&lt;h4&gt;Important Notes:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Request body must be valid JSON&lt;/li&gt;&lt;li&gt;Clients must not modify or sanitize the payload&lt;/li&gt;&lt;li&gt;Structural conversion only; YAML is generated from JSON and no execution occurs&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - JSON successfully converted into YAML format
     * <p><b>400</b> - Invalid or empty JSON input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<String> convertJsonToYaml(@jakarta.annotation.Nonnull String body) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return convertJsonToYamlRequestCreation(body).bodyToMono(localVarReturnType);
    }

    /**
     * Convert JSON content to YAML format
     * This endpoint accepts a valid JSON string and converts it into a YAML-formatted output. &lt;br/&gt;The converted YAML is returned as plain text using the application/yaml media type.&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Validates input to ensure it is a well-formed JSON document before conversion&lt;/li&gt;&lt;li&gt;Supports any valid JSON structure (objects, arrays, nested data)&lt;/li&gt;&lt;li&gt;Preserves data types, structure, and indentation&lt;/li&gt;&lt;li&gt;Minimizes unnecessary quotes while maintaining semantic correctness&lt;/li&gt;&lt;li&gt;Generates YAML compatible with common configuration formats and parsers&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Convert API responses or configuration data to YAML for improved readability&lt;/li&gt;&lt;li&gt;Generate YAML files for CI/CD pipelines, Docker Compose, or Kubernetes&lt;/li&gt;&lt;li&gt;Quickly reformat JSON configuration data for Spring Boot applications&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Input JSON:&lt;br/&gt;&lt;code&gt;{\&quot;server\&quot;:{\&quot;port\&quot;:8080}}&lt;/code&gt;&lt;br/&gt;Output YAML:&lt;br/&gt;&lt;code&gt;server:   port: 8080&lt;/code&gt;&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;The input payload is strictly validated to ensure it represents a valid JSON document.&lt;br/&gt;&lt;h4&gt;Important Notes:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Request body must be valid JSON&lt;/li&gt;&lt;li&gt;Clients must not modify or sanitize the payload&lt;/li&gt;&lt;li&gt;Structural conversion only; YAML is generated from JSON and no execution occurs&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - JSON successfully converted into YAML format
     * <p><b>400</b> - Invalid or empty JSON input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @return ResponseEntity&lt;String&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<String>> convertJsonToYamlWithHttpInfo(@jakarta.annotation.Nonnull String body) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return convertJsonToYamlRequestCreation(body).toEntity(localVarReturnType);
    }

    /**
     * Convert JSON content to YAML format
     * This endpoint accepts a valid JSON string and converts it into a YAML-formatted output. &lt;br/&gt;The converted YAML is returned as plain text using the application/yaml media type.&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Validates input to ensure it is a well-formed JSON document before conversion&lt;/li&gt;&lt;li&gt;Supports any valid JSON structure (objects, arrays, nested data)&lt;/li&gt;&lt;li&gt;Preserves data types, structure, and indentation&lt;/li&gt;&lt;li&gt;Minimizes unnecessary quotes while maintaining semantic correctness&lt;/li&gt;&lt;li&gt;Generates YAML compatible with common configuration formats and parsers&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Convert API responses or configuration data to YAML for improved readability&lt;/li&gt;&lt;li&gt;Generate YAML files for CI/CD pipelines, Docker Compose, or Kubernetes&lt;/li&gt;&lt;li&gt;Quickly reformat JSON configuration data for Spring Boot applications&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Input JSON:&lt;br/&gt;&lt;code&gt;{\&quot;server\&quot;:{\&quot;port\&quot;:8080}}&lt;/code&gt;&lt;br/&gt;Output YAML:&lt;br/&gt;&lt;code&gt;server:   port: 8080&lt;/code&gt;&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;The input payload is strictly validated to ensure it represents a valid JSON document.&lt;br/&gt;&lt;h4&gt;Important Notes:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Request body must be valid JSON&lt;/li&gt;&lt;li&gt;Clients must not modify or sanitize the payload&lt;/li&gt;&lt;li&gt;Structural conversion only; YAML is generated from JSON and no execution occurs&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - JSON successfully converted into YAML format
     * <p><b>400</b> - Invalid or empty JSON input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec convertJsonToYamlWithResponseSpec(@jakarta.annotation.Nonnull String body) throws WebClientResponseException {
        return convertJsonToYamlRequestCreation(body);
    }

    /**
     * Convert Markdown to HTML
     * This endpoint accepts raw Markdown content and converts it into sanitized HTML. The generated HTML can be styled using predefined CSS themes.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Accepts raw Markdown as &lt;code&gt;text/plain&lt;/code&gt;&lt;/li&gt;&lt;li&gt;Converts Markdown into sanitized HTML&lt;/li&gt;&lt;li&gt;Supports predefined CSS themes: LIGHT, DARK&lt;/li&gt;&lt;li&gt;Conversion results can be cached for performance&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Render Markdown documentation in web apps&lt;/li&gt;&lt;li&gt;Convert README files into styled HTML pages&lt;/li&gt;&lt;li&gt;Generate HTML previews with light or dark theme&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;/md-to-html&lt;/code&gt; – Renders HTML with default theme&lt;/li&gt;&lt;li&gt;&lt;code&gt;/md-to-html?theme&#x3D;DARK&lt;/code&gt; – Renders HTML with dark theme&lt;/li&gt;&lt;li&gt;&lt;code&gt;/md-to-html?theme&#x3D;LIGHT&lt;/code&gt; – Renders HTML with light theme&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Important Notes:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Request body must be &lt;code&gt;text/plain&lt;/code&gt;&lt;/li&gt;&lt;li&gt;Clients must not alter the payload before sending&lt;/li&gt;&lt;li&gt;Client tools (e.g., Postman) may modify raw text if content type is incorrect&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - HTML successfully generated
     * <p><b>400</b> - Invalid or empty Markdown content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @param theme CSS theme applied to generated HTML. Default is NONE.
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec convertMarkdownToHtmlRequestCreation(@jakarta.annotation.Nonnull String body, @jakarta.annotation.Nullable String theme) throws WebClientResponseException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new WebClientResponseException("Missing the required parameter 'body' when calling convertMarkdownToHtml", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "theme", theme));

        final String[] localVarAccepts = { 
            "text/html", "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "text/plain"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/api/v1/convert/data/md-to-html", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Convert Markdown to HTML
     * This endpoint accepts raw Markdown content and converts it into sanitized HTML. The generated HTML can be styled using predefined CSS themes.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Accepts raw Markdown as &lt;code&gt;text/plain&lt;/code&gt;&lt;/li&gt;&lt;li&gt;Converts Markdown into sanitized HTML&lt;/li&gt;&lt;li&gt;Supports predefined CSS themes: LIGHT, DARK&lt;/li&gt;&lt;li&gt;Conversion results can be cached for performance&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Render Markdown documentation in web apps&lt;/li&gt;&lt;li&gt;Convert README files into styled HTML pages&lt;/li&gt;&lt;li&gt;Generate HTML previews with light or dark theme&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;/md-to-html&lt;/code&gt; – Renders HTML with default theme&lt;/li&gt;&lt;li&gt;&lt;code&gt;/md-to-html?theme&#x3D;DARK&lt;/code&gt; – Renders HTML with dark theme&lt;/li&gt;&lt;li&gt;&lt;code&gt;/md-to-html?theme&#x3D;LIGHT&lt;/code&gt; – Renders HTML with light theme&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Important Notes:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Request body must be &lt;code&gt;text/plain&lt;/code&gt;&lt;/li&gt;&lt;li&gt;Clients must not alter the payload before sending&lt;/li&gt;&lt;li&gt;Client tools (e.g., Postman) may modify raw text if content type is incorrect&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - HTML successfully generated
     * <p><b>400</b> - Invalid or empty Markdown content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @param theme CSS theme applied to generated HTML. Default is NONE.
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<String> convertMarkdownToHtml(@jakarta.annotation.Nonnull String body, @jakarta.annotation.Nullable String theme) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return convertMarkdownToHtmlRequestCreation(body, theme).bodyToMono(localVarReturnType);
    }

    /**
     * Convert Markdown to HTML
     * This endpoint accepts raw Markdown content and converts it into sanitized HTML. The generated HTML can be styled using predefined CSS themes.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Accepts raw Markdown as &lt;code&gt;text/plain&lt;/code&gt;&lt;/li&gt;&lt;li&gt;Converts Markdown into sanitized HTML&lt;/li&gt;&lt;li&gt;Supports predefined CSS themes: LIGHT, DARK&lt;/li&gt;&lt;li&gt;Conversion results can be cached for performance&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Render Markdown documentation in web apps&lt;/li&gt;&lt;li&gt;Convert README files into styled HTML pages&lt;/li&gt;&lt;li&gt;Generate HTML previews with light or dark theme&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;/md-to-html&lt;/code&gt; – Renders HTML with default theme&lt;/li&gt;&lt;li&gt;&lt;code&gt;/md-to-html?theme&#x3D;DARK&lt;/code&gt; – Renders HTML with dark theme&lt;/li&gt;&lt;li&gt;&lt;code&gt;/md-to-html?theme&#x3D;LIGHT&lt;/code&gt; – Renders HTML with light theme&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Important Notes:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Request body must be &lt;code&gt;text/plain&lt;/code&gt;&lt;/li&gt;&lt;li&gt;Clients must not alter the payload before sending&lt;/li&gt;&lt;li&gt;Client tools (e.g., Postman) may modify raw text if content type is incorrect&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - HTML successfully generated
     * <p><b>400</b> - Invalid or empty Markdown content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @param theme CSS theme applied to generated HTML. Default is NONE.
     * @return ResponseEntity&lt;String&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<String>> convertMarkdownToHtmlWithHttpInfo(@jakarta.annotation.Nonnull String body, @jakarta.annotation.Nullable String theme) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return convertMarkdownToHtmlRequestCreation(body, theme).toEntity(localVarReturnType);
    }

    /**
     * Convert Markdown to HTML
     * This endpoint accepts raw Markdown content and converts it into sanitized HTML. The generated HTML can be styled using predefined CSS themes.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Accepts raw Markdown as &lt;code&gt;text/plain&lt;/code&gt;&lt;/li&gt;&lt;li&gt;Converts Markdown into sanitized HTML&lt;/li&gt;&lt;li&gt;Supports predefined CSS themes: LIGHT, DARK&lt;/li&gt;&lt;li&gt;Conversion results can be cached for performance&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Render Markdown documentation in web apps&lt;/li&gt;&lt;li&gt;Convert README files into styled HTML pages&lt;/li&gt;&lt;li&gt;Generate HTML previews with light or dark theme&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;&lt;code&gt;/md-to-html&lt;/code&gt; – Renders HTML with default theme&lt;/li&gt;&lt;li&gt;&lt;code&gt;/md-to-html?theme&#x3D;DARK&lt;/code&gt; – Renders HTML with dark theme&lt;/li&gt;&lt;li&gt;&lt;code&gt;/md-to-html?theme&#x3D;LIGHT&lt;/code&gt; – Renders HTML with light theme&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Important Notes:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Request body must be &lt;code&gt;text/plain&lt;/code&gt;&lt;/li&gt;&lt;li&gt;Clients must not alter the payload before sending&lt;/li&gt;&lt;li&gt;Client tools (e.g., Postman) may modify raw text if content type is incorrect&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - HTML successfully generated
     * <p><b>400</b> - Invalid or empty Markdown content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Payload too large
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @param theme CSS theme applied to generated HTML. Default is NONE.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec convertMarkdownToHtmlWithResponseSpec(@jakarta.annotation.Nonnull String body, @jakarta.annotation.Nullable String theme) throws WebClientResponseException {
        return convertMarkdownToHtmlRequestCreation(body, theme);
    }

    /**
     * Convert XML to JSON
     * This endpoint converts a well-formed XML document into a JSON representation, preserving structure, hierarchy, attributes, and text content.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Preserves XML element hierarchy and structure&lt;/li&gt;&lt;li&gt;Converts XML attributes using &lt;code&gt;@attribute&lt;/code&gt; notation&lt;/li&gt;&lt;li&gt;Supports text nodes and mixed content using &lt;code&gt;#text&lt;/code&gt; notation&lt;/li&gt;&lt;li&gt;Automatically groups repeated XML elements into JSON arrays&lt;/li&gt;&lt;li&gt;Optional array stabilization via &lt;code&gt;forceArray&lt;/code&gt; parameter&lt;/li&gt;&lt;li&gt;Optional namespace removal via &lt;code&gt;stripNamespaces&lt;/code&gt; parameter&lt;/li&gt;&lt;li&gt;Outputs formatted, human-readable JSON&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Transform XML payloads into JSON for modern REST or frontend applications&lt;/li&gt;&lt;li&gt;Integrate legacy XML-based systems with JSON-driven architectures&lt;/li&gt;&lt;li&gt;Normalize XML responses for SDKs and strongly typed clients&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;The input payload is strictly validated to ensure it is a valid XML document.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Notes:&lt;/h4&gt;Swagger UI may display a placeholder XML example for this endpoint. This does not reflect the actual request payload handling or conversion behavior.&lt;br/&gt;When enabled, &lt;code&gt;forceArray&lt;/code&gt; ensures a stable JSON schema, which is particularly useful for strongly typed clients and SDKs.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;This endpoint requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - Conversion successful
     * <p><b>400</b> - Invalid or empty or unsafe XML input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body Raw XML payload to be converted into JSON.&lt;br/&gt;&lt;ul&gt;&lt;li&gt;The XML document is processed as-is&lt;/li&gt;&lt;li&gt;The root element is preserved as the top-level JSON key&lt;/li&gt;&lt;li&gt;No predefined XML schema is enforced&lt;/li&gt;&lt;li&gt;Mixed XML content is preserved using the &lt;code&gt;#text&lt;/code&gt; field when text nodes and child elements coexist.&lt;/li&gt;&lt;li&gt;Empty XML elements are converted to empty JSON objects.&lt;/li&gt;&lt;li&gt;If an element occurs once, it is mapped as a single value; if repeated, it is mapped as an array.When &lt;code&gt;forceArray&lt;/code&gt; is enabled, elements are always represented as arrays.&lt;/li&gt;&lt;li&gt;XML namespaces are preserved in element and attribute names.&lt;/li&gt;&lt;/ul&gt;&lt;strong&gt;Note:&lt;/strong&gt;&lt;br/&gt;Swagger UI may display a placeholder XML example (\&quot;XML example cannot be generated; root element name is undefined\&quot;). This is a limitation of Swagger UI and does not reflect the actual request payload accepted by the API.
     * @param forceArray When enabled, XML elements that may occur multiple times under the same parent are always represented as JSON arrays, even if only a single occurrence is present in the input. Singular, non-repeating elements are never converted into arrays.
     * @param stripNamespaces When enabled, XML namespace prefixes are removed from element and attribute names during conversion. The namespace URI information is discarded, resulting in cleaner and more readable JSON keys. When disabled, namespace prefixes are preserved. This option is useful when namespace information is not required by the consumer.
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec convertXmlToJsonRequestCreation(@jakarta.annotation.Nonnull String body, @jakarta.annotation.Nullable Boolean forceArray, @jakarta.annotation.Nullable Boolean stripNamespaces) throws WebClientResponseException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new WebClientResponseException("Missing the required parameter 'body' when calling convertXmlToJson", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "forceArray", forceArray));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "stripNamespaces", stripNamespaces));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "text/plain"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/api/v1/convert/data/xml-to-json", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Convert XML to JSON
     * This endpoint converts a well-formed XML document into a JSON representation, preserving structure, hierarchy, attributes, and text content.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Preserves XML element hierarchy and structure&lt;/li&gt;&lt;li&gt;Converts XML attributes using &lt;code&gt;@attribute&lt;/code&gt; notation&lt;/li&gt;&lt;li&gt;Supports text nodes and mixed content using &lt;code&gt;#text&lt;/code&gt; notation&lt;/li&gt;&lt;li&gt;Automatically groups repeated XML elements into JSON arrays&lt;/li&gt;&lt;li&gt;Optional array stabilization via &lt;code&gt;forceArray&lt;/code&gt; parameter&lt;/li&gt;&lt;li&gt;Optional namespace removal via &lt;code&gt;stripNamespaces&lt;/code&gt; parameter&lt;/li&gt;&lt;li&gt;Outputs formatted, human-readable JSON&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Transform XML payloads into JSON for modern REST or frontend applications&lt;/li&gt;&lt;li&gt;Integrate legacy XML-based systems with JSON-driven architectures&lt;/li&gt;&lt;li&gt;Normalize XML responses for SDKs and strongly typed clients&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;The input payload is strictly validated to ensure it is a valid XML document.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Notes:&lt;/h4&gt;Swagger UI may display a placeholder XML example for this endpoint. This does not reflect the actual request payload handling or conversion behavior.&lt;br/&gt;When enabled, &lt;code&gt;forceArray&lt;/code&gt; ensures a stable JSON schema, which is particularly useful for strongly typed clients and SDKs.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;This endpoint requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - Conversion successful
     * <p><b>400</b> - Invalid or empty or unsafe XML input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body Raw XML payload to be converted into JSON.&lt;br/&gt;&lt;ul&gt;&lt;li&gt;The XML document is processed as-is&lt;/li&gt;&lt;li&gt;The root element is preserved as the top-level JSON key&lt;/li&gt;&lt;li&gt;No predefined XML schema is enforced&lt;/li&gt;&lt;li&gt;Mixed XML content is preserved using the &lt;code&gt;#text&lt;/code&gt; field when text nodes and child elements coexist.&lt;/li&gt;&lt;li&gt;Empty XML elements are converted to empty JSON objects.&lt;/li&gt;&lt;li&gt;If an element occurs once, it is mapped as a single value; if repeated, it is mapped as an array.When &lt;code&gt;forceArray&lt;/code&gt; is enabled, elements are always represented as arrays.&lt;/li&gt;&lt;li&gt;XML namespaces are preserved in element and attribute names.&lt;/li&gt;&lt;/ul&gt;&lt;strong&gt;Note:&lt;/strong&gt;&lt;br/&gt;Swagger UI may display a placeholder XML example (\&quot;XML example cannot be generated; root element name is undefined\&quot;). This is a limitation of Swagger UI and does not reflect the actual request payload accepted by the API.
     * @param forceArray When enabled, XML elements that may occur multiple times under the same parent are always represented as JSON arrays, even if only a single occurrence is present in the input. Singular, non-repeating elements are never converted into arrays.
     * @param stripNamespaces When enabled, XML namespace prefixes are removed from element and attribute names during conversion. The namespace URI information is discarded, resulting in cleaner and more readable JSON keys. When disabled, namespace prefixes are preserved. This option is useful when namespace information is not required by the consumer.
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<String> convertXmlToJson(@jakarta.annotation.Nonnull String body, @jakarta.annotation.Nullable Boolean forceArray, @jakarta.annotation.Nullable Boolean stripNamespaces) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return convertXmlToJsonRequestCreation(body, forceArray, stripNamespaces).bodyToMono(localVarReturnType);
    }

    /**
     * Convert XML to JSON
     * This endpoint converts a well-formed XML document into a JSON representation, preserving structure, hierarchy, attributes, and text content.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Preserves XML element hierarchy and structure&lt;/li&gt;&lt;li&gt;Converts XML attributes using &lt;code&gt;@attribute&lt;/code&gt; notation&lt;/li&gt;&lt;li&gt;Supports text nodes and mixed content using &lt;code&gt;#text&lt;/code&gt; notation&lt;/li&gt;&lt;li&gt;Automatically groups repeated XML elements into JSON arrays&lt;/li&gt;&lt;li&gt;Optional array stabilization via &lt;code&gt;forceArray&lt;/code&gt; parameter&lt;/li&gt;&lt;li&gt;Optional namespace removal via &lt;code&gt;stripNamespaces&lt;/code&gt; parameter&lt;/li&gt;&lt;li&gt;Outputs formatted, human-readable JSON&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Transform XML payloads into JSON for modern REST or frontend applications&lt;/li&gt;&lt;li&gt;Integrate legacy XML-based systems with JSON-driven architectures&lt;/li&gt;&lt;li&gt;Normalize XML responses for SDKs and strongly typed clients&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;The input payload is strictly validated to ensure it is a valid XML document.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Notes:&lt;/h4&gt;Swagger UI may display a placeholder XML example for this endpoint. This does not reflect the actual request payload handling or conversion behavior.&lt;br/&gt;When enabled, &lt;code&gt;forceArray&lt;/code&gt; ensures a stable JSON schema, which is particularly useful for strongly typed clients and SDKs.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;This endpoint requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - Conversion successful
     * <p><b>400</b> - Invalid or empty or unsafe XML input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body Raw XML payload to be converted into JSON.&lt;br/&gt;&lt;ul&gt;&lt;li&gt;The XML document is processed as-is&lt;/li&gt;&lt;li&gt;The root element is preserved as the top-level JSON key&lt;/li&gt;&lt;li&gt;No predefined XML schema is enforced&lt;/li&gt;&lt;li&gt;Mixed XML content is preserved using the &lt;code&gt;#text&lt;/code&gt; field when text nodes and child elements coexist.&lt;/li&gt;&lt;li&gt;Empty XML elements are converted to empty JSON objects.&lt;/li&gt;&lt;li&gt;If an element occurs once, it is mapped as a single value; if repeated, it is mapped as an array.When &lt;code&gt;forceArray&lt;/code&gt; is enabled, elements are always represented as arrays.&lt;/li&gt;&lt;li&gt;XML namespaces are preserved in element and attribute names.&lt;/li&gt;&lt;/ul&gt;&lt;strong&gt;Note:&lt;/strong&gt;&lt;br/&gt;Swagger UI may display a placeholder XML example (\&quot;XML example cannot be generated; root element name is undefined\&quot;). This is a limitation of Swagger UI and does not reflect the actual request payload accepted by the API.
     * @param forceArray When enabled, XML elements that may occur multiple times under the same parent are always represented as JSON arrays, even if only a single occurrence is present in the input. Singular, non-repeating elements are never converted into arrays.
     * @param stripNamespaces When enabled, XML namespace prefixes are removed from element and attribute names during conversion. The namespace URI information is discarded, resulting in cleaner and more readable JSON keys. When disabled, namespace prefixes are preserved. This option is useful when namespace information is not required by the consumer.
     * @return ResponseEntity&lt;String&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<String>> convertXmlToJsonWithHttpInfo(@jakarta.annotation.Nonnull String body, @jakarta.annotation.Nullable Boolean forceArray, @jakarta.annotation.Nullable Boolean stripNamespaces) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return convertXmlToJsonRequestCreation(body, forceArray, stripNamespaces).toEntity(localVarReturnType);
    }

    /**
     * Convert XML to JSON
     * This endpoint converts a well-formed XML document into a JSON representation, preserving structure, hierarchy, attributes, and text content.&lt;br/&gt;&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Preserves XML element hierarchy and structure&lt;/li&gt;&lt;li&gt;Converts XML attributes using &lt;code&gt;@attribute&lt;/code&gt; notation&lt;/li&gt;&lt;li&gt;Supports text nodes and mixed content using &lt;code&gt;#text&lt;/code&gt; notation&lt;/li&gt;&lt;li&gt;Automatically groups repeated XML elements into JSON arrays&lt;/li&gt;&lt;li&gt;Optional array stabilization via &lt;code&gt;forceArray&lt;/code&gt; parameter&lt;/li&gt;&lt;li&gt;Optional namespace removal via &lt;code&gt;stripNamespaces&lt;/code&gt; parameter&lt;/li&gt;&lt;li&gt;Outputs formatted, human-readable JSON&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Transform XML payloads into JSON for modern REST or frontend applications&lt;/li&gt;&lt;li&gt;Integrate legacy XML-based systems with JSON-driven architectures&lt;/li&gt;&lt;li&gt;Normalize XML responses for SDKs and strongly typed clients&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;The input payload is strictly validated to ensure it is a valid XML document.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Notes:&lt;/h4&gt;Swagger UI may display a placeholder XML example for this endpoint. This does not reflect the actual request payload handling or conversion behavior.&lt;br/&gt;When enabled, &lt;code&gt;forceArray&lt;/code&gt; ensures a stable JSON schema, which is particularly useful for strongly typed clients and SDKs.&lt;br/&gt;&lt;br/&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;This endpoint requires a valid &lt;code&gt;Bearer Token&lt;/code&gt; in the &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - Conversion successful
     * <p><b>400</b> - Invalid or empty or unsafe XML input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body Raw XML payload to be converted into JSON.&lt;br/&gt;&lt;ul&gt;&lt;li&gt;The XML document is processed as-is&lt;/li&gt;&lt;li&gt;The root element is preserved as the top-level JSON key&lt;/li&gt;&lt;li&gt;No predefined XML schema is enforced&lt;/li&gt;&lt;li&gt;Mixed XML content is preserved using the &lt;code&gt;#text&lt;/code&gt; field when text nodes and child elements coexist.&lt;/li&gt;&lt;li&gt;Empty XML elements are converted to empty JSON objects.&lt;/li&gt;&lt;li&gt;If an element occurs once, it is mapped as a single value; if repeated, it is mapped as an array.When &lt;code&gt;forceArray&lt;/code&gt; is enabled, elements are always represented as arrays.&lt;/li&gt;&lt;li&gt;XML namespaces are preserved in element and attribute names.&lt;/li&gt;&lt;/ul&gt;&lt;strong&gt;Note:&lt;/strong&gt;&lt;br/&gt;Swagger UI may display a placeholder XML example (\&quot;XML example cannot be generated; root element name is undefined\&quot;). This is a limitation of Swagger UI and does not reflect the actual request payload accepted by the API.
     * @param forceArray When enabled, XML elements that may occur multiple times under the same parent are always represented as JSON arrays, even if only a single occurrence is present in the input. Singular, non-repeating elements are never converted into arrays.
     * @param stripNamespaces When enabled, XML namespace prefixes are removed from element and attribute names during conversion. The namespace URI information is discarded, resulting in cleaner and more readable JSON keys. When disabled, namespace prefixes are preserved. This option is useful when namespace information is not required by the consumer.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec convertXmlToJsonWithResponseSpec(@jakarta.annotation.Nonnull String body, @jakarta.annotation.Nullable Boolean forceArray, @jakarta.annotation.Nullable Boolean stripNamespaces) throws WebClientResponseException {
        return convertXmlToJsonRequestCreation(body, forceArray, stripNamespaces);
    }

    /**
     * Convert YAML content to JSON format
     * This endpoint accepts a valid YAML document and converts it into a JSON-formatted output. &lt;br/&gt;The conversion supports YAML objects, arrays, and scalar values as root elements.&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Validates input to ensure it is a well-formed YAML document before conversion&lt;/li&gt;&lt;li&gt;Supports YAML objects, arrays, and scalar root values&lt;/li&gt;&lt;li&gt;Preserves data types, structure, and nested content&lt;/li&gt;&lt;li&gt;Handles multiline values, numeric formats, and boolean representations correctly&lt;/li&gt;&lt;li&gt;Produces human-readable, pretty-printed JSON output&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Convert YAML configuration files into JSON format&lt;/li&gt;&lt;li&gt;Reformat YAML data for APIs or systems that require JSON input&lt;/li&gt;&lt;li&gt;Validate and normalize YAML content through JSON serialization&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Input YAML:&lt;br/&gt;&lt;code&gt;server:   port: 8080   compression:     enabled: true     mime-types:       - application/json       - text/html&lt;/code&gt;&lt;br/&gt;Output JSON:&lt;br/&gt;&lt;code&gt;{\&quot;server\&quot;:{\&quot;port\&quot;:8080,\&quot;compression\&quot;:{\&quot;enabled\&quot;:true,\&quot;mime-types\&quot;:[\&quot;application/json\&quot;,\&quot;text/html\&quot;]}}}&lt;/code&gt;&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;The input payload is strictly validated to ensure it represents a valid YAML document. Invalid or empty YAML content results in a &lt;code&gt;400 Bad Request&lt;/code&gt; response.&lt;br/&gt;&lt;h4&gt;Important Notes:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Request body must be valid YAML&lt;/li&gt;&lt;li&gt;Clients must not modify or sanitize the payload&lt;/li&gt;&lt;li&gt;Structural conversion only; no execution or evaluation of YAML content occurs&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - YAML successfully converted into JSON format
     * <p><b>400</b> - Invalid or empty YAML input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec convertYamlToJsonRequestCreation(@jakarta.annotation.Nonnull String body) throws WebClientResponseException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new WebClientResponseException("Missing the required parameter 'body' when calling convertYamlToJson", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
            "text/plain"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/api/v1/convert/data/yaml-to-json", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Convert YAML content to JSON format
     * This endpoint accepts a valid YAML document and converts it into a JSON-formatted output. &lt;br/&gt;The conversion supports YAML objects, arrays, and scalar values as root elements.&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Validates input to ensure it is a well-formed YAML document before conversion&lt;/li&gt;&lt;li&gt;Supports YAML objects, arrays, and scalar root values&lt;/li&gt;&lt;li&gt;Preserves data types, structure, and nested content&lt;/li&gt;&lt;li&gt;Handles multiline values, numeric formats, and boolean representations correctly&lt;/li&gt;&lt;li&gt;Produces human-readable, pretty-printed JSON output&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Convert YAML configuration files into JSON format&lt;/li&gt;&lt;li&gt;Reformat YAML data for APIs or systems that require JSON input&lt;/li&gt;&lt;li&gt;Validate and normalize YAML content through JSON serialization&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Input YAML:&lt;br/&gt;&lt;code&gt;server:   port: 8080   compression:     enabled: true     mime-types:       - application/json       - text/html&lt;/code&gt;&lt;br/&gt;Output JSON:&lt;br/&gt;&lt;code&gt;{\&quot;server\&quot;:{\&quot;port\&quot;:8080,\&quot;compression\&quot;:{\&quot;enabled\&quot;:true,\&quot;mime-types\&quot;:[\&quot;application/json\&quot;,\&quot;text/html\&quot;]}}}&lt;/code&gt;&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;The input payload is strictly validated to ensure it represents a valid YAML document. Invalid or empty YAML content results in a &lt;code&gt;400 Bad Request&lt;/code&gt; response.&lt;br/&gt;&lt;h4&gt;Important Notes:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Request body must be valid YAML&lt;/li&gt;&lt;li&gt;Clients must not modify or sanitize the payload&lt;/li&gt;&lt;li&gt;Structural conversion only; no execution or evaluation of YAML content occurs&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - YAML successfully converted into JSON format
     * <p><b>400</b> - Invalid or empty YAML input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<String> convertYamlToJson(@jakarta.annotation.Nonnull String body) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return convertYamlToJsonRequestCreation(body).bodyToMono(localVarReturnType);
    }

    /**
     * Convert YAML content to JSON format
     * This endpoint accepts a valid YAML document and converts it into a JSON-formatted output. &lt;br/&gt;The conversion supports YAML objects, arrays, and scalar values as root elements.&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Validates input to ensure it is a well-formed YAML document before conversion&lt;/li&gt;&lt;li&gt;Supports YAML objects, arrays, and scalar root values&lt;/li&gt;&lt;li&gt;Preserves data types, structure, and nested content&lt;/li&gt;&lt;li&gt;Handles multiline values, numeric formats, and boolean representations correctly&lt;/li&gt;&lt;li&gt;Produces human-readable, pretty-printed JSON output&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Convert YAML configuration files into JSON format&lt;/li&gt;&lt;li&gt;Reformat YAML data for APIs or systems that require JSON input&lt;/li&gt;&lt;li&gt;Validate and normalize YAML content through JSON serialization&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Input YAML:&lt;br/&gt;&lt;code&gt;server:   port: 8080   compression:     enabled: true     mime-types:       - application/json       - text/html&lt;/code&gt;&lt;br/&gt;Output JSON:&lt;br/&gt;&lt;code&gt;{\&quot;server\&quot;:{\&quot;port\&quot;:8080,\&quot;compression\&quot;:{\&quot;enabled\&quot;:true,\&quot;mime-types\&quot;:[\&quot;application/json\&quot;,\&quot;text/html\&quot;]}}}&lt;/code&gt;&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;The input payload is strictly validated to ensure it represents a valid YAML document. Invalid or empty YAML content results in a &lt;code&gt;400 Bad Request&lt;/code&gt; response.&lt;br/&gt;&lt;h4&gt;Important Notes:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Request body must be valid YAML&lt;/li&gt;&lt;li&gt;Clients must not modify or sanitize the payload&lt;/li&gt;&lt;li&gt;Structural conversion only; no execution or evaluation of YAML content occurs&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - YAML successfully converted into JSON format
     * <p><b>400</b> - Invalid or empty YAML input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @return ResponseEntity&lt;String&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<String>> convertYamlToJsonWithHttpInfo(@jakarta.annotation.Nonnull String body) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return convertYamlToJsonRequestCreation(body).toEntity(localVarReturnType);
    }

    /**
     * Convert YAML content to JSON format
     * This endpoint accepts a valid YAML document and converts it into a JSON-formatted output. &lt;br/&gt;The conversion supports YAML objects, arrays, and scalar values as root elements.&lt;h4&gt;Key Features:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Validates input to ensure it is a well-formed YAML document before conversion&lt;/li&gt;&lt;li&gt;Supports YAML objects, arrays, and scalar root values&lt;/li&gt;&lt;li&gt;Preserves data types, structure, and nested content&lt;/li&gt;&lt;li&gt;Handles multiline values, numeric formats, and boolean representations correctly&lt;/li&gt;&lt;li&gt;Produces human-readable, pretty-printed JSON output&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Use Cases:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Convert YAML configuration files into JSON format&lt;/li&gt;&lt;li&gt;Reformat YAML data for APIs or systems that require JSON input&lt;/li&gt;&lt;li&gt;Validate and normalize YAML content through JSON serialization&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Examples:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Input YAML:&lt;br/&gt;&lt;code&gt;server:   port: 8080   compression:     enabled: true     mime-types:       - application/json       - text/html&lt;/code&gt;&lt;br/&gt;Output JSON:&lt;br/&gt;&lt;code&gt;{\&quot;server\&quot;:{\&quot;port\&quot;:8080,\&quot;compression\&quot;:{\&quot;enabled\&quot;:true,\&quot;mime-types\&quot;:[\&quot;application/json\&quot;,\&quot;text/html\&quot;]}}}&lt;/code&gt;&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Validation:&lt;/h4&gt;The input payload is strictly validated to ensure it represents a valid YAML document. Invalid or empty YAML content results in a &lt;code&gt;400 Bad Request&lt;/code&gt; response.&lt;br/&gt;&lt;h4&gt;Important Notes:&lt;/h4&gt;&lt;ul&gt;&lt;li&gt;Request body must be valid YAML&lt;/li&gt;&lt;li&gt;Clients must not modify or sanitize the payload&lt;/li&gt;&lt;li&gt;Structural conversion only; no execution or evaluation of YAML content occurs&lt;/li&gt;&lt;/ul&gt;&lt;h4&gt;Authentication:&lt;/h4&gt;Bearer token required in &lt;code&gt;Authorization&lt;/code&gt; header.
     * <p><b>200</b> - YAML successfully converted into JSON format
     * <p><b>400</b> - Invalid or empty YAML input
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>429</b> - Too many requests
     * <p><b>500</b> - Internal server error
     * @param body The body parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec convertYamlToJsonWithResponseSpec(@jakarta.annotation.Nonnull String body) throws WebClientResponseException {
        return convertYamlToJsonRequestCreation(body);
    }
}
