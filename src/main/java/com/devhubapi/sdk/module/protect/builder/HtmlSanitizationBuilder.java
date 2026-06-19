package com.devhubapi.sdk.module.protect.builder;

import com.devhubapi.sdk.module.protect.builder.BaseSanitizationBuilder;
import com.devhubapi.sdk.api.DataProtectionApi;
import com.devhubapi.sdk.client.DevHubClientException;
import com.devhubapi.sdk.module.ProtectDataModule;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.ArrayList;
import java.util.List;


public class HtmlSanitizationBuilder extends BaseSanitizationBuilder {

    public HtmlSanitizationBuilder(DataProtectionApi api, String input) {
        super(api, input, ProtectDataModule.Context.HTML);
    }

   // ============================================================
   // ======================== MODE ===============================
   // ============================================================

   /**
    * Sets the sanitization mode for HTML content.
    *
    * <p>If not explicitly set, the default mode is {@code RELAXED} for HTML context.</p>
    *
    * @param mode the HTML sanitization mode
    * @return this builder instance for chaining
    */
    public HtmlSanitizationBuilder mode(ProtectDataModule.SanitizationHtmlMode mode) {
        if (mode != null) {
            request.setMode(mode.name());
        }
        return this;
    }

    /**
     * Applies default values before executing the request.
     *
     * <ul>
     *     <li>Sets HTML mode to RELAXED if context is HTML and mode is not defined</li>
     *     <li>Ensures operations list is not null</li>
     * </ul>
     */
    @Override
    protected void applyDefaults() {
        super.applyDefaults();

        if (request.getMode() == null) {
            request.setMode(ProtectDataModule.SanitizationHtmlMode.RELAXED.name());
        }
    }
}