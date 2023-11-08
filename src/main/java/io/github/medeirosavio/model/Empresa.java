package io.github.medeirosavio.model;

import java.time.LocalDate;

public abstract class Empresa {

    private Long cnpj;
    private String nome;
    private String telefone;
    private String email;
    private String site;
    private LocalDate dataFundacao;
    private String descricao;
    private String status;

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
