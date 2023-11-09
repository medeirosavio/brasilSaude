package io.github.medeirosavio.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FuncionarioDTO {

    @javax.validation.constraints.NotNull
    private Long cpf;
    @NotBlank
    private String nome;
    @NotNull
    @Past
    private LocalDate dataNascimento;
    @NotBlank
    private String email;
    @NotBlank
    private String telefone;
    @NotBlank
    private String sexo;
    @NotBlank
    private String cargo;
    @NotBlank
    private String departamento;
    @NotBlank
    private String status;
    @javax.validation.constraints.NotNull
    private LocalDate dataAdmissao;
    @NotNull
    private LocalTime horario;
    @NotNull
    @DecimalMin(value = "1320.0",inclusive = false,message = "Valor do salário mínimo R$1320,00")
    private BigDecimal salario;

    public FuncionarioDTO(){

    }

    public FuncionarioDTO(Long cpf, String nome, LocalDate dataNascimento,
                          String email, String telefone,String sexo,
                          String cargo, String departamento,
                          String status, LocalDate dataAdmissao,
                          LocalTime horario, BigDecimal salario){
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
        this.cargo = cargo;
        this.departamento = departamento;
        this.status = status;
        this.dataAdmissao = dataAdmissao;
        this.horario = horario;
        this.salario = salario;
    }

    public Long getCpf() {
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
