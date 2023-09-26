package com.weex.openapi;

import com.weex.openapi.common.client.ApiClient;
import com.weex.openapi.service.spot.SpotAccountService;
import com.weex.openapi.service.spot.SpotMarketService;
import com.weex.openapi.service.spot.SpotOrderService;
import com.weex.openapi.service.spot.SpotPublicService;
import com.weex.openapi.service.spot.impl.SpotAccountServiceImpl;
import com.weex.openapi.service.spot.impl.SpotMarketServiceImpl;
import com.weex.openapi.service.spot.impl.SpotOrderServiceImpl;
import com.weex.openapi.service.spot.impl.SpotPublicServiceImpl;

/**
 * @Author: weex
 * @Date: 2021-05-31 15:20
 * @DES: spot
 */
public class SpotApiFacade {

    private final ApiClient apiClient;

    public SpotApiFacade(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * REST API Endpoint
     *
     * @return SpotEndpoint
     */
    public SpotApiFacade.SpotEndpoint weex() {
        return new SpotApiFacade.SpotEndpoint(apiClient);
    }

    public static class SpotEndpoint {
        private final ApiClient apiClient;

        SpotEndpoint(ApiClient apiClient) {
            this.apiClient = apiClient;
        }

        /**
         * account service
         */
        public SpotAccountService account() {
            return new SpotAccountServiceImpl(apiClient);
        }

        /**
         * common service
         */
        public SpotPublicService common() {
            return new SpotPublicServiceImpl(apiClient);
        }

        /**
         * market service
         */
        public SpotMarketService market() {
            return new SpotMarketServiceImpl(apiClient);
        }

        /**
         * order service
         */
        public SpotOrderService order() {
            return new SpotOrderServiceImpl(apiClient);
        }


    }
}
