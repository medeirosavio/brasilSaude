package io.github.medeirosavio.service;

import io.github.medeirosavio.dto.EnderecoDTO;
import io.github.medeirosavio.dto.HospitalDTO;
import io.github.medeirosavio.model.Endereco;
import io.github.medeirosavio.model.Hospital;
import io.github.medeirosavio.repository.EnderecoRepository;
import io.github.medeirosavio.repository.HospitalRepository;
import io.github.medeirosavio.util.CnpjValidator;
import io.github.medeirosavio.util.NumberPositiveValidator;
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
            validarCnpj(hospitalDTO.getCnpj());
            validarLeitosMaiorIgualaZero(hospitalDTO.getLeitosEnfermariaDisponiveis());
            validarLeitosMaiorIgualaZero(hospitalDTO.getLeitosUtiDisponiveis());
            validarLeitosMaiorqueZero(hospitalDTO.getLeitosUtiTotal());
            validarLeitosMaiorqueZero(hospitalDTO.getLeitosEnfermariaTotal());
            validarMaior(hospitalDTO.getLeitosEnfermariaTotal(),hospitalDTO.getLeitosEnfermariaDisponiveis());
            validarMaior(hospitalDTO.getLeitosUtiTotal(),hospitalDTO.getLeitosUtiDisponiveis());
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
        hospital.setLeitosEnfermariaTotal(hospitalDTO.getLeitosEnfermariaTotal());
        hospital.setLeitosEnfermariaDisponiveis(hospitalDTO.getLeitosEnfermariaDisponiveis());
        hospital.setLeitosUtiTotal(hospitalDTO.getLeitosUtiTotal());
        hospital.setLeitosUtiDisponiveis(hospitalDTO.getLeitosUtiDisponiveis());
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

    private void validarCnpj(String cnpj) {
        if (!CnpjValidator.isValid(cnpj)) {
            throw new IllegalArgumentException("CNPJ inválido: " + cnpj);
        }
    }
    private void validarLeitosMaiorqueZero(Integer leitosUtiTotal) {
        NumberPositiveValidator.validateMaiorQueZero(leitosUtiTotal, "Leitos de UTI");
    }

    private void validarLeitosMaiorIgualaZero(Integer leitosUtiTotal) {
        NumberPositiveValidator.validateMenorIgualZero(leitosUtiTotal, "Leitos de UTI");
    }

    private void validarMaior(Integer leitosTotal, Integer leitosDisponiveis){
        NumberPositiveValidator.validateMaiorQueOutro(leitosTotal, leitosDisponiveis, "Leitos de UTI");
    }

}
