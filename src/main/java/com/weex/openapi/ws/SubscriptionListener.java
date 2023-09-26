package com.weex.openapi.ws;

@FunctionalInterface
public interface SubscriptionListener {
    void onReceive(String data);
}
