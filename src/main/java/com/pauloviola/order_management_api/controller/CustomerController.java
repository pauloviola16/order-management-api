package com.pauloviola.order_management_api.controller;

import com.pauloviola.order_management_api.dto.request.CustomerRequest;
import com.pauloviola.order_management_api.dto.response.CustomerResponse;
import com.pauloviola.order_management_api.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customers", description = "Endpoints para gerenciamento de clientes")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @Operation(summary = "Criar um novo cliente", description = "Cria um novo cliente no sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso",
                    content = @Content(schema = @Schema(implementation = CustomerResponse.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content)
    })
    @PostMapping
    public ResponseEntity<CustomerResponse> create(
            @RequestBody(description = "Dados do cliente", required = true,
                    content = @Content(schema = @Schema(implementation = CustomerRequest.class)))
            @Valid @org.springframework.web.bind.annotation.RequestBody CustomerRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(request));
    }

    @Operation(summary = "Listar todos os clientes", description = "Retorna a lista com todos os clientes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(schema = @Schema(implementation = CustomerResponse.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Buscar cliente por ID", description = "Retorna um cliente de acordo com seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente encontrado",
                    content = @Content(schema = @Schema(implementation = CustomerResponse.class))),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(
            @Parameter(description = "ID do cliente", example = "1", required = true)
            @PathVariable Long id) {

        return ResponseEntity.ok(service.findResponseById(id));
    }

    @Operation(summary = "Atualizar cliente", description = "Atualiza os dados de um cliente existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso",
                    content = @Content(schema = @Schema(implementation = CustomerResponse.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(
            @Parameter(description = "ID do cliente", example = "1", required = true)
            @PathVariable Long id,
            @RequestBody(description = "Dados atualizados do cliente", required = true,
                    content = @Content(schema = @Schema(implementation = CustomerRequest.class)))
            @Valid CustomerRequest request) {

        return ResponseEntity.ok(service.update(id, request));
    }

    @Operation(summary = "Deletar cliente", description = "Remove um cliente do sistema pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Cliente deletado com sucesso", content = @Content),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID do cliente", example = "1", required = true)
            @PathVariable Long id) {

        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
