package io.github.medeirosavio.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.medeirosavio.model.Sexo;
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
public class PacienteDTO {

    @javax.validation.constraints.NotNull
    private String cpf;
    @NotBlank
    private String nome;
    @javax.validation.constraints.NotNull
    @Past
    private LocalDate dataNascimento;
    @NotBlank
    private String email;
    @NotBlank
    private String telefone;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    private LocalDate dataInternacao;
    @NotNull
    @Past
    private LocalDate dataInicioSintomas;
    private EnderecoDTO endereco;

}
