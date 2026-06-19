package com.devhubapi.sdk.module.tools;

import com.devhubapi.sdk.api.ToolsApi;
import com.devhubapi.sdk.module.tools.builder.PasswordCustomBuilder;
import com.devhubapi.sdk.module.tools.builder.PasswordPresetBuilder;
import com.devhubapi.sdk.module.tools.PasswordStrength;

/**
 * Entry point for password generation operations.
 */
public class PasswordModule {

    private final ToolsApi api;

    public PasswordModule(ToolsApi api) {
        this.api = api;
    }

    /**
    * Starts a password generation using a predefined strength preset.
    *
    * <p>
    * When using presets, manual configuration parameters are ignored by the API.
    * </p>
    *
    * <pre>{@code
    * String pwd = client.tools()
    *     .passwordPreset(PasswordStrength.STRONG)
    *     .exclude("!@#")
    *     .generate();
    * }</pre>
    *
    * @param strength password strength preset
    * @return PasswordPresetBuilder
    */
   private PasswordPresetBuilder passwordPreset(PasswordStrength strength) {
      return new PasswordPresetBuilder(api, strength);
   }

   /**
    * Starts a password generation using manual configuration.
    *
    * <pre>{@code
    * String pwd = client.tools()
    *     .password()
    *     .customPassword()
    *     .length(12)
    *     .includeLetters(true)
    *     .includeNumbers(false)
    *     .includeSpecials(true)
    *     .exclude("!@#")
    *     .generate();
    * }</pre>
    *
    * @return PasswordCustomBuilder
    */
   public PasswordCustomBuilder customPassword() {
      return new PasswordCustomBuilder(api);
   }

   /**
    * Shortcut for WEAK preset.
    */
    public PasswordPresetBuilder weakPassword() {
       return passwordPreset(PasswordStrength.WEAK);
    }

   /**
    * Shortcut for MEDIUM preset.
    */
    public PasswordPresetBuilder mediumPassword() {
       return passwordPreset(PasswordStrength.MEDIUM);
    }

   /**
    * Shortcut for STRONG preset.
    */
    public PasswordPresetBuilder strongPassword() {
       return passwordPreset(PasswordStrength.STRONG);
    }

   /**
    * Shortcut for ULTRA preset.
    */
    public PasswordPresetBuilder ultraPassword() {
       return passwordPreset(PasswordStrength.ULTRA);
    }
}