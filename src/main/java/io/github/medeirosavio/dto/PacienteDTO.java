package io.github.medeirosavio.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.medeirosavio.model.Sexo;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
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

    public PacienteDTO(){

    }

    public PacienteDTO(String cpf, String nome, LocalDate dataNascimento,
                       String email, String telefone,
                       LocalDate dataInicioSintomas, LocalDate dataInternacao,
                       EnderecoDTO endereco){
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.dataInicioSintomas = dataInicioSintomas;
        this.dataInternacao = dataInternacao;
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataInternacao() {
        return dataInternacao;
    }

    public void setDataInternacao(LocalDate dataInternacao) {
        this.dataInternacao = dataInternacao;
    }

    public LocalDate getDataInicioSintomas() {
        return dataInicioSintomas;
    }

    public void setDataInicioSintomas(LocalDate dataInicioSintomas) {
        this.dataInicioSintomas = dataInicioSintomas;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}
