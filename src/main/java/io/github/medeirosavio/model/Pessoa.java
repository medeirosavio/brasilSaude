package io.github.medeirosavio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
