package io.github.medeirosavio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
