package com.weex.openapi.api.swap;

import com.alibaba.fastjson.JSONObject;
import com.weex.openapi.dto.request.swap.CloseTrackOrderReq;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TraceApi {

    /**
     * 下单平仓单
     * @return
     */
    @POST("/api/swap/v3/trace/closeTrackOrder")
    Call<JSONObject> closeTrackOrder(@Body CloseTrackOrderReq orderReq);

    /**
     * 获取交易员当前带单list
     *
     * @return
     */
    @GET("/api/swap/v3/trace/currentTrack")
    Call<JSONObject> currentTrack(@Query("symbol") String symbol,
                                                      @Query("pageIndex") String pageIndex,
                                                      @Query("pageSize") String pageSize);

    /**
     * 获取历史带单列表
     *
     * @return
     */
    @GET("/api/swap/v3/trace/historyTrack")
    Call<JSONObject> historyTrack(@Query("pageIndex") String pageIndex,
                                                @Query("pageSize") String pageSize,
                                                @Query("createDate") Integer createDate);


}
