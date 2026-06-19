package com.devhubapi.sdk.module;

import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.module.convert.DataConversionModule;

/**
 * Entry point for conversion APIs.
 *
 * Provides access to:
 * - Data conversions (JSON, CSV, HTML, etc.)
 * - File conversions (coming soon)
 */
public final class ConvertModule {

    private final ApiClient apiClient;

    public ConvertModule(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Access data-based conversions.
     *
     * @return DataConversionModule
     */
    public DataConversionModule data() {
        return new DataConversionModule(apiClient);
    }

    // futura estensione
    // public FileConversionModule file() { ... }
}