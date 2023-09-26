package com.weex.openapi.service.swap;

import com.alibaba.fastjson.JSONObject;
import com.weex.openapi.dto.request.swap.CloseTrackOrderReq;

import java.io.IOException;


public interface TraceService {

    /**
     * 下单平仓单
     * @param orderReq
     * @return
     * @throws IOException
     */
    JSONObject closeTrackOrder(CloseTrackOrderReq orderReq) throws IOException;

    /**
     *获取交易员当前带单list
     * @param symbol
     * @param pageIndex
     * @param pageSize
     * @return
     */
    JSONObject currentTrack(String symbol, String pageIndex, String pageSize)throws IOException;

    /**
     * 获取历史带单列表
     * @param pageIndex
     * @param pageSize
     * @param createDate
     * @return
     */
    JSONObject historyTrack(String pageIndex, String pageSize, Integer createDate)throws IOException;

}
