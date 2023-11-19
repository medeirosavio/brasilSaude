package io.github.medeirosavio.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {

    @Id
    private Long id;
    @Column
    protected String cpf;
    @Column
    protected String nome;
    @Column
    protected LocalDate dataNascimento;
    @Column
    protected String email;
    @Column
    protected String telefone;
    @Enumerated(EnumType.STRING)
    @Column
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
