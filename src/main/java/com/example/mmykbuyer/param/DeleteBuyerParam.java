package com.example.mmykbuyer.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class DeleteBuyerParam {
    @Schema(title = "ids")
    @NotNull(message = "ids必填")
    @Size(min = 1, max = 100, message = "ids长度1-100")
    private List<Long> ids;
}
