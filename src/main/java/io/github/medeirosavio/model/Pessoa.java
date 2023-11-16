package io.github.medeirosavio.model;

import java.time.LocalDate;
public abstract class Pessoa {
    protected String cpf;
    protected String nome;
    protected LocalDate dataNascimento;
    protected String email;
    protected String telefone;
    protected String sexo;

    public Pessoa() {

    }
    public Pessoa(String cpf, String nome, LocalDate dataNascimento,
                  String email, String telefone,String sexo){
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }
}
