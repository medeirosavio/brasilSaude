package io.github.medeirosavio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Funcionario extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricula;
    private String cargo;
    private String departamento;
    private String status;
    private LocalDate dataAdmissao;
    private LocalTime horario;
    private BigDecimal salario;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    @JsonIgnore
    private Endereco endereco;

    public Funcionario(){super();}

    public Funcionario(Long cpf, String nome, LocalDate dataNascimento,String email,
                       String telefone ,String sexo, String cargo,
                       String departamento, String status, LocalDate dataAdmissao,
                       LocalTime horario, BigDecimal salario){
        super(cpf,nome,dataNascimento,email,telefone,sexo);
        this.cargo = cargo;
        this.departamento = departamento;
        this.status = status;
        this.dataAdmissao = dataAdmissao;
        this.horario = horario;
        this.salario = salario;

    }

    public Funcionario(Long cpf, String nome, LocalDate dataNascimento, String email, String telefone, String sexo) {
        super(cpf, nome, dataNascimento, email, telefone, sexo);
    }

    @Override
    public void setCpf(Long cpf) {
        super.setCpf(cpf);
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public void setDataNascimento(LocalDate dataNascimento) {
        super.setDataNascimento(dataNascimento);
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public void setTelefone(String telefone) {
        super.setTelefone(telefone);
    }

    @Override
    public void setSexo(String sexo) {
        super.setSexo(sexo);
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
