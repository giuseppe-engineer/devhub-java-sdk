package com.devhubapi.sdk.client;

import com.devhubapi.sdk.ApiClient;
import com.devhubapi.sdk.api.LoginApi;
import com.devhubapi.sdk.module.ConvertModule;
import com.devhubapi.sdk.module.ToolsModule;
import com.devhubapi.sdk.module.ProtectDataModule;
import com.devhubapi.sdk.model.AuthRequest;
import com.devhubapi.sdk.model.AuthResponse;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.UUID;

public final class DevHubClient {

    private static final String DEFAULT_BASE_PATH = "https://devhub-api.com";

    private final ApiClient apiClient;
    private final ConvertModule convertModule;
    private final ToolsModule toolsModule;
    private final ProtectDataModule protectDataModule;


    private DevHubClient(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.convertModule = new ConvertModule(apiClient);
	this.toolsModule = new ToolsModule(apiClient);
	this.protectDataModule = new ProtectDataModule(apiClient);
    }

    public static Builder builder() {
        return new Builder();
    }

    public ConvertModule convert() {
        return convertModule;
    }

    public ToolsModule tools() {
        return toolsModule;
    }

    public ProtectDataModule protectData() {
        return protectDataModule;
    }

    public ApiClient api() {
        return apiClient;
    }

    // =========================================================
    // BUILDER
    // =========================================================

    public static final class Builder {

        private final ApiClient apiClient;
        private String username;
        private String password;

        public Builder() {
            this.apiClient = new ApiClient();
            this.apiClient.setBasePath(DEFAULT_BASE_PATH);
        }

        public Builder withBasePath(String basePath) {
            apiClient.setBasePath(basePath);
            return this;
        }

        public Builder withBearerToken(String token) {
            apiClient.setBearerToken(token);
            return this;
        }

        /**
         * Automatic login using username/password.
         */
        public Builder withCredentials(String username, String password) {
            this.username = username;
            this.password = password;
            return this;
        }

        public Builder withRequestId(UUID requestId) {
            if (requestId != null) {
                apiClient.addDefaultHeader("X-Request-Id", requestId.toString());
            }
            return this;
        }

        public Builder withAutoRequestId() {
            return withRequestId(UUID.randomUUID());
        }

        public DevHubClient build() {

            // If credentials provided → perform login automatically
            if (username != null && password != null) {

                try {

                    LoginApi loginApi = new LoginApi(apiClient);

                    AuthRequest request = new AuthRequest();
                    request.setUsername(username);
                    request.setPassword(password);

                    AuthResponse response = loginApi.login(request).block();

                    apiClient.setBearerToken(response.getAccessToken());

                } catch (WebClientResponseException ex) {
                    throw new DevHubClientException(ex);
                }
            }

            return new DevHubClient(apiClient);
        }
    }
}