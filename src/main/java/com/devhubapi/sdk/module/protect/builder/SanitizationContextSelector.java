package com.devhubapi.sdk.module.protect.builder;

import com.devhubapi.sdk.api.DataProtectionApi;
import com.devhubapi.sdk.module.ProtectDataModule;
import com.devhubapi.sdk.module.protect.builder.BaseSanitizationBuilder;
import com.devhubapi.sdk.module.protect.builder.HtmlSanitizationBuilder;
import com.devhubapi.sdk.module.protect.builder.JsonSanitizationBuilder;
import com.devhubapi.sdk.module.protect.builder.CsvSanitizationBuilder;
import com.devhubapi.sdk.module.protect.builder.LogSanitizationBuilder;

public class SanitizationContextSelector {

    private final DataProtectionApi api;
    private final String input;

    public SanitizationContextSelector(DataProtectionApi api, String input) {
        this.api = api;
        this.input = input;
    }

    /**
     * Starts a fluent sanitization flow for HTML input.
     */
    public HtmlSanitizationBuilder html() {
        return new HtmlSanitizationBuilder(api, input);
    }

    /**
     * Starts a fluent sanitization flow for JSON input.
     */
    public BaseSanitizationBuilder json() {
        return new JsonSanitizationBuilder(api, input);
    }

    /**
     * Starts a fluent sanitization flow for CSV input.
     */
    public BaseSanitizationBuilder csv() {
        return new CsvSanitizationBuilder(api, input);
    }

    /**
     * Starts a fluent sanitization flow for LOG input.
     */
    public BaseSanitizationBuilder log() {
        return new LogSanitizationBuilder(api, input);
    }
}