package com.weex.openapi.test.spot;

import com.alibaba.fastjson.JSON;
import com.weex.openapi.BaseTest;
import com.weex.openapi.common.enums.spot.ForceEnum;
import com.weex.openapi.common.enums.spot.OrderSideEnum;
import com.weex.openapi.common.enums.spot.SpotOrderTypeEnum;
import com.weex.openapi.dto.request.spot.*;
import com.weex.openapi.dto.response.swap.ResponseResult;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpotOrderServiceTest extends BaseTest {

    static String symbol = "BTCUSDT_SPBL";

    @Test
    public void orders() throws IOException {
        SpotOrderReq spotOrderReq = SpotOrderReq.builder()
                                                .symbol(symbol)
                                                .price("47523.03")
                                                .quantity("0.017963")
                                                .side(OrderSideEnum.BUY.getCode())
                                                .orderType(SpotOrderTypeEnum.LIMIT.getCode())
                                                .force(ForceEnum.NORMAL.getCode())
                                                .build();
//        SpotOrderReq spotOrderReq = SpotOrderReq.builder().symbol(symbol).quantity("10")
//                .side(OrderSideEnum.BUY.getCode()).orderType(SpotOrderTypeEnum.LIMIT.getCode())
//                .force(ForceEnum.NORMAL.getCode()).build();

//        SpotOrderReq spotOrderReq = SpotOrderReq.builder()
//                .symbol(symbol)
//                .quantity("30")
//                .side(OrderSideEnum.BUY.getCode())
//                .orderType(SpotOrderTypeEnum.MARKET.getCode())
//                .force(ForceEnum.NORMAL.getCode())
//                .clientOrderId("clientId1624948230000")
//                .build();

        ResponseResult orders = weexRestClient.spot().weex().order().orders(spotOrderReq);
        System.out.println(JSON.toJSONString(orders));
    }

    @Test
    public void batchOrders() throws IOException {
        List<SpotOrdersReq> list = new ArrayList<>();
        SpotOrdersReq one = SpotOrdersReq.builder()
                .price("47523.03")
                .quantity("0.017963")
                .side(OrderSideEnum.BUY.getCode())
                .orderType(SpotOrderTypeEnum.LIMIT.getCode())
                .force(ForceEnum.NORMAL.getCode())
                .clientOrderId("spot#1625039618000")
                .build();
        SpotOrdersReq two = SpotOrdersReq.builder()
                .price("47523.03")
                .quantity("0.017963")
                .side(OrderSideEnum.BUY.getCode())
                .orderType(SpotOrderTypeEnum.LIMIT.getCode())
                .force(ForceEnum.NORMAL.getCode())
                .clientOrderId("spot#1625039618122")
                .build();

        list.add(one);
        list.add(two);
        SpotBatchOrdersReq build = SpotBatchOrdersReq.builder()
                .symbol(symbol)
                .orderList(list)
                .build();

        ResponseResult orders = weexRestClient.spot().weex().order().batchOrders(build);
        System.out.println(JSON.toJSONString(orders));
    }


    @Test
    public void cancelOrder() throws IOException {
        SpotCancelOrderReq cancelOrderReq = SpotCancelOrderReq.builder().orderId("892628661368389632").symbol(symbol).build();

        ResponseResult result = weexRestClient.spot().weex().order().cancelOrder(cancelOrderReq);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void cancelBatchOrder() throws IOException {
        SpotCancelBatchOrderReq batchOrderReq = SpotCancelBatchOrderReq.builder().symbol(symbol).orderIds(Arrays.asList("892628661410332672")).build();

        ResponseResult result = weexRestClient.spot().weex().order().cancelBatchOrder(batchOrderReq);
        System.out.println(JSON.toJSONString(result));
    }


    @Test
    public void orderInfo() throws IOException {
        SpotOrderInfoReq orderInfoReq = SpotOrderInfoReq.builder().symbol(symbol).orderId("892628661410332672").build();

        ResponseResult result = weexRestClient.spot().weex().order().orderInfo(orderInfoReq);
        System.out.println(JSON.toJSONString(result));
    }


    @Test
    public void openOrders() throws IOException {
        SpotOpenOrderReq openOrderReq = SpotOpenOrderReq.builder().symbol(symbol).build();

        ResponseResult result = weexRestClient.spot().weex().order().openOrders(openOrderReq);
        System.out.println(JSON.toJSONString(result));
    }


    @Test
    public void history() throws IOException {
        SpotHistoryOrderReq historyOrderReq = SpotHistoryOrderReq.builder().symbol(symbol).build();

        ResponseResult result = weexRestClient.spot().weex().order().history(historyOrderReq);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void fills() throws IOException {
        SpotFillsOrderReq fillsOrderReq = SpotFillsOrderReq.builder().symbol(symbol)
                .orderId("892628661368389632")
                .build();

        ResponseResult result = weexRestClient.spot().weex().order().fills(fillsOrderReq);
        System.out.println(JSON.toJSONString(result));
    }


}
