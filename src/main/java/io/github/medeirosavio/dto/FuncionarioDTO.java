package io.github.medeirosavio.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.medeirosavio.model.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FuncionarioDTO {

    @javax.validation.constraints.NotNull
    private String cpf;
    @NotBlank
    private String nome;
    @NotNull
    @Past
    private LocalDate dataNascimento;
    @NotBlank
    private String email;
    @NotBlank
    private String telefone;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @NotBlank
    private String cargo;
    @NotBlank
    private String departamento;
    @NotBlank
    private String status;
    @javax.validation.constraints.NotNull
    private LocalDate dataAdmissao;
    @NotNull
    @DecimalMin(value = "1320.0",inclusive = false,message = "Valor do salário mínimo R$1320,00")
    private BigDecimal salario;

    private EnderecoDTO endereco;

}
