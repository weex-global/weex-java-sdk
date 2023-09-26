package com.weex.openapi.api.swap;

import com.alibaba.fastjson.JSONObject;
import com.weex.openapi.dto.request.swap.ChangeHoldModel;
import com.weex.openapi.dto.response.swap.AllPosition;
import com.weex.openapi.dto.response.swap.HoldModelDto;
import com.weex.openapi.dto.response.swap.Position;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 *
 * @author weex-sdk-team
 * @date 2019-01-15
 */
public interface PositionApi {
    /**
     * 所有合约持仓信息
     *
     * @return
     */
    @GET("/api/swap/v3/position/allPosition")
    Call<List<AllPosition>> getAllPosition();

    /**
     * 单个合约持仓信息
     * @param symbol 合约code
     * @return
     */
    @GET("/api/swap/v3/position/singlePosition")
    Call<AllPosition> getSinglePosition(@Query("symbol") String symbol);
    /**
     * 出入金接口
     * @param symbol 
     * @param ftype
     * @param limit
     * @param gt
     * @param lt
     * @return
     */
    @GET("/api/swap/v3/position/virtualCapital")
    Call<JSONObject> virtualCapital( @Query("symbol") String  symbol,
                                                        @Query("ftype") String ftype,
                                                        @Query("limit") Integer limit,
                                                        @Query("gt") Integer gt,
                                                        @Query("lt") Integer lt);

    /**
     *修改用户的平仓模式(全仓，逐仓）
     * @param changeHoldModel
     * @return
     */
    @POST("/api/swap/v3/position/changeHoldModel")
    Call<HoldModelDto> changeHoldMode(@Body ChangeHoldModel changeHoldModel);
}
