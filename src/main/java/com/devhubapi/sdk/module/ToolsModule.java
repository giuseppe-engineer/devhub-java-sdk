package com.devhubapi.sdk.module;

import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.api.ToolsApi;
import com.devhubapi.sdk.client.DevHubClientException;
import com.devhubapi.sdk.model.PasswordRequest;
import com.devhubapi.sdk.model.PasswordResponse;
import com.devhubapi.sdk.model.UUIDResponse;
import com.devhubapi.sdk.model.Text;
import com.devhubapi.sdk.module.tools.builder.PasswordPresetBuilder;
import com.devhubapi.sdk.module.tools.builder.PasswordCustomBuilder;
import com.devhubapi.sdk.module.tools.PasswordStrength;
import com.devhubapi.sdk.module.tools.PasswordModule;
import com.devhubapi.sdk.module.tools.UuidModule;
import org.springframework.web.reactive.function.client.WebClientResponseException;

/**
 * ToolsModule provides access to DevHub Tools APIs.
 *
 * <p>
 * This module includes utility endpoints such as:
 * <ul>
 *     <li>CSS Minification</li>
 *     <li>JavaScript Minification</li>
 *     <li>Password Generation</li>
 *     <li>UUID Generation (v4 and v5)</li>
 * </ul>
 *
 * <p>
 * All methods require a properly configured {@link DevHubClient}
 * with authentication (Bearer Token).
 */
public final class ToolsModule {

    private final ToolsApi api;

    /**
     * Creates a new ToolsModule using the given API client.
     *
     * @param apiClient the API client to use
     */
    public ToolsModule(ApiClient apiClient) {
        this.api = new ToolsApi(apiClient);
    }

    // =========================
    // Reverse Text
    // =========================

    /**
     * Reverses the given text.
     *
     * <p>Example:</p>
     * <pre>
     *     Input:  "hello"
     *     Output: "olleh"
     * </pre>
     *
     * @param text to reverse
     * @return the reversed text
     * @throws DevHubClientException if fails
     */
    public String reverse(String text) throws DevHubClientException {
        try {
	    Text textObj = new Text();
	    textObj.setText(text);
            Text response = api.reverse(textObj).block();
	    return response.getText();
        } catch (WebClientResponseException ex) {
            throw new DevHubClientException(ex);
        }
    }

    // =========================
    // UUID (Advanced)
    // =========================
    /**
     * Entry point for UUID generation operations.
     *
     * <pre>{@code
     * client.tools().uuid().v4().count(5).generate();
     * client.tools().uuid().v5().namespace("dns").name("example.com").generate();
     * }</pre>
     */
    public UuidModule uuid() {
       return new UuidModule(api);
    }

    public PasswordModule password() {
       return new PasswordModule(api);
    }

    // =========================
    // Minify JavaScript
    // =========================

    /**
     * Minifies JavaScript code.
     *
     * @param js JavaScript source code
     * @return minified JavaScript
     * @throws DevHubClientException if fails
     */
    public String minifyJs(String js) throws DevHubClientException {
        try {
            return api.minifyJs(js).block();
        } catch (WebClientResponseException ex) {
            throw new DevHubClientException(ex);
        }
    }

    // =========================
    // Minify CSS
    // =========================

    /**
     * Minifies CSS code.
     *
     * @param css CSS source code
     * @return minified CSS
     * @throws DevHubClientException if sfails
     */
    public String minifyCss(String css) throws DevHubClientException {
        try {
            return api.minifyCss(css).block();
        } catch (WebClientResponseException ex) {
            throw new DevHubClientException(ex);
        }
    }
}