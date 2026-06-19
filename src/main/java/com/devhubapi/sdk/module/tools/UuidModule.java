package com.devhubapi.sdk.module.tools;

import com.devhubapi.sdk.api.ToolsApi;
import com.devhubapi.sdk.module.tools.builder.UuidV4Builder;
import com.devhubapi.sdk.module.tools.builder.UuidV5Builder;

/**
 * Entry point for UUID generation.
 */
public class UuidModule {

    private final ToolsApi api;

    public UuidModule(ToolsApi api) {
        this.api = api;
    }

    /**
     * Generates UUID v4 (random).
     */
    public UuidV4Builder v4() {
        return new UuidV4Builder(api);
    }

    /**
     * Generates UUID v5 (deterministic).
     */
    public UuidV5Builder v5() {
        return new UuidV5Builder(api);
    }
}