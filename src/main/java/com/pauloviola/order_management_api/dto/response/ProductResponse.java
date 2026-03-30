package com.pauloviola.order_management_api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(description = "Dados retornados de um produto")
@Data
@AllArgsConstructor
public class ProductResponse {

    @Schema(description = "ID único do produto", example = "1")
    private Long id;

    @Schema(description = "Nome do produto", example = "Notebook")
    private String name;

    @Schema(description = "Valor do produto" , example = "999.00")
    private Double price;

}