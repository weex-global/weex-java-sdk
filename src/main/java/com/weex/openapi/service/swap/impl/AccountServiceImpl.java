package com.weex.openapi.service.swap.impl;


import com.alibaba.fastjson.JSONObject;
import com.weex.openapi.api.swap.AccountApi;
import com.weex.openapi.common.client.ApiClient;
import com.weex.openapi.dto.request.swap.AdjustMarginReq;
import com.weex.openapi.dto.request.swap.AutoAppendMarginReq;
import com.weex.openapi.dto.request.swap.ChangeLeverageReq;
import com.weex.openapi.dto.response.swap.*;
import com.weex.openapi.service.swap.AccountService;

import java.io.IOException;
import java.util.List;

/**
 * @author weex-sdk-team
 * @date 2019-01-15
 */
public class AccountServiceImpl implements AccountService {

    private final AccountApi accountApi;

    public AccountServiceImpl(ApiClient client) {
        accountApi = client.create(AccountApi.class);
    }

    @Override
    public List<AccountInfo> accounts() throws IOException {
        return accountApi.accounts().execute().body();
    }

    @Override
    public AccountInfo getAccount(String symbol) throws IOException {
        return accountApi.getAccount(symbol).execute().body();
    }

    @Override
    public AccountSetting settings(String symbol) throws IOException {
        return accountApi.settings(symbol).execute().body();
    }

    @Override
    public AccountSetting leverage( ChangeLeverageReq changeLeverageReq) throws IOException {
        return accountApi.leverage(changeLeverageReq).execute().body();
    }

    @Override
    public JSONObject getLedger(String symbol,String from,
                                        String to,String limit, String startTime,
                                        String endTime) throws IOException {
        return accountApi.getLedger(symbol, from,to,limit,startTime,endTime).execute().body();
    }

    @Override
    public JSONObject ledgerMargin(String symbol, String from,
                                           String to,String limit, String startTime,
                                           String endTime) throws IOException {
        return accountApi.ledgerMargin(symbol,from,to,limit,startTime,endTime).execute().body();
    }

    @Override
    public AdjustMarginResult adjustMargin(AdjustMarginReq adjustMarginReq) throws IOException {
        return accountApi.adjustMargin(adjustMarginReq).execute().body();
    }

    @Override
    public AutoAppendMarginResult modifyAutoAppendMargin(AutoAppendMarginReq autoAppendMarginReq) throws IOException {
        return accountApi.modifyAutoAppendMargin(autoAppendMarginReq).execute().body();
    }
}
