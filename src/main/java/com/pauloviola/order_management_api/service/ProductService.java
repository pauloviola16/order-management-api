package com.pauloviola.order_management_api.service;

import com.pauloviola.order_management_api.dto.request.ProductRequest;
import com.pauloviola.order_management_api.dto.response.ProductResponse;
import com.pauloviola.order_management_api.entity.Product;
import com.pauloviola.order_management_api.exceptions.ResourceNotFoundException;
import com.pauloviola.order_management_api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductResponse create(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());

        return toResponse(repository.save(product));
    }

    public List<ProductResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
    }

    public ProductResponse findResponseById(Long id) {
        return toResponse(findById(id));
    }

    public ProductResponse update(Long id, ProductRequest request) {
        Product product = findById(id);

        product.setName(request.getName());
        product.setPrice(request.getPrice());

        return toResponse(repository.save(product));
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }

    private ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}