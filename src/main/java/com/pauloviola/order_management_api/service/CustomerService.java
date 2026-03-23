package com.pauloviola.order_management_api.service;

import com.pauloviola.order_management_api.dto.request.CustomerRequest;
import com.pauloviola.order_management_api.dto.response.CustomerResponse;
import com.pauloviola.order_management_api.entity.Customer;
import com.pauloviola.order_management_api.exceptions.ResourceNotFoundException;
import com.pauloviola.order_management_api.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerResponse create(CustomerRequest request) {

        if (repository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }

        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());

        Customer saved = repository.save(customer);

        return toResponse(saved);
    }

    public List<CustomerResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public Customer findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
    }

    public CustomerResponse findResponseById(Long id) {
        return toResponse(findById(id));
    }

    public CustomerResponse update(Long id, CustomerRequest request) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        customer.setName(request.getName());
        customer.setEmail(request.getEmail());

        Customer updated = repository.save(customer);

        return toResponse(updated);
    }

    public void delete(Long id) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        repository.delete(customer);
    }

    private CustomerResponse toResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getName(),
                customer.getEmail()
        );
    }
}