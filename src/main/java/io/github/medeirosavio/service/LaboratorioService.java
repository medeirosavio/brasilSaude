package io.github.medeirosavio.service;

import io.github.medeirosavio.dto.LaboratorioDTO;
import io.github.medeirosavio.exception.DataIntegrityViolationException;
import io.github.medeirosavio.model.Laboratorio;
import io.github.medeirosavio.repository.LaboratorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaboratorioService {

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    public void cadastrarLaboratorio(LaboratorioDTO laboratorioDTO) {
        try {
            Laboratorio laboratorio = converterDTOparaEntidade(laboratorioDTO);
            laboratorioRepository.save(laboratorio);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Erro de integridade de dados ao cadastrar o laboratório", e);
        } catch (Exception e) {
            throw new RuntimeException("Erro interno ao processar a solicitação", e);
        }
    }

    private Laboratorio converterDTOparaEntidade(LaboratorioDTO laboratorioDTO) {
        Laboratorio laboratorio = new Laboratorio();
        laboratorio.setCnpj(laboratorioDTO.getCnpj());
        laboratorio.setNome(laboratorioDTO.getNome());
        laboratorio.setTelefone(laboratorioDTO.getTelefone());
        laboratorio.setEmail(laboratorioDTO.getEmail());
        laboratorio.setSite(laboratorioDTO.getSite());
        laboratorio.setDataFundacao(laboratorioDTO.getDataFundacao());
        laboratorio.setDescricao(laboratorioDTO.getDescricao());
        laboratorio.setStatus(laboratorioDTO.getStatus());
        return laboratorio;
    }

}
