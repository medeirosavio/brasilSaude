package io.github.medeirosavio.service;

import io.github.medeirosavio.dto.UPADTO;
import io.github.medeirosavio.model.UPA;
import io.github.medeirosavio.repository.UPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UPAService {

    @Autowired
    private UPARepository upaRepository;

    public UPA cadastrarUPA(UPADTO upadto){
        UPA upa = new UPA();
        upa.setCnpj(upadto.getCnpj());
        upa.setCnpj(upadto.getCnpj());
        upa.setNome(upadto.getNome());
        upa.setTelefone(upadto.getTelefone());
        upa.setEmail(upadto.getEmail());
        upa.setSite(upadto.getSite());
        upa.setDataFundacao(upadto.getDataFundacao());
        upa.setDescricao(upadto.getDescricao());
        upa.setStatus(upadto.getStatus());

        return upaRepository.save(upa);
    }
}
