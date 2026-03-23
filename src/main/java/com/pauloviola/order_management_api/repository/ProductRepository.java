package com.pauloviola.order_management_api.repository;

import com.pauloviola.order_management_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<ProductRepository> findByName (String name);

    boolean existsByName(String name);
}
