package com.devhubapi.sdk.module.convert;

import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.api.DataConversionsApi;
import com.devhubapi.sdk.client.DevHubClientException;
import com.devhubapi.sdk.module.convert.Theme;
import com.devhubapi.sdk.module.convert.ArrayMode;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import com.devhubapi.sdk.module.convert.builder.CsvToJsonBuilder;
import com.devhubapi.sdk.module.convert.builder.JsonToCsvBuilder;

/**
 * Provides text-based data conversion APIs.
 *
 * <p>
 * Includes conversions such as:
 * <ul>
 *     <li>HTML <-> Markdown</li>
 *     <li>JSON <-> CSV</li>
 *     <li>JSON <-> XML</li>
 * </ul>
 *
 * <p>
 * Designed for simple, fast transformations with minimal configuration.
 */
public class DataConversionModule {

    private final DataConversionsApi api;

    public DataConversionModule(ApiClient apiClient) {
        this.api = new DataConversionsApi(apiClient);
    }

    // ============================================================
    // ================= HTML → MARKDOWN ==========================
    // ============================================================

    /**
     * Converts HTML content into Markdown format.
     *
     * <p>
     * This method transforms structured HTML into clean Markdown syntax,
     * preserving text formatting such as headings, paragraphs, lists and emphasis.
     * </p>
     *
     * <h4>Features</h4>
     * <ul>
     * <li>Accepts raw HTML content as <code>text/plain</code></li>
     * <li>Converts structured HTML into clean and readable Markdown</li>
     * <li>Supports common HTML elements: headings, lists, links, code blocks, tables</li>
     * <li>Unsupported or unsafe HTML elements, and all CSS (inline or external), are ignored without failing conversion</li>
     * </ul>
     *
     * <h4>Use case</h4>
     * <ul>
     *     <li>Convert rich HTML content into Markdown for storage or editing</li>
     *     <li>Prepare content for static site generators</li>
     *     <li>Normalize HTML input into a simpler text format</li>
     * </ul>
     *
     * <h4>Example</h4>
     * <pre>{@code
     * String markdown = client.convert()
     *     .data()
     *     .htmlToMarkdown("<h1>Hello</h1><p>World</p>");
     * }</pre>
     *
     * @param html the HTML content to convert
     * @return converted Markdown string
     * @throws DevHubClientException if the API call fails
     */
    public String htmlToMarkdown(String html) throws DevHubClientException {
        try {
            return api.convertHtmlToMarkdown(html).block();
        } catch (WebClientResponseException ex) {
            throw new DevHubClientException(ex);
        }
    }


    // ============================================================
    // ================= MARKDOWN → HTML ===========================
    // ============================================================

    /**
     * Converts Markdown content into HTML using default theme (NONE).
     *
     * @param markdown the Markdown content
     * @return generated HTML
     * @throws DevHubClientException if the API call fails
     */
    public String markdownToHtml(String markdown) throws DevHubClientException {
        return markdownToHtml(markdown, Theme.NONE);
    }

    /**
     * Converts Markdown content into HTML using the specified theme.
     *
     * <p>
     * The theme controls the visual style of the generated HTML.
     * Supported values:
     * <ul>
     *     <li>NONE (default)</li>
     *     <li>LIGHT</li>
     *     <li>DARK</li>
     * </ul>
     * </p>
     *
     * <h4>Example</h4>
     * <pre>{@code
     * String html = client.convert()
     *     .data()
     *     .markdownToHtml("# Hello", Theme.DARK);
     * }</pre>
     *
     * @param markdown the Markdown content
     * @param theme optional theme (if null → NONE)
     * @return generated HTML
     * @throws DevHubClientException if the API call fails
     */
    public String markdownToHtml(String markdown, Theme theme) throws DevHubClientException {
        try {
            String themeValue = (theme != null ? theme.name() : Theme.NONE.name());
            return api.convertMarkdownToHtml(markdown, themeValue).block();
        } catch (WebClientResponseException ex) {
            throw new DevHubClientException(ex);
        }
    }

    // ============================================================
    // ================= JSON → XML ================================
    // ============================================================

    /**
     * Converts JSON content into XML using default array mode (FLAT).
     *
     * @param json the JSON input
     * @return generated XML
     * @throws DevHubClientException if the API call fails
     */
    public String jsonToXml(String json) throws DevHubClientException {
        return jsonToXml(json, ArrayMode.FLAT);
    }

    /**
     * Converts JSON content into XML using the specified array mode.
     *
     * <p>
     * The array mode defines how JSON arrays are represented in XML:
     * <ul>
     *     <li><b>FLAT</b>: array elements are rendered without a wrapper (default)</li>
     *     <li><b>WRAPPED</b>: array elements are enclosed within a container element</li>
     * </ul>
     * </p>
     *
     * <h4>Example</h4>
     * <pre>{@code
     * String xml = client.convert()
     *     .data()
     *     .jsonToXml("{\"items\":[1,2,3]}", ArrayMode.WRAPPED);
     * }</pre>
     *
     * @param json the JSON input
     * @param arrayMode optional array handling mode (if null → FLAT)
     * @return generated XML
     * @throws DevHubClientException if the API call fails
     */
    public String jsonToXml(String json, ArrayMode arrayMode) throws DevHubClientException {
        try {
            String mode = (arrayMode != null ? arrayMode.name() : ArrayMode.FLAT.name());
            return api.convertJsonToXml(json, mode).block();
        } catch (WebClientResponseException ex) {
            throw new DevHubClientException(ex);
        }
    }

    // ============================================================
    // ================= XML → JSON ================================
    // ============================================================

