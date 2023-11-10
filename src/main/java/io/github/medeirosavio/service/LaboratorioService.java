package io.github.medeirosavio.service;

import io.github.medeirosavio.dto.LaboratorioDTO;
import io.github.medeirosavio.model.Laboratorio;
import io.github.medeirosavio.repository.LaboratorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaboratorioService {

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    public Laboratorio cadastrarLaboratorio(LaboratorioDTO laboratorioDTO){
        Laboratorio laboratorio = new Laboratorio();
        laboratorio.setCnpj(laboratorioDTO.getCnpj());
        laboratorio.setCnpj(laboratorioDTO.getCnpj());
        laboratorio.setNome(laboratorioDTO.getNome());
        laboratorio.setTelefone(laboratorioDTO.getTelefone());
        laboratorio.setEmail(laboratorioDTO.getEmail());
        laboratorio.setSite(laboratorioDTO.getSite());
        laboratorio.setDataFundacao(laboratorioDTO.getDataFundacao());
        laboratorio.setDescricao(laboratorioDTO.getDescricao());
        laboratorio.setStatus(laboratorioDTO.getStatus());

        return laboratorioRepository.save(laboratorio);
    }

}
