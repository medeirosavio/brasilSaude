package io.github.medeirosavio.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected Long cpf;
    protected String nome;
    protected LocalDate dataNascimento;

    protected Pessoa(){

    }

    public Pessoa(Long cpf, String nome, LocalDate dataNascimento){
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

}
