package io.github.medeirosavio.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

public abstract class Empresa {

    protected String cnpj;
    protected String nome;
    protected String telefone;
    protected String email;
    protected String site;
    protected LocalDate dataFundacao;
    protected String descricao;
    @Enumerated(EnumType.STRING)
    protected Status status;

    public Empresa(){

    }

    public Empresa(String cnpj, String nome, String telefone, String email,
                   String site, LocalDate dataFundacao, String descricao){
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.site = site;
        this.dataFundacao = dataFundacao;
        this.descricao = descricao;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
