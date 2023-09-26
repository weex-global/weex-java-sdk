package com.weex.openapi.test.swap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.weex.openapi.BaseTest;
import com.weex.openapi.dto.request.swap.AdjustMarginReq;
import com.weex.openapi.dto.request.swap.AutoAppendMarginReq;
import com.weex.openapi.dto.request.swap.ChangeLeverageReq;
import com.weex.openapi.dto.request.swap.LedgerReq;
import com.weex.openapi.dto.response.swap.AccountInfo;
import com.weex.openapi.dto.response.swap.AccountSetting;
import com.weex.openapi.dto.response.swap.AdjustMarginResult;
import com.weex.openapi.dto.response.swap.AutoAppendMarginResult;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class AccountServiceTest extends BaseTest {

    private static final String symbol = "cmt_btcusdt";

    @Test
    public void accounts() throws IOException {
        List<AccountInfo> result = weexRestClient.contract().weex().account().accounts();
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void getAccount() throws IOException {
        AccountInfo result = weexRestClient.contract().weex().account().getAccount(symbol);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void settings() throws IOException {
        AccountSetting result = weexRestClient.contract().weex().account().settings(symbol);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void adjustMargin() throws IOException {
        AdjustMarginReq req = AdjustMarginReq.builder().symbol(symbol).
                amount("10").
                positionType(0).
                type(1).
                build();
        AdjustMarginResult result = weexRestClient.contract().weex().account().adjustMargin(req);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void modifyAutoAppendMargin() throws IOException {
        AutoAppendMarginReq req = AutoAppendMarginReq.builder().symbol(symbol).
                append_type(0).
                side(2).
                build();
        AutoAppendMarginResult result = weexRestClient.contract().weex().account().modifyAutoAppendMargin(req);
        System.out.println(JSON.toJSONString(result));
    }
}
