package io.github.medeirosavio.model;
import javax.persistence.*;

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

}
