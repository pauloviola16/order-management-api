package com.pauloviola.order_management_api.repository;

import com.pauloviola.order_management_api.entity.Customer;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail (String email);

    boolean existsByEmail(@NotBlank String email);
}
