package io.github.medeirosavio.model;

import javax.persistence.*;

@Entity
public class RegistroOcupacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_leito")
    private Leito leito;



}
