package io.github.medeirosavio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Administrador extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String senha;

    public Administrador(){super();}

    public Administrador(Long cpf, String nome, LocalDate dataNascimento, String email,
                         String telefone , String sexo, String senha){
        super(cpf,nome,dataNascimento,email,telefone,sexo);
    }

}
