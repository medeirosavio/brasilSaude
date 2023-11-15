package io.github.medeirosavio.service;

import io.github.medeirosavio.dto.UPADTO;
import io.github.medeirosavio.exception.DataIntegrityViolationException;
import io.github.medeirosavio.model.UPA;
import io.github.medeirosavio.repository.UPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UPAService {

    @Autowired
    private UPARepository upaRepository;

    public void cadastrarUPA(UPADTO upadto) {
        try {
            UPA upa = converterDTOparaEntidade(upadto);
            upaRepository.save(upa);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Erro de integridade de dados ao cadastrar a UPA", e);
        } catch (Exception e) {
            throw new RuntimeException("Erro interno ao processar a solicitação", e);
        }
    }

    private UPA converterDTOparaEntidade(UPADTO upadto) {
        UPA upa = new UPA();
        upa.setCnpj(upadto.getCnpj());
        upa.setNome(upadto.getNome());
        upa.setTelefone(upadto.getTelefone());
        upa.setEmail(upadto.getEmail());
        upa.setSite(upadto.getSite());
        upa.setDataFundacao(upadto.getDataFundacao());
        upa.setDescricao(upadto.getDescricao());
        upa.setStatus(upadto.getStatus());
        return upa;
    }
}
