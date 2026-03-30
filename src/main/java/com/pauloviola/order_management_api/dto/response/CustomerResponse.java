package com.pauloviola.order_management_api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Dados retornados de um usuário")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    @Schema(description = "ID único do usuário", example = "1")
    private Long id;

    @Schema(description = "Nome completo do usuário", example = "Paulo César Viola")
    private String name;

    @Schema(description = "E-mail do usuário", example = "paulo@email.com")
    private String email;



}
