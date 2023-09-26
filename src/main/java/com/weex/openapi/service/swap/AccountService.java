package com.weex.openapi.service.swap;


import com.alibaba.fastjson.JSONObject;
import com.weex.openapi.dto.request.swap.AdjustMarginReq;
import com.weex.openapi.dto.request.swap.AutoAppendMarginReq;
import com.weex.openapi.dto.request.swap.ChangeLeverageReq;
import com.weex.openapi.dto.response.swap.*;

import java.io.IOException;
import java.util.List;

/**
 * 持仓服务
 * @author weex-sdk-team
 * @date 2019-01-15
 */
public interface AccountService {
    /**
     * 查询所有合约账户信息
     * @return
     * @throws IOException
     */
    List<AccountInfo> accounts() throws IOException;

    /**
     * 单个合约账户信息
     * @param symbol
     * @return
     * @throws IOException
     */
    AccountInfo getAccount(String symbol) throws IOException;

    /**
     * 获取单个合约的用户配置
     * @param symbol
     * @return
     * @throws IOException
     */
    AccountSetting settings(String symbol) throws IOException;

    /**
     * 调整杠杆
     * @param changeLeverageReq
     * @return
     * @throws IOException
     */
    AccountSetting leverage( ChangeLeverageReq changeLeverageReq) throws IOException;

    /**
     * 列出主账户资产流水
     * @param symbol
     * @return
     * @throws IOException
     */
    JSONObject getLedger(String symbol,String from,
                                 String to,String limit, String startTime,
                                 String endTime) throws IOException;

    /**
     * 列出保证金账户资产流水
     * @param symbol
     * @return
     * @throws IOException
     */
    JSONObject ledgerMargin(String symbol, String from,
                                    String to,String limit, String startTime,
                                    String endTime) throws IOException;

    /**
     * 调整保证金
     * @param adjustMarginReq
     * @return
     * @throws IOException
     */
    AdjustMarginResult adjustMargin(AdjustMarginReq adjustMarginReq) throws IOException;
    /**
     * 自动追加保证金
     * @param autoAppendMarginReq
     * @return
     * @throws IOException
     */
    AutoAppendMarginResult modifyAutoAppendMargin(AutoAppendMarginReq autoAppendMarginReq) throws IOException;
}
