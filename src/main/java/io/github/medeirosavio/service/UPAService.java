package io.github.medeirosavio.service;

import io.github.medeirosavio.dto.EnderecoDTO;
import io.github.medeirosavio.dto.PacienteDTO;
import io.github.medeirosavio.dto.UPADTO;
import io.github.medeirosavio.exception.DataIntegrityViolationException;
import io.github.medeirosavio.model.Endereco;
import io.github.medeirosavio.model.Paciente;
import io.github.medeirosavio.model.UPA;
import io.github.medeirosavio.repository.EnderecoRepository;
import io.github.medeirosavio.repository.PacienteRepository;
import io.github.medeirosavio.repository.UPARepository;
import io.github.medeirosavio.util.CnpjValidator;
import io.github.medeirosavio.util.CpfValidator;
import io.github.medeirosavio.util.DatePastValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UPAService {

    @Autowired
    private UPARepository upaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public void cadastrarUPA(UPADTO upadto) {
        try {
            validarCnpj(upadto.getCnpj());
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
        try {
            Endereco endereco = converterEnderecoDTOparaEntidade(upadto.getEndereco());
            upa.setEndereco(endereco);
            enderecoRepository.save(endereco);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Erro de integridade de dados ao cadastrar o endereço", e);
        } catch (Exception e) {
            throw new RuntimeException("Erro interno ao processar a solicitação", e);
        }
        return upa;
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


}


