package com.weex.openapi.test.spot;

import com.alibaba.fastjson.JSON;
import com.weex.openapi.BaseTest;
import com.weex.openapi.common.enums.SpotDepthTypeEnum;
import com.weex.openapi.dto.response.swap.ResponseResult;
import org.junit.Test;

import java.io.IOException;

public class MarketServiceTest extends BaseTest {

    static String symbol = "BTCUSDT_SPBL";

    static Integer limit = 50;

    static String period = "1min";

    static String after = "1624929806000";

    static String before = "1624933406000";

    @Test
    public void fills() throws IOException {
        ResponseResult fills = weexRestClient.spot().weex().market().fills(symbol, limit);
        System.out.println(JSON.toJSONString(fills));
    }

    @Test
    public void depth() throws IOException {
        ResponseResult depth = weexRestClient.spot().weex().market().depth(symbol, limit, SpotDepthTypeEnum.STEP0.getCode());
        System.out.println(JSON.toJSONString(depth));
    }

    @Test
    public void ticker() throws IOException {
        ResponseResult ticker = weexRestClient.spot().weex().market().ticker(symbol);
        System.out.println(JSON.toJSONString(ticker));
    }

    @Test
    public void tickers() throws IOException {
        ResponseResult tickers = weexRestClient.spot().weex().market().tickers();
        System.out.println(JSON.toJSONString(tickers));
    }

    @Test
    public void candles() throws IOException {
        ResponseResult candles = weexRestClient.spot().weex().market().candles(symbol, period, after, before, limit);
        System.out.println(JSON.toJSONString(candles));
    }

}
