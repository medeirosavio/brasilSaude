package io.github.medeirosavio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hospital extends Empresa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    @JsonIgnore
    private Endereco endereco;

    @OneToMany(mappedBy = "hospital")
    private List<RegistroOcupacao> registrosOcupacao = new ArrayList<>();

    public Hospital(){super();}

    public Hospital(String cnpj, String nome, String telefone, String email,
               String site, LocalDate dataFundacao, String descricao){
        super(cnpj,nome,telefone,email,site,dataFundacao,descricao);
    }

    @Override
    public void setCnpj(String cnpj) {
        super.setCnpj(cnpj);
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public void setTelefone(String telefone) {
        super.setTelefone(telefone);
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public void setSite(String site) {
        super.setSite(site);
    }

    @Override
    public void setDataFundacao(LocalDate dataFundacao) {
        super.setDataFundacao(dataFundacao);
    }

    @Override
    public void setDescricao(String descricao) {
        super.setDescricao(descricao);
    }

    @Override
    public void setStatus(Status status) {
        super.setStatus(status);
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
