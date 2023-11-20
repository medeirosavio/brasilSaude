package io.github.medeirosavio.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long endereco_id;
    @Column
    private String rua;
    @Column
    private String numero;
    @Column
    private String complemento;
    @Column
    private String bairro;
    @Column
    private String cidade;
    @Column
    private String estado;
    @Column
    private Long cep;
    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @OneToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
    @OneToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
    @OneToOne
    @JoinColumn(name = "laboratorio_id")
    private Laboratorio laboratorio;
    @OneToOne
    @JoinColumn(name = "upa_id")
    private UPA upa;

}