    /**
     * Converts XML content into JSON using default options.
     *
     * <p>
     * Default behavior:
     * <ul>
     *     <li>forceArray = false</li>
     *     <li>stripNamespaces = false</li>
     * </ul>
     * </p>
     *
     * @param xml the XML input
     * @return generated JSON
     * @throws DevHubClientException if the API call fails
     */
    public String xmlToJson(String xml) throws DevHubClientException {
        return xmlToJson(xml, false, false);
    }

    /**
     * Converts XML content into JSON with advanced options.
     *
     * <p>
     * Options:
     * <ul>
     *     <li><b>forceArray</b>: forces elements to always be represented as arrays</li>
     *     <li><b>stripNamespaces</b>: removes XML namespace prefixes from keys</li>
     * </ul>
     * </p>
     *
     * <h4>Example</h4>
     * <pre>{@code
     * String json = client.convert()
     *     .data()
     *     .xmlToJson("<root><item>1</item></root>", true, true);
     * }</pre>
     *
     * @param xml the XML input
     * @param forceArray whether to force array representation (default = false)
     * @param stripNamespaces whether to remove namespaces (default = false)
     * @return generated JSON
     * @throws DevHubClientException if the API call fails
     */
    public String xmlToJson(String xml,
                        boolean forceArray,
                        boolean stripNamespaces) throws DevHubClientException {
        try {
            return api.convertXmlToJson(xml, forceArray, stripNamespaces).block();
        } catch (WebClientResponseException ex) {
            throw new DevHubClientException(ex);
        }
    }

    // ============================================================
    // ================= YAML → JSON ===============================
    // ============================================================

    /**
     * Converts YAML content into JSON format.
     *
     * <p>
     * This method transforms structured YAML into equivalent JSON representation,
     * preserving nested objects, arrays and scalar values.
     * </p>
     *
     * <h4>Use case</h4>
     * <ul>
     *     <li>Convert configuration files (YAML → JSON)</li>
     *     <li>Normalize data formats across systems</li>
     *     <li>Prepare YAML content for JSON-based APIs</li>
     * </ul>
     *
     * <h4>Example</h4>
     * <pre>{@code
     * String json = client.convert()
     *     .data()
     *     .yamlToJson("name: John\nage: 30");
     * }</pre>
     *
     * @param yaml the YAML input
     * @return generated JSON
     * @throws DevHubClientException if the API call fails
     */
    public String yamlToJson(String yaml) throws DevHubClientException {
        try {
            return api.convertYamlToJson(yaml).block();
        } catch (WebClientResponseException ex) {
            throw new DevHubClientException(ex);
        }
    }

    // ============================================================
    // ================= JSON → YAML ===============================
    // ============================================================

    /**
     * Converts JSON content into YAML format.
     *
     * <p>
     * This method transforms structured JSON into equivalent YAML representation,
     * preserving nested objects, arrays and scalar values.
     * </p>
     *
     * <h4>Use case</h4>
     * <ul>
     *     <li>Convert JSON responses into human-readable YAML</li>
     *     <li>Generate configuration files from JSON data</li>
     *     <li>Normalize data formats across systems</li>
     * </ul>
     *
     * <h4>Example</h4>
     * <pre>{@code
     * String yaml = client.convert()
     *     .data()
     *     .jsonToYaml("{\"name\":\"John\",\"age\":30}");
     * }</pre>
     *
     * @param json the JSON input
     * @return generated YAML
     * @throws DevHubClientException if the API call fails
     */
    public String jsonToYaml(String json) throws DevHubClientException {
        try {
            return api.convertJsonToYaml(json).block();
        } catch (WebClientResponseException ex) {
            throw new DevHubClientException(ex);
        }
    }

    /**
     * Converts CSV input into JSON format using a fluent builder.
     *
     * <p>
     * This method returns a {@link CsvToJsonBuilder} that allows configuring
     * CSV parsing options such as delimiter, quoting behavior, trimming, and type inference.
     * </p>
     *
     * <h4>Use case</h4>
     * <ul>
     *     <li>Convert CSV data into structured JSON</li>
     *     <li>Handle different CSV formats (custom delimiters, quotes, etc.)</li>
     *     <li>Normalize and parse tabular data for APIs or storage</li>
     * </ul>
     *
     * <h4>Example</h4>
     * <pre>{@code
     * String json = client.convert()
     *     .data()
     *     .csvToJson("name;age\nJohn;30")
     *     .delimiter(Delimiter.SEMICOLON)
     *     .inferTypes(true)
     *     .convert();
     * }</pre>
     *
     * @param csv the CSV input string to convert
     * @return a {@link CsvToJsonBuilder} for further configuration and execution
     */
    public CsvToJsonBuilder csvToJson(String csv) {
        return new CsvToJsonBuilder(api, csv);
    }

    /**
     * Converts JSON input into CSV format using a fluent builder.
     *
     * <p>
     * This method returns a {@link JsonToCsvBuilder} that allows configuring
     * CSV output options such as delimiter, quoting behavior, and quote characters.
     * </p>
     *
     * <h4>Use case</h4>
     * <ul>
     *     <li>Export structured JSON data into CSV format</li>
     *     <li>Customize CSV output for compatibility with external systems</li>
     *     <li>Prepare data for spreadsheets or data pipelines</li>
     * </ul>
     *
     * <h4>Example</h4>
     * <pre>{@code
     * String csv = client.convert()
     *     .data()
     *     .jsonToCsv("[{\"name\":\"John\",\"age\":30}]")
     *     .delimiter(Delimiter.COMMA)
     *     .quoteMode(QuoteMode.MINIMAL)
     *     .convert();
     * }</pre>
     *
     * @param json the JSON input string to convert
     * @return a {@link JsonToCsvBuilder} for further configuration and execution
     */
    public JsonToCsvBuilder jsonToCsv(String json) {
        return new JsonToCsvBuilder(api, json);
    }
}