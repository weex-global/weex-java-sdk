package com.weex.openapi.service.spot.impl;

import com.weex.openapi.api.spot.SpotPublicApi;
import com.weex.openapi.common.client.ApiClient;
import com.weex.openapi.dto.response.swap.ResponseResult;
import com.weex.openapi.service.spot.SpotPublicService;

import java.io.IOException;

public class SpotPublicServiceImpl implements SpotPublicService {

    private final SpotPublicApi spotPublicApi;

    public SpotPublicServiceImpl(ApiClient client) {
        spotPublicApi = client.create(SpotPublicApi.class);
    }

    @Override
    public ResponseResult time() throws IOException {
        return spotPublicApi.time().execute().body();
    }

    @Override
    public ResponseResult currencies() throws IOException {
        return spotPublicApi.currencies().execute().body();
    }

    @Override
    public ResponseResult products() throws IOException{
        return spotPublicApi.products().execute().body();
    }

    @Override
    public ResponseResult product(String symbol) throws IOException{
        return spotPublicApi.product(symbol).execute().body();
    }

}
