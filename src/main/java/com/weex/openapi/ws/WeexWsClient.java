package com.weex.openapi.ws;

import com.weex.openapi.dto.request.ws.SubscribeReq;
import com.weex.openapi.dto.request.ws.WsBaseReq;

import java.util.List;

public interface WeexWsClient {

    void sendMessage(WsBaseReq<?> req);

    void sendMessage(String message);

    void unsubscribe(List<SubscribeReq> str);

    void subscribe(List<SubscribeReq> list);

    void subscribe(List<SubscribeReq> list,SubscriptionListener listener);

    void login();
}
