package com.pauloviola.order_management_api.service;

import com.pauloviola.order_management_api.dto.request.OrderItemRequest;
import com.pauloviola.order_management_api.dto.request.OrderRequest;
import com.pauloviola.order_management_api.dto.response.OrderResponse;
import com.pauloviola.order_management_api.entity.*;
import com.pauloviola.order_management_api.exceptions.ResourceNotFoundException;
import com.pauloviola.order_management_api.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final CustomerService customerService;
    private final ProductService productService;

    public OrderService(OrderRepository repository,
                        CustomerService customerService,
                        ProductService productService) {
        this.repository = repository;
        this.customerService = customerService;
        this.productService = productService;
    }

    // CREATE
    public OrderResponse create(OrderRequest request) {

        Customer customer = customerService.findById(request.getCustomerId());

        Order order = new Order();
        order.setCustomer(customer);
        order.setStatus(OrderStatus.CREATED);

        List<OrderItem> items = new ArrayList<>();
        double total = 0;

        for (OrderItemRequest itemRequest : request.getItems()) {

            Product product = productService.findById(itemRequest.getProductId());

            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(itemRequest.getQuantity());
            item.setPrice(product.getPrice());
            item.setOrder(order);

            double subtotal = product.getPrice() * itemRequest.getQuantity();
            total += subtotal;

            items.add(item);
        }

        order.setItems(items);
        order.setTotal(total);

        Order saved = repository.save(order);

        return toResponse(saved);
    }

    // FIND ALL
    public List<OrderResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // ENTITY (uso interno)
    public Order findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));
    }

    // DTO (controller)
    public OrderResponse findResponseById(Long id) {
        return toResponse(findById(id));
    }

    // DELETE
    public void delete(Long id) {
        repository.delete(findById(id));
    }

    // PAY ORDER
    public OrderResponse payOrder(Long id) {
        Order order = findById(id);

        if (order.getStatus() != OrderStatus.CREATED) {
            throw new RuntimeException("Order cannot be paid");
        }

        order.setStatus(OrderStatus.PAID);

        return toResponse(repository.save(order));
    }

    // CANCEL ORDER
    public OrderResponse cancelOrder(Long id) {
        Order order = findById(id);

        if (order.getStatus() == OrderStatus.SHIPPED) {
            throw new RuntimeException("Shipped order cannot be canceled");
        }

        order.setStatus(OrderStatus.CANCELED);

        return toResponse(repository.save(order));
    }

    // MAPPER
    private OrderResponse toResponse(Order order) {
        return new OrderResponse(
                        order.getId(),
                        order.getCustomer().getId(),
                order.getTotal(),
                order.getStatus()
                );
    }
}