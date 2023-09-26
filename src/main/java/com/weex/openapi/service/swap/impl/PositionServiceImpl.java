package com.weex.openapi.service.swap.impl;


import com.alibaba.fastjson.JSONObject;
import com.weex.openapi.api.swap.PositionApi;
import com.weex.openapi.common.client.ApiClient;
import com.weex.openapi.dto.request.swap.ChangeHoldModel;
import com.weex.openapi.dto.response.swap.AllPosition;
import com.weex.openapi.dto.response.swap.HoldModelDto;
import com.weex.openapi.service.swap.PositionService;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;

/**
 * @author weex-sdk-team
 * @date 2019-01-15
 */
public class PositionServiceImpl implements PositionService {

    private final PositionApi positionApi;

    public PositionServiceImpl(ApiClient client) {
        positionApi = client.create(PositionApi.class);
    }

    @Override
    public List<AllPosition> getAllPosition() throws IOException {
        return positionApi.getAllPosition().execute().body();
    }

    @Override
    public AllPosition getSinglePosition(String symbol) throws IOException {
        return positionApi.getSinglePosition(symbol).execute().body();
    }

    @Override
    public JSONObject virtualCapital(String symbol, String ftype, Integer limit, Integer gt, Integer lt) throws IOException {
        Call<JSONObject> call= positionApi.virtualCapital(symbol, ftype, limit, gt, lt);
        return call.execute().body();
    }

    @Override
    public HoldModelDto changeHoldMode(ChangeHoldModel holdModel)  throws IOException{
        Call<HoldModelDto> call = positionApi.changeHoldMode(holdModel);
        return call.execute().body();
    }
}
