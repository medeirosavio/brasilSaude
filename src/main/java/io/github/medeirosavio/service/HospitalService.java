package io.github.medeirosavio.service;

import io.github.medeirosavio.dto.HospitalDTO;
import io.github.medeirosavio.model.Hospital;
import io.github.medeirosavio.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.medeirosavio.exception.DataIntegrityViolationException;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    public void cadastrarHospital(HospitalDTO hospitalDTO) {
        try {
            Hospital hospital = converterDTOparaEntidade(hospitalDTO);
            hospitalRepository.save(hospital);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Erro de integridade de dados ao cadastrar o hospital", e);
        } catch (Exception e) {
            throw new RuntimeException("Erro interno ao processar a solicitação", e);
        }
    }

    private Hospital converterDTOparaEntidade(HospitalDTO hospitalDTO) {
        Hospital hospital = new Hospital();
        hospital.setCnpj(hospitalDTO.getCnpj());
        hospital.setNome(hospitalDTO.getNome());
        hospital.setTelefone(hospitalDTO.getTelefone());
        hospital.setEmail(hospitalDTO.getEmail());
        hospital.setSite(hospitalDTO.getSite());
        hospital.setDataFundacao(hospitalDTO.getDataFundacao());
        hospital.setDescricao(hospitalDTO.getDescricao());
        hospital.setStatus(hospitalDTO.getStatus());
        return hospital;
    }

}
