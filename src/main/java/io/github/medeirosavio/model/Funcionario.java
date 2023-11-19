package io.github.medeirosavio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Funcionario extends Pessoa {
    @Column
    private String cargo;
    @Column
    private String departamento;
    @Column
    private String status;
    @Column
    private LocalDate dataAdmissao;
    @Column
    private BigDecimal salario;

    @OneToOne(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;

    public Funcionario(){super();}

    public Funcionario(String cpf, String nome, LocalDate dataNascimento,String email,
                       String telefone ,String cargo,
                       String departamento, String status, LocalDate dataAdmissao,
                       BigDecimal salario){
        super(cpf,nome,dataNascimento,email,telefone);
        this.cargo = cargo;
        this.departamento = departamento;
        this.status = status;
        this.dataAdmissao = dataAdmissao;
        this.salario = salario;

    }

    @Override
    public void setCpf(String cpf) {
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

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void removerEndereco() {
        if (endereco != null) {
            endereco.setFuncionario(null);
        }
    }
}
