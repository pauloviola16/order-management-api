package com.pauloviola.order_management_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductRequest {

    @NotBlank
    private String name;

    @NotNull
    @Positive
    private Double price;

}
