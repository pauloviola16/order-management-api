package com.pauloviola.order_management_api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Schema(description = "Dados necessários para criação ou atualização de um usuário")
@Data
public class CustomerRequest {

    @Schema(description = "Nome completo do usuário", example = "Paulo César Viola")
    @NotBlank
    private String name;

    @Schema(description = "Email do usuário", example = "paulo123@gmail.com")
    @NotBlank
    private String email;

    @Schema(description = "Senha do usuário", example = "senha123", minLength = 6)
    @NotBlank
    private String password;
}
