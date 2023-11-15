package io.github.medeirosavio.service;

import io.github.medeirosavio.dto.EnderecoDTO;
import io.github.medeirosavio.dto.HospitalDTO;
import io.github.medeirosavio.model.Endereco;
import io.github.medeirosavio.model.Hospital;
import io.github.medeirosavio.repository.EnderecoRepository;
import io.github.medeirosavio.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.medeirosavio.exception.DataIntegrityViolationException;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

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
        try {
            Endereco endereco = converterEnderecoDTOparaEntidade(hospitalDTO.getEndereco());
            hospital.setEndereco(endereco);
            enderecoRepository.save(endereco);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Erro de integridade de dados ao cadastrar o endereço", e);
        } catch (Exception e) {
            throw new RuntimeException("Erro interno ao processar a solicitação", e);
        }
        return hospital;
    }

    private Endereco converterEnderecoDTOparaEntidade(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        endereco.setRua(enderecoDTO.getRua());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setComplemento(enderecoDTO.getComplemento());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setEstado(enderecoDTO.getEstado());
        endereco.setCep(enderecoDTO.getCep());

        return endereco;
    }

}
