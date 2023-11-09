package io.github.medeirosavio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class UPA extends Empresa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    @JsonIgnore
    private Endereco endereco;

    public UPA(){super();}

    public UPA(Long cnpj, String nome, String telefone, String email,
                       String site, LocalDate dataFundacao, String descricao,
                       String status){
        super(cnpj,nome,telefone,email,site,dataFundacao,descricao,status);
    }

}
