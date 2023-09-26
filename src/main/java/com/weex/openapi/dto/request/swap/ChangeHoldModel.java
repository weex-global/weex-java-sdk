package com.weex.openapi.dto.request.swap;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChangeHoldModel {

    private  Integer holdModel;
    private  String  symbol;
}
