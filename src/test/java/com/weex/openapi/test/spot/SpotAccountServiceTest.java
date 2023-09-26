package com.weex.openapi.test.spot;

import com.alibaba.fastjson.JSON;
import com.weex.openapi.BaseTest;
import com.weex.openapi.dto.request.spot.SpotBillQueryReq;
import com.weex.openapi.dto.response.swap.ResponseResult;
import org.junit.Test;

import java.io.IOException;

public class SpotAccountServiceTest extends BaseTest {


    @Test
    public void assets() throws IOException {
        ResponseResult assets = weexRestClient.spot().weex().account().assets();
        System.out.println(JSON.toJSONString(assets));
    }


    @Test
    public void bills() throws IOException {
        SpotBillQueryReq build = SpotBillQueryReq.builder()
//                .coinId(1)
//                .before(777031099461570560L)
                .build();
        ResponseResult assets = weexRestClient.spot().weex().account().bills(build);
        System.out.println(JSON.toJSONString(assets));
    }

    @Test
    public void transferRecords() throws IOException {
        SpotBillQueryReq build = SpotBillQueryReq.builder()
//                .coinId(1)
//                .before(777031099461570560L)
                .build();
        ResponseResult assets = weexRestClient.spot().weex().account().transferRecords("2","USDT_MIX","10","","");
        System.out.println(JSON.toJSONString(assets));
    }

}
