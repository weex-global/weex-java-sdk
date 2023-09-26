package com.weex.openapi.service.spot;

import com.weex.openapi.dto.request.spot.SpotBillQueryReq;
import com.weex.openapi.dto.response.swap.ResponseResult;

import java.io.IOException;

/**
 * @Author: weex
 * @Date: 2021-05-31 11:12
 * @DES:
 */
public interface SpotAccountService {

    /**
     * 查询币币资产
     *
     * @return
     * @throws IOException
     */
    ResponseResult assets() throws IOException;

    ResponseResult bills(SpotBillQueryReq spotBillQueryReq) throws IOException;

    ResponseResult transferRecords(String coinId,String fromType,String limit,String after,String before) throws IOException;
}
