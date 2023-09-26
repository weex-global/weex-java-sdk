package com.weex.openapi.common.client;

import com.weex.openapi.ContractApiFacade;
import com.weex.openapi.SpotApiFacade;
import com.weex.openapi.common.constant.HttpHeader;
import com.weex.openapi.common.domain.ClientParameter;
import com.weex.openapi.common.enums.SupportedLocaleEnum;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/**
 * @author weex-sdk-team
 * @date 2019-01-15
 */
public class WeexRestClient {
    private final ApiClient apiClient;
    private final ClientParameter configuration;

    private WeexRestClient(Builder builder) {
        configuration = builder.configuration;
        Validate.notNull(configuration, "configuration is null");
        Validate.notNull(configuration.getApiKey(), "apiKey is null");
        Validate.notNull(configuration.getSecretKey(), "secretKey is null");
        Validate.notNull(configuration.getPassphrase(), "passphrase is null");

        configuration.setBaseUrl(StringUtils.defaultIfBlank(configuration.getBaseUrl(), HttpHeader.BASE_URL));
        configuration.setTimeout(ObjectUtils.defaultIfNull(configuration.getTimeout(), HttpHeader.TIME_OUT));
        configuration.setLocale(ObjectUtils.defaultIfNull(configuration.getLocale(), SupportedLocaleEnum.EN_US.getName()));

        apiClient = new ApiClient(configuration);
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Contract REST API Endpoint
     *
     * @return ContractApiFacade
     */
    public ContractApiFacade contract() {
        return new ContractApiFacade(apiClient);
    }

    /**
     * spot rest api
     *
     * @return
     */
    public SpotApiFacade spot() {
        return new SpotApiFacade(apiClient);
    }

    public static class Builder {
        private ClientParameter configuration;

        public Builder configuration(ClientParameter value) {
            configuration = value;
            return this;
        }

        public WeexRestClient build() {
            return new WeexRestClient(this);
        }
    }
}
