package com.example.mmykbuyer.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateBuyerParam {

    @NotBlank
    private String name;

    private String url;

    private String description;

}
