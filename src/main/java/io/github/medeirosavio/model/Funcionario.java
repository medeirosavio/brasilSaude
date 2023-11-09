package io.github.medeirosavio.model;

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



}
