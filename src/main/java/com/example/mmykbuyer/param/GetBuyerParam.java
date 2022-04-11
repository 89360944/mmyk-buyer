package com.example.mmykbuyer.param;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetBuyerParam {

    @NotNull
    private Long id;

}
