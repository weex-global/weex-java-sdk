package com.weex.openapi.service.swap.impl;


import com.alibaba.fastjson.JSON;
import com.weex.openapi.api.swap.OrderApi;
import com.weex.openapi.common.client.ApiClient;
import com.weex.openapi.dto.request.swap.*;
import com.weex.openapi.dto.response.swap.CancelPlanResult;
import com.weex.openapi.dto.response.swap.Fill;
import com.weex.openapi.dto.response.swap.PlanPlaceOrderResult;
import com.weex.openapi.dto.response.swap.PlansOrderResult;
import com.weex.openapi.dto.response.swap.*;
import com.weex.openapi.service.swap.OrderService;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author weex-sdk-team
 * @date 2019-01-15
 */
public class OrderServiceImpl implements OrderService {

    private final OrderApi orderApi;

    public OrderServiceImpl(ApiClient client) {
        orderApi = client.create(OrderApi.class);
    }

    @Override
    public PlaceOrderResult placeOrder(OrderReq orderRequest) throws IOException {
        return JSON.parseObject(Objects.requireNonNull(orderApi.placeOrder(orderRequest).execute().body()).toString(),PlaceOrderResult.class);
    }

    @Override
    public OrderInfoResult batchOrders(PlaceBatchOrderReq placeBatchOrderReq) throws IOException {
        return JSON.parseObject(Objects.requireNonNull(orderApi.batchOrders(placeBatchOrderReq).execute().body()).toString(),OrderInfoResult.class);
    }

    @Override
    public CancelOrderResult cancelOrder(CancelOrderParam cancelOrderParam) throws IOException {
        return JSON.parseObject(Objects.requireNonNull(orderApi.cancelOrder(cancelOrderParam).execute().body()).toString(),CancelOrderResult.class);
    }

    @Override
    public CancelBatchOrderResult cancelBathOrders(CancelBatchOrdersReq param) throws IOException {
        return JSON.parseObject(Objects.requireNonNull(orderApi.cancelBathOrders(param).execute().body()).toString(),CancelBatchOrderResult.class);
    }

    @Override
    public Order getOrderDetail(String symbol, String orderId) throws IOException {
        return JSON.parseObject(Objects.requireNonNull(orderApi.getOrderDetail(symbol, orderId).execute().body()).toString(),Order.class);
    }

    @Override
    public List<Order> getOrdersHistory(String symbol, String pageIndex, String pageSize, Integer createDate) throws IOException {
        return orderApi.getOrdersHistory(symbol,pageIndex,pageSize,createDate).execute().body();
    }

    @Override
    public List<Order> getOrdersCurrent(String symbol) throws IOException {
        return orderApi.getOrdersCurrent(symbol).execute().body();
    }

    @Override
    public List<Fill> getFills(String symbol, String orderId) throws IOException {
        return orderApi.getFills(symbol, orderId).execute().body();
    }

    @Override
    public PlanPlaceOrderResult planOrder(PlanPlaceOrderReq planPlaceOrderReq) throws IOException {
        return orderApi.planOrder(planPlaceOrderReq).execute().body();
    }

    @Override
    public CancelPlanResult cancelPlan(CancelPlanParamReq cancelPlanParamReq) throws IOException {
        return orderApi.cancelPlan(cancelPlanParamReq).execute().body();
    }

    @Override
    public PlansOrderResult  currentPlan(String symbol, PlanOrderReq planOrderReq) throws IOException {
        return orderApi.currentPlan(symbol, planOrderReq.getSide(),planOrderReq.getDelegateType(),planOrderReq.getPage_index(),planOrderReq.getPage_size(),planOrderReq.getStart_time(),planOrderReq.getEnd_time()).execute().body();
    }

    @Override
    public PlansOrderResult historyPlan(String symbol, PlanOrderReq planOrderReq) throws IOException {
        return orderApi.historyPlan(symbol, planOrderReq.getSide(),planOrderReq.getDelegateType(),planOrderReq.getPage_index(),planOrderReq.getPage_size(),planOrderReq.getStart_time(),planOrderReq.getEnd_time()).execute().body();
    }
}
