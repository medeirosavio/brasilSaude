package io.github.medeirosavio.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
public abstract class Pessoa {
    protected String cpf;
    protected String nome;
    protected LocalDate dataNascimento;
    protected String email;
    protected String telefone;
    @Enumerated(EnumType.STRING)
    protected Sexo sexo;

    public Pessoa() {

    }
    public Pessoa(String cpf, String nome, LocalDate dataNascimento,
                  String email, String telefone){
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
