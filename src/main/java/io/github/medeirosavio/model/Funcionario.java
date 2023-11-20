package io.github.medeirosavio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Funcionario extends Pessoa {
    @Column
    private String cargo;
    @Column
    private String departamento;
    @Column
    private String status;
    @Column
    private LocalDate dataAdmissao;
    @Column
    private BigDecimal salario;

    @OneToOne(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;
}
