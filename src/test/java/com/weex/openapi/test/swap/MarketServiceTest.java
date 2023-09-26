package com.weex.openapi.test.swap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weex.openapi.BaseTest;
import com.weex.openapi.dto.response.swap.*;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

/**
 * @author weex-sdk-team
 * @date 2019-01-15
 */
public class MarketServiceTest extends BaseTest {

    private static final String symbol = "cmt_btcusdt";

    @Test
    public void time() throws IOException {
        ServerTime result = weexRestClient.contract().weex().market().getTime();
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void getContractsApi() throws IOException {
        List<ContractInfo> result = weexRestClient.contract().weex().market().getContractsApi();
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void getDepthApi() throws IOException {
        Depth result = weexRestClient.contract().weex().market().getDepthApi(symbol, "100");
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void getTickersApi() throws IOException {
        List<Ticker> result = weexRestClient.contract().weex().market().getTickersApi();
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void getTicker() throws IOException {
        JSONObject result = weexRestClient.contract().weex().market().getTicker(symbol);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void getTrades() throws IOException {
        List<Trades> result = weexRestClient.contract().weex().market().getTrades(symbol, "10");
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void getCandles() throws IOException {
        long end = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        JSONArray result = weexRestClient.contract().weex().market().getCandles(symbol,
                null, null,end-60*60*1000, end,"60");
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void getIndex() throws IOException {
        Index result = weexRestClient.contract().weex().market().getIndex(symbol);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void getOpenInterestApi() throws IOException {
        OpenInterestApiDto result = weexRestClient.contract().weex().market().getOpenInterestApi(symbol);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void getPriceLimitApi() throws IOException {
        PriceLimit result = weexRestClient.contract().weex().market().getPriceLimitApi(symbol);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void getFundingTimeApi() throws IOException {
        FundingTime result = weexRestClient.contract().weex().market().getFundingTimeApi(symbol);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void getNewHistoricalFundingRateApi() throws IOException {
        HistoricalFundingRate result = weexRestClient.contract().weex().market().getNewHistoricalFundingRateApi(symbol, "1", "50");
        System.out.println(JSON.toJSONString(result));
    }
    @Test
    public void getMarkPriceApi() throws IOException {
        MarkPrice result = weexRestClient.contract().weex().market().getMarkPriceApi(symbol);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void calOpenCount() throws IOException {
        String result = weexRestClient.contract().weex().market().calOpenCount(symbol, "9999.9393", "20", "9000");
        System.out.println(result);
    }

}
