package com.weex.openapi.dto.request.other;

public interface OrderBookItem<T> {
    String getPrice();

    T getSize();
}
