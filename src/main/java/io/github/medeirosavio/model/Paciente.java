package io.github.medeirosavio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToOne
    @JoinColumn(name = "id_upa")
    UPA upa;

    public Paciente() {
        super();
    }

    public Paciente(String cpf, String nome, LocalDate dataNascimento,String email,
                    String telefone , LocalDate dataInicioSintomas,
                    LocalDate dataInternacao ){
        super(cpf,nome,dataNascimento,email,telefone);
        this.dataInicioSintomas = dataInicioSintomas;
        this.dataInternacao = dataInternacao;
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

    public void setDataInternacao(LocalDate dataInternacao) {
        this.dataInternacao = dataInternacao;
    }

    public void setDataInicioSintomas(LocalDate dataInicioSintomas) {
        this.dataInicioSintomas = dataInicioSintomas;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setUpa(UPA upa) {
        this.upa = upa;
    }
}
