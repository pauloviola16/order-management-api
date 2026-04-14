package com.pauloviola.order_management_api.controller;

import com.pauloviola.order_management_api.dto.request.OrderRequest;
import com.pauloviola.order_management_api.dto.response.OrderResponse;
import com.pauloviola.order_management_api.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Tag(name = "Orders", description = "Endpoints para gerenciamento de pedidos")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @Operation(summary = "Criar um novo pedido", description = "Cria um novo pedido no sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Pedido criado com sucesso",
                    content = @Content(schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content)
    })
    @PostMapping
    public ResponseEntity<OrderResponse> create(
          @RequestBody @Valid OrderRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(request));
    }

    @Operation(summary = "Listar todos os pedidos", description = "Retorna a lista com todos os pedidos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Buscar pedido por ID", description = "Retorna um pedido de acordo com seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pedido encontrado",
                    content = @Content(schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> findById(
            @Parameter(description = "ID do pedido", example = "1", required = true)
            @PathVariable Long id) {

        return ResponseEntity.ok(service.findResponseById(id));
    }

    @Operation(summary = "Deletar pedido", description = "Remove um pedido do sistema pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Pedido deletado com sucesso", content = @Content),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID do pedido", example = "1", required = true)
            @PathVariable Long id) {

        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Pagar pedido", description = "Realiza o pagamento de um pedido")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pedido pago com sucesso",
                    content = @Content(schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado", content = @Content)
    })
    @PatchMapping("/{id}/pay")
    public ResponseEntity<OrderResponse> payOrder(
            @Parameter(description = "ID do pedido", example = "1", required = true)
            @PathVariable Long id) {

        return ResponseEntity.ok(service.payOrder(id));
    }

    @Operation(summary = "Cancelar pedido", description = "Cancela um pedido existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pedido cancelado com sucesso",
                    content = @Content(schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado", content = @Content)
    })
    @PatchMapping("/{id}/cancel")
    public ResponseEntity<OrderResponse> cancelOrder(
            @Parameter(description = "ID do pedido", example = "1", required = true)
            @PathVariable Long id) {

        return ResponseEntity.ok(service.cancelOrder(id));
    }
}
