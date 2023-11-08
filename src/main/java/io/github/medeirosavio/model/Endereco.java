package io.github.medeirosavio.model;
import jakarta.persistence.*;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long endereco_id;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private Long cep;
    @OneToOne(mappedBy = "endereco")
    private Paciente paciente;
    @OneToOne(mappedBy = "endereco")
    private Funcionario funcionario;
    @OneToOne(mappedBy = "endereco")
    private Hospital hospital;
    @OneToOne(mappedBy = "endereco")
    private Laboratorio laboratorio;
    @OneToOne(mappedBy = "endereco")
    private UPA upa;

    public Endereco() {

    }
    public Endereco(String rua, String numero, String complemento, String bairro, String cidade, String estado, Long cep) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }


}
