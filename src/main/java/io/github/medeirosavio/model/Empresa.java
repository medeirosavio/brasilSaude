package io.github.medeirosavio.model;

import java.time.LocalDate;

public abstract class Empresa {

    protected Long cnpj;
    protected String nome;
    protected String telefone;
    protected String email;
    protected String site;
    protected LocalDate dataFundacao;
    protected String descricao;
    protected String status;

    public Empresa(){

    }

    public Empresa(Long cnpj, String nome, String telefone, String email,
                   String site, LocalDate dataFundacao, String descricao,
                   String status){
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.site = site;
        this.dataFundacao = dataFundacao;
        this.descricao = descricao;
        this.status = status;

    }


}
