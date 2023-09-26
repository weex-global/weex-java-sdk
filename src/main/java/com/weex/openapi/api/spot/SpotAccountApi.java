package com.weex.openapi.api.spot;

import com.weex.openapi.dto.request.spot.SpotBillQueryReq;
import com.weex.openapi.dto.response.swap.ResponseResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @Author: weex-sdk-team
 * @Date: 2021-05-31 11:03
 * @DES:
 */
public interface SpotAccountApi {

    /**
     * 获取币币资产
     *
     * @return
     */
    @GET("/api/spot/v1/account/assets")
    Call<ResponseResult> assets();


    @POST("/api/spot/v1/account/bills")
    Call<ResponseResult> bills(@Body SpotBillQueryReq spotBillQueryReq);

    @GET("/api/spot/v1/account/transferRecords")
    Call<ResponseResult> transferRecords(@Query("coinId") String coinId,
                                         @Query("fromType") String fromType,
                                         @Query("limit") String limit,
                                         @Query("after") String after,
                                         @Query("before") String before);
}
