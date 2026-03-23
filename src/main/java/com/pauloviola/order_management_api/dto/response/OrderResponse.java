package com.pauloviola.order_management_api.dto.response;

import com.pauloviola.order_management_api.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private Long id;
    private Long customerId;
    private Double total;

    public OrderResponse(Long id, Long id1, OrderStatus status, double total) {
    }
}