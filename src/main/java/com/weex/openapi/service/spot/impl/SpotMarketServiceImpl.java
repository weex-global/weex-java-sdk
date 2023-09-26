package com.weex.openapi.service.spot.impl;

import com.weex.openapi.api.spot.SpotMarketApi;
import com.weex.openapi.common.client.ApiClient;
import com.weex.openapi.dto.response.swap.ResponseResult;
import com.weex.openapi.service.spot.SpotMarketService;

import java.io.IOException;

public class SpotMarketServiceImpl implements SpotMarketService {

    private final SpotMarketApi spotMarketApi;

    public SpotMarketServiceImpl(ApiClient client){
        spotMarketApi = client.create(SpotMarketApi.class);
    }

    @Override
    public ResponseResult fills(String symbol,Integer limit) throws IOException {
        return spotMarketApi.fills(symbol,limit).execute().body();
    }

    @Override
    public ResponseResult depth(String symbol, Integer limit, String type) throws IOException {
        return spotMarketApi.depth(symbol,limit,type).execute().body();
    }

    @Override
    public ResponseResult ticker(String symbol) throws IOException {
        return spotMarketApi.ticker(symbol).execute().body();
    }

    @Override
    public ResponseResult tickers() throws IOException {
        return spotMarketApi.tickers().execute().body();
    }


    @Override
    public ResponseResult candles(String symbol,String period,String after,String before,Integer limit) throws IOException{
        return spotMarketApi.candles(symbol,period,after,before,limit).execute().body();
    }
}
