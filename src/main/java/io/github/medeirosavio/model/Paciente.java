package io.github.medeirosavio.model;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

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
    private Endereco endereco;

    public Paciente() {
        super();
    }

    public Paciente(Long cpf, String nome, LocalDate dataNascimento,String email,
                    String telefone ,String sexo, LocalDate dataInicioSintomas,
                    LocalDate dataInternacao ){
        super(cpf,nome,dataNascimento,email,telefone,sexo);
        this.dataInicioSintomas = dataInicioSintomas;
        this.dataInternacao = dataInternacao;
    }


}
