package com.weex.openapi.service.swap.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weex.openapi.api.swap.MarketApi;
import com.weex.openapi.common.client.ApiClient;
import com.weex.openapi.dto.response.swap.*;
import com.weex.openapi.service.swap.MarketService;

import java.io.IOException;
import java.util.List;

/**
 * @author weex-sdk-team
 * @date 2019-01-15
 */
public class MarketServiceImpl implements MarketService {

    private final MarketApi marketApi;

    public MarketServiceImpl(ApiClient client) {
        marketApi = client.create(MarketApi.class);
    }

    @Override
    public ServerTime getTime() throws IOException {
        return marketApi.getTime().execute().body();
    }

    @Override
    public List<ContractInfo> getContractsApi() throws IOException {
        return marketApi.getContractsApi().execute().body();
    }

    @Override
    public List<Ticker> getTickersApi() throws IOException {
        return marketApi.getTickersApi().execute().body();
    }

    @Override
    public JSONObject getTicker(String symbol) throws IOException {
        return marketApi.getTicker(symbol).execute().body();
    }

    @Override
    public List<Trades>  getTrades(String symbol, String limit) throws IOException {
        return marketApi.getTrades(symbol, limit).execute().body();
    }

    @Override
    public Depth getDepthApi(String symbol, String limit) throws IOException {
        return marketApi.getDepthApi(symbol, limit).execute().body();
    }

    @Override
    public JSONArray getCandles(String symbol, String start, String end,Long startTime,Long endTime, String granularity) throws IOException {
        return marketApi.getCandles(symbol, start, end,startTime,endTime,granularity).execute().body();
    }

    @Override
    public Index getIndex(String symbol) throws IOException {
        return marketApi.getIndex(symbol).execute().body();
    }

    @Override
    public OpenInterestApiDto getOpenInterestApi(String symbol) throws IOException {
        return marketApi.getOpenInterestApi(symbol).execute().body();
    }

    @Override
    public PriceLimit getPriceLimitApi(String symbol) throws IOException {
        return marketApi.getPriceLimitApi(symbol).execute().body();
    }

    @Override
    public FundingTime getFundingTimeApi(String symbol) throws IOException {
        return marketApi.getFundingTimeApi(symbol).execute().body();
    }
    @Override
    public HistoricalFundingRate getNewHistoricalFundingRateApi(String symbol, String pageIndex, String pageSize) throws IOException {

        return marketApi.getNewHistoricalFundingRateApi(symbol,pageIndex,pageSize).execute().body();
    }

    @Override
    public MarkPrice getMarkPriceApi(String symbol) throws IOException {
        return marketApi.getMarkPriceApi(symbol).execute().body();
    }


    @Override
    public String calOpenCount(String symbol, String amount, String leverage, String openPrice) throws IOException {
        return marketApi.calOpenCount(symbol, amount, leverage, openPrice).execute().body();
    }

}
