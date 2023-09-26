package com.weex.openapi.test.swap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.weex.openapi.BaseTest;
import com.weex.openapi.common.enums.MatchTypeEnum;
import com.weex.openapi.common.enums.OrderTypeEnum;
import com.weex.openapi.dto.request.swap.*;
import com.weex.openapi.dto.response.swap.CancelPlanResult;
import com.weex.openapi.dto.response.swap.Fill;
import com.weex.openapi.dto.response.swap.PlanPlaceOrderResult;
import com.weex.openapi.dto.response.swap.PlansOrderResult;
import com.weex.openapi.dto.response.swap.*;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

/**
 * @author weex-sdk-team
 * @date 2019-01-15
 */
public class OrderServiceTest extends BaseTest {

    private static final String symbol = "cmt_btcusdt";

    @Test
    public void postOrder() throws IOException {
        OrderReq req = OrderReq.builder().client_oid("RFIut#1594137696335").symbol(symbol).match_price(MatchTypeEnum.LIMIT.getCode())
                .order_type(OrderTypeEnum.LIMIT.getCode().toString()).size("1").type("1").price("9209.5").build();
        PlaceOrderResult result = weexRestClient.contract().weex().order().placeOrder(req);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void batchOrders() throws IOException {

        PlaceBatchOrderReq req = PlaceBatchOrderReq.builder().symbol(symbol).orderDataList(null)
                .build();
        OrderInfoResult result = weexRestClient.contract().weex().order().batchOrders(req);
        System.out.println(JSON.toJSONString(result));
    }

    // pass
    @Test
    public void cancelOrder() throws IOException {
        CancelOrderParam param = CancelOrderParam.builder().symbol(symbol).orderId("664668908963233715").build();
        CancelOrderResult result = weexRestClient.contract().weex().order().cancelOrder(param);
        System.out.println(JSON.toJSONString(result));
    }

    // pass
    @Test
    public void cancelBathOrders() throws IOException {
        CancelBatchOrdersReq req = CancelBatchOrdersReq.builder()
                .ids(Arrays.asList(new String[]{"662049979816214513", "662050232694996913"})).symbol(symbol).build();
        CancelBatchOrderResult result = weexRestClient.contract().weex().order().cancelBathOrders(req);
        System.out.println(JSON.toJSONString(result));
    }

    // pass
    @Test
    public void getOrderDetail() throws IOException {
        Order result = weexRestClient.contract().weex().order().getOrderDetail(symbol, "662052689865080815");
        System.out.println(JSON.toJSONString(result));
    }


    @Test
    public void getOrdersHistory() throws IOException{
        List<Order> ordersHistory = weexRestClient.contract().weex().order().getOrdersHistory(symbol, "1", "1", 0);
        System.out.println(ordersHistory);
    }

    @Test
    public void getOrdersCurrent() throws IOException{
        List<Order> ordersCurrent = weexRestClient.contract().weex().order().getOrdersCurrent(symbol);
        System.out.println(ordersCurrent);
    }

    // pass
    @Test
    public void getFills() throws IOException {
        List<Fill> result = weexRestClient.contract().weex().order().getFills(symbol, "662062239896829913");
        System.out.println(JSON.toJSONString(result));
    }

    // pass
    @Test
    public void planOrder() throws IOException {
        PlanPlaceOrderReq req = PlanPlaceOrderReq.builder().client_oid("weex#1594137696335").symbol(symbol).execute_price("1000")
                .match_type(MatchTypeEnum.MARKET.getCode()).side("1").size("100").trigger_price("125").type("1")
                .build();
        PlanPlaceOrderResult result = weexRestClient.contract().weex().order().planOrder(req);
        System.out.println(JSON.toJSONString(result));
    }

    // pass
    @Test
    public void cancelPlan() throws IOException {
        CancelPlanParamReq planParamReq = CancelPlanParamReq.builder().symbol(symbol).orderId("649008575284248513")
                .build();
        CancelPlanResult result = weexRestClient.contract().weex().order().cancelPlan(planParamReq);
        System.out.println(JSON.toJSONString(result));
    }

    // pass
    @Test
    public void currentPlan() throws IOException {
        long end = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long start = end-60*60*1000;
        PlanOrderReq req = PlanOrderReq.builder().page_index("1").page_size("50").side("2").end_time(String.valueOf(end))
                .start_time(String.valueOf(start)).delegateType("2").build();
        PlansOrderResult result = weexRestClient.contract().weex().order().currentPlan(symbol, req);
        System.out.println(JSON.toJSONString(result));
    }

    // pass
    @Test
    public void historyPlan() throws IOException {
        long end = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long start = end-30*24*60*60*1000;
        PlanOrderReq req = PlanOrderReq.builder().page_index("1").page_size("50").side("4").end_time(String.valueOf(end))
                .start_time(String.valueOf(start)).delegateType("4").build();
        PlansOrderResult result = weexRestClient.contract().weex().order().historyPlan(symbol, req);
        System.out.println(JSON.toJSONString(result));
    }
}
