package io.github.medeirosavio.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.medeirosavio.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaboratorioDTO {
    @NotNull
    private String cnpj;
    @NotBlank
    private String nome;
    @NotBlank
    private String telefone;
    @NotBlank
    private String email;
    @NotBlank
    private String site;
    @NotNull
    @Past
    private LocalDate dataFundacao;
    private String descricao;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;
    private EnderecoDTO endereco;

}
