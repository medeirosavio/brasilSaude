package io.github.medeirosavio.service;

import io.github.medeirosavio.dto.HospitalDTO;
import io.github.medeirosavio.model.Hospital;
import io.github.medeirosavio.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    public Hospital cadastrarHospital(HospitalDTO hospitalDTO){
        Hospital hospital = new Hospital();
        hospital.setCnpj(hospitalDTO.getCnpj());
        hospital.setNome(hospitalDTO.getNome());
        hospital.setTelefone(hospitalDTO.getTelefone());
        hospital.setEmail(hospitalDTO.getEmail());
        hospital.setSite(hospitalDTO.getSite());
        hospital.setDataFundacao(hospitalDTO.getDataFundacao());
        hospital.setDescricao(hospitalDTO.getDescricao());
        hospital.setStatus(hospitalDTO.getStatus());

        return hospitalRepository.save(hospital);
    }

}
