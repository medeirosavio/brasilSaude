package io.github.medeirosavio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "empresas")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Empresa {

    @Id
    private Long Id;
    protected String cnpj;
    protected String nome;
    protected String telefone;
    protected String email;
    protected String site;
    protected LocalDate dataFundacao;
    protected String descricao;
    @Enumerated(EnumType.STRING)
    protected Status status;

}