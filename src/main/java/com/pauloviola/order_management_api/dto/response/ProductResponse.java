package com.pauloviola.order_management_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {

    private Long id;
    private String name;
    private Double price;

}