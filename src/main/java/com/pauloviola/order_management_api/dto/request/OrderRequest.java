package com.pauloviola.order_management_api.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    private Long customerId;
    private List<OrderItemRequest> itens;
}
