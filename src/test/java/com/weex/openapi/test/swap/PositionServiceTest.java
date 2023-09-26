package com.weex.openapi.test.swap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.weex.openapi.BaseTest;
import com.weex.openapi.dto.request.swap.ChangeHoldModel;
import com.weex.openapi.dto.response.swap.AllPosition;
import com.weex.openapi.dto.response.swap.HoldModelDto;
import com.weex.openapi.dto.response.swap.Position;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author weex-sdk-team
 * @date 2019-01-15
 */
public class PositionServiceTest extends BaseTest {
    private static final String symbol = "cmt_btcusdt";

    @Test
    public void getAllPosition() throws IOException {
        List<AllPosition> result = weexRestClient.contract().weex().position().getAllPosition();
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void getSinglePosition() throws IOException {
        AllPosition result = weexRestClient.contract().weex().position().getSinglePosition(symbol);
        System.out.println(JSON.toJSONString(result));
    }
    @Test
    public  void  virtualCapital()throws  IOException{
        JSONObject capital = weexRestClient.contract().weex().position().virtualCapital("usdt", "14", 10, 398526, null);
        System.out.println(JSON.toJSON(capital));
    }
    @Test
    public  void changeHoldMode()throws  IOException{
        ChangeHoldModel holdModel= ChangeHoldModel.builder().holdModel(1).symbol(symbol).build();
        HoldModelDto dto = weexRestClient.contract().weex().position().changeHoldMode(holdModel);
        System.out.println(JSON.toJSON(dto));
    }
}
