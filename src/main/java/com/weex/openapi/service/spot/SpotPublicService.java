package com.weex.openapi.service.spot;

import com.weex.openapi.dto.response.swap.ResponseResult;

import java.io.IOException;

public interface SpotPublicService {

    ResponseResult time() throws IOException;

    ResponseResult currencies() throws IOException;

    ResponseResult products() throws IOException;

    ResponseResult product(String symbol) throws IOException;

}
