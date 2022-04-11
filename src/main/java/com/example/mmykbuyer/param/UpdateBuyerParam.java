package com.example.mmykbuyer.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class UpdateBuyerParam {
    @NotNull(message = "id必填")
    private Long id;

    @NotBlank
    private String name;

    private String url;

    private String description;
}
