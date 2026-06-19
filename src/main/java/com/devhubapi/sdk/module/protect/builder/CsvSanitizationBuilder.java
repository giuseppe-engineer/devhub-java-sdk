package com.devhubapi.sdk.module.protect.builder;

import com.devhubapi.sdk.module.protect.builder.BaseSanitizationBuilder;
import com.devhubapi.sdk.api.DataProtectionApi;
import com.devhubapi.sdk.module.ProtectDataModule;

public class CsvSanitizationBuilder extends BaseSanitizationBuilder {
    public CsvSanitizationBuilder(DataProtectionApi api, String input) {
        super(api, input, ProtectDataModule.Context.CSV);
    }
}