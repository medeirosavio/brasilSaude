package io.github.medeirosavio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Paciente extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataInternacao;
    private LocalDate dataInicioSintomas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    @JsonIgnore
    private Endereco endereco;

    public Paciente() {
        super();
    }

    public Paciente(String cpf, String nome, LocalDate dataNascimento,String email,
                    String telefone ,String sexo, LocalDate dataInicioSintomas,
                    LocalDate dataInternacao ){
        super(cpf,nome,dataNascimento,email,telefone,sexo);
        this.dataInicioSintomas = dataInicioSintomas;
        this.dataInternacao = dataInternacao;
    }

    public Paciente(String cpf, String nome, LocalDate dataNascimento, String email, String telefone, String sexo) {
        super(cpf, nome, dataNascimento, email, telefone, sexo);
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

    @Override
    public void setSexo(String sexo) {
        super.setSexo(sexo);
    }

    public void setDataInternacao(LocalDate dataInternacao) {
        this.dataInternacao = dataInternacao;
    }

    public void setDataInicioSintomas(LocalDate dataInicioSintomas) {
        this.dataInicioSintomas = dataInicioSintomas;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataInternacao() {
        return dataInternacao;
    }

    public LocalDate getDataInicioSintomas() {
        return dataInicioSintomas;
    }
}
