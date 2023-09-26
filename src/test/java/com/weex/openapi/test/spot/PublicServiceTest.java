package com.weex.openapi.test.spot;

import com.alibaba.fastjson.JSON;
import com.weex.openapi.BaseTest;
import com.weex.openapi.dto.response.swap.ResponseResult;
import org.junit.Test;

import java.io.IOException;

public class PublicServiceTest extends BaseTest {


    @Test
    public void time() throws IOException {
        ResponseResult time = weexRestClient.spot().weex().common().time();
        System.out.println(JSON.toJSONString(time));
    }

    @Test
    public void currencies() throws IOException {
        ResponseResult currencies = weexRestClient.spot().weex().common().currencies();
        System.out.println(JSON.toJSONString(currencies));
    }

    @Test
    public void products() throws IOException {
        ResponseResult products = weexRestClient.spot().weex().common().products();
        System.out.println(JSON.toJSONString(products));
    }

    @Test
    public void product() throws IOException {
        ResponseResult productSingle = weexRestClient.spot().weex().common().product("BTCUSDT_SPBL");
        System.out.println(JSON.toJSONString(productSingle));
    }

}
