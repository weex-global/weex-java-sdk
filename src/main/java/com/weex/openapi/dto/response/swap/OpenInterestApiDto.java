package com.weex.openapi.dto.response.swap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenInterestApiDto implements Serializable {
    private static final long serialVersionUID = -6623486997270396100L;
    /**
     * 合约名称，如BTC-USD-SWAP
     */
    private String symbol;
    /**
     * 总持仓量
     */
    private String amount;

    /**
     * 总持仓量 左币
     */
    private String base_volume;

    /**
     * 总持仓量 右币
     */
    private String target_volume;
    /**
     * 系统时间戳
     */
    private String timestamp;
    /**
     * 是否是正向合约
     */
    private Boolean forwardContractFlag = false;

}
