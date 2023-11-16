package io.github.medeirosavio.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.medeirosavio.model.Status;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HospitalDTO {
    @NotNull
    private String cnpj;
    @NotBlank
    private String nome;
    @NotBlank
    private String telefone;
    @NotBlank
    private String email;
    @NotBlank
    private String site;
    @NotNull
    @Past
    private LocalDate dataFundacao;
    private String descricao;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;
    @NotNull
    @Positive
    private Integer leitosEnfermariaTotal;
    @NotNull
    @Min(value = 0)
    private Integer leitosEnfermariaDisponiveis;
    @NotNull
    @Positive
    private Integer leitosUtiTotal;
    @NotNull
    @Min(value = 0)
    private Integer leitosUtiDisponiveis;

    private EnderecoDTO endereco;

    public HospitalDTO(){

    }

    public HospitalDTO(String cnpj, String nome, String telefone, String email,
                       String site, LocalDate dataFundacao, String descricao,
                       Status status, EnderecoDTO endereco, Integer leitosEnfermariaTotal
            ,          Integer leitosEnfermariaDisponiveis, Integer leitosUtiTotal,
                       Integer leitosUtiDisponiveis){
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.site = site;
        this.dataFundacao = dataFundacao;
        this.descricao = descricao;
        this.status = status;
        this.endereco = endereco;
        this.leitosEnfermariaTotal = leitosEnfermariaTotal;
        this.leitosEnfermariaDisponiveis = leitosEnfermariaDisponiveis;
        this.leitosUtiTotal = leitosUtiTotal;
        this.leitosUtiDisponiveis = leitosUtiDisponiveis;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Integer getLeitosEnfermariaTotal() {
        return leitosEnfermariaTotal;
    }

    public void setLeitosEnfermariaTotal(Integer leitosEnfermariaTotal) {
        this.leitosEnfermariaTotal = leitosEnfermariaTotal;
    }

    public Integer getLeitosEnfermariaDisponiveis() {
        return leitosEnfermariaDisponiveis;
    }

    public void setLeitosEnfermariaDisponiveis(Integer leitosEnfermariaDisponiveis) {
        this.leitosEnfermariaDisponiveis = leitosEnfermariaDisponiveis;
    }

    public Integer getLeitosUtiTotal() {
        return leitosUtiTotal;
    }

    public void setLeitosUtiTotal(Integer leitosUtiTotal) {
        this.leitosUtiTotal = leitosUtiTotal;
    }

    public Integer getLeitosUtiDisponiveis() {
        return leitosUtiDisponiveis;
    }

    public void setLeitosUtiDisponiveis(Integer leitosUtiDisponiveis) {
        this.leitosUtiDisponiveis = leitosUtiDisponiveis;
    }
}
