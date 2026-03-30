package com.pauloviola.order_management_api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Schema(description = "Dados necessários para a criação ou atualização do produto")
@Data
public class ProductRequest {

    @Schema(description = "Nome do produto" , example = "Notebook")
    @NotBlank
    private String name;

    @Schema(description = "Preço do produto" , example = "999.00")
    @NotNull
    @Positive
    private Double price;

}
