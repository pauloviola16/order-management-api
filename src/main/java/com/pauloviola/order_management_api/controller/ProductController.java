package com.pauloviola.order_management_api.controller;

import com.pauloviola.order_management_api.dto.request.ProductRequest;
import com.pauloviola.order_management_api.dto.response.ProductResponse;
import com.pauloviola.order_management_api.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/products")
@Tag(name = "Products", description = "Endpoints para gerenciamento de produtos")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @Operation(summary = "Criar um novo produto", description = "Criar um novo produto")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Produto criado com sucesso",
                    content = @Content(schema = @Schema(implementation = ProductResponse.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content)

    })
    @PostMapping
    public ResponseEntity<ProductResponse> create (@Valid @RequestBody ProductRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @Operation(summary = "Listar todos os produtos", description = "Retorna a lista com todos os produtos criados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(schema = @Schema(implementation = ProductResponse.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Buscar produto por ID", description = "Retorna um produto de acordo com seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto encontrado",
                    content = @Content(schema = @Schema(implementation = ProductResponse.class))),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@Parameter(description = "ID do produto", required = true, example = "1") @PathVariable Long id){
        return ResponseEntity.ok(service.findResponseById(id));
    }

    @Operation(summary = "Atualizar um produto", description = "Atualiza os dados de um produto existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso",
                    content = @Content(schema = @Schema(implementation = ProductResponse.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@Parameter(description = "ID do produto", required = true, example = "1")@PathVariable Long id, @Valid @RequestBody ProductRequest request){
        return ResponseEntity.ok(service.update(id, request));
    }

    @Operation(summary = "Deletar um produto", description = "Remove um produto do sistema pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Produto deletado com sucesso", content = @Content),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do produto", required = true, example = "1")@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
