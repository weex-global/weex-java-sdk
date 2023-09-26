package com.weex.openapi;

import com.weex.openapi.common.client.ApiClient;
import com.weex.openapi.service.swap.impl.*;
import com.weex.openapi.service.swap.*;

/**
 * @author weex-sdk-team
 * @date 2019-01-15
 */
public class ContractApiFacade {
    private final ApiClient apiClient;

    public ContractApiFacade(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * REST API Endpoint
     *
     * @return ContractEndpoint
     */
    public ContractEndpoint weex() {
        return new ContractEndpoint(apiClient);
    }

    public static class ContractEndpoint {
        private final ApiClient apiClient;

        public ContractEndpoint(ApiClient apiClient) {
            this.apiClient = apiClient;
        }

        /**
         * order service
         */
        public OrderService order() {
            return new OrderServiceImpl(apiClient);
        }

        /**
         * position service
         */
        public PositionService position() {
            return new PositionServiceImpl(apiClient);
        }

        /**
         * market service
         *
         * @return
         */
        public MarketService market() {
            return new MarketServiceImpl(apiClient);
        }

        /**
         * account service
         *
         * @return
         */
        public AccountService account() {
            return new AccountServiceImpl(apiClient);
        }

    }
}
