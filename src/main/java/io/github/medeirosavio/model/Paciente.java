package io.github.medeirosavio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Paciente extends Pessoa{
    @Column
    private LocalDate dataInternacao;
    @Column
    private LocalDate dataInicioSintomas;
    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;
    @ManyToOne
    @JoinColumn(name = "id_upa")
    private UPA upa;
    @ManyToOne
    @JoinColumn(name = "id_hospital")
    private Hospital hospital;
    @ManyToOne
    @JoinColumn(name = "id_laboratorio")
    private Laboratorio laboratorio;

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

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }
}
