package io.github.medeirosavio.model;

import java.time.LocalDate;
public abstract class Pessoa {
    protected Long cpf;
    protected String nome;
    protected LocalDate dataNascimento;
    protected String email;
    protected String telefone;
    protected String sexo;

    public Pessoa() {

    }
    public Pessoa(Long cpf, String nome, LocalDate dataNascimento,
                  String email, String telefone,String sexo){
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
    }


}
