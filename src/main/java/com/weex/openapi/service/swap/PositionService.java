package com.weex.openapi.service.swap;


import com.alibaba.fastjson.JSONObject;
import com.weex.openapi.dto.request.swap.ChangeHoldModel;
import com.weex.openapi.dto.response.swap.AllPosition;
import com.weex.openapi.dto.response.swap.HoldModelDto;
import com.weex.openapi.dto.response.swap.Position;

import java.io.IOException;
import java.util.List;

/**
 * 持仓服务
 * @author weex-sdk-team
 * @date 2019-01-15
 */
public interface PositionService {
    /**
     *获取全部合约仓位信息
     * @return
     * @throws IOException
     */
    List<AllPosition> getAllPosition() throws IOException;

    /**
     * 获取全部合约仓位信息
     * @param symbol
     * @return
     * @throws IOException
     */
    AllPosition getSinglePosition(String symbol) throws IOException;

    /**
     * 出入金数据记录
     * @return
     * @throws IOException
     */
    JSONObject  virtualCapital(String  symbol,
                                                  String ftype,
                                                  Integer limit,
                                                  Integer gt,
                                                  Integer lt)throws  IOException;

    /**
     * 修改用户的平仓模式(全仓，逐仓）
     * @param holdModel
     * @return
     */
    HoldModelDto changeHoldMode(ChangeHoldModel holdModel)throws  IOException;
}
