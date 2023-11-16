package io.github.medeirosavio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
@Entity
public class Hospital extends Empresa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Positive
    private Integer leitosEnfermariaTotal;
    @Min(value = 0)
    private Integer leitosEnfermariaDisponiveis;
    @Positive
    private Integer leitosUtiTotal;
    @Min(value = 0)
    private Integer leitosUtiDisponiveis;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    @JsonIgnore
    private Endereco endereco;

    public Hospital(){super();}

    public Hospital(String cnpj, String nome, String telefone, String email,
               String site, LocalDate dataFundacao, String descricao,
                    Integer leitosEnfermariaTotal, Integer leitosEnfermariaDisponiveis,
                    Integer leitosUtiTotal, Integer leitosUtiDisponiveis){
        super(cnpj,nome,telefone,email,site,dataFundacao,descricao);
        this.leitosEnfermariaTotal = leitosEnfermariaTotal;
        this.leitosEnfermariaDisponiveis = leitosEnfermariaDisponiveis;
        this.leitosUtiTotal = leitosUtiTotal;
        this.leitosUtiDisponiveis = leitosUtiDisponiveis;
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

    public void setLeitosEnfermariaTotal(Integer leitosEnfermariaTotal) {
        this.leitosEnfermariaTotal = leitosEnfermariaTotal;
    }

    public void setLeitosEnfermariaDisponiveis(Integer leitosEnfermariaDisponiveis) {
        this.leitosEnfermariaDisponiveis = leitosEnfermariaDisponiveis;
    }

    public void setLeitosUtiTotal(Integer leitosUtiTotal) {
        this.leitosUtiTotal = leitosUtiTotal;
    }

    public void setLeitosUtiDisponiveis(Integer leitosUtiDisponiveis) {
        this.leitosUtiDisponiveis = leitosUtiDisponiveis;
    }
}
