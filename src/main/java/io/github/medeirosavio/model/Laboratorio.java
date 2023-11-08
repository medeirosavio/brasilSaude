package io.github.medeirosavio.model;

import jakarta.persistence.*;

import javax.swing.border.LineBorder;
import java.time.LocalDate;

@Entity
public class Laboratorio extends Empresa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Laboratorio(){super();}

    public Laboratorio(Long cnpj, String nome, String telefone, String email,
                       String site, LocalDate dataFundacao, String descricao,
                       String status){
        super(cnpj,nome,telefone,email,site,dataFundacao,descricao,status);
    }


}
