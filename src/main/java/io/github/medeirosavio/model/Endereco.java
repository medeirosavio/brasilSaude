package io.github.medeirosavio.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
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

    public Endereco() {

    }
    public Endereco(String rua, String numero, String complemento
            , String bairro, String cidade, String estado, Long cep) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public void setEndereco_id(Long endereco_id) {
        this.endereco_id = endereco_id;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Long getEndereco_id() {
        return endereco_id;
    }
}
