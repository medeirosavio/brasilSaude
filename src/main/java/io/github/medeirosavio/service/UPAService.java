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

    public void cadastrarPaciente(PacienteDTO pacienteDTO) {
        try {
            validarDataNoPassado(pacienteDTO.getDataInicioSintomas());
            validarDataNoPassado(pacienteDTO.getDataNascimento());
            Paciente paciente = converterDTOparaEntidade(pacienteDTO);
            pacienteRepository.save(paciente);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Erro de integridade de dados ao cadastrar o paciente", e);
        } catch (Exception e) {
            throw new RuntimeException("Erro interno ao processar a solicitação", e);
        }
    }

    private Paciente converterDTOparaEntidade(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setNome(pacienteDTO.getNome());
        paciente.setDataNascimento(pacienteDTO.getDataNascimento());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setSexo(pacienteDTO.getSexo());
        paciente.setTelefone(pacienteDTO.getTelefone());
        paciente.setDataInicioSintomas(pacienteDTO.getDataInicioSintomas());
        paciente.setDataInternacao(pacienteDTO.getDataInternacao());
        try {
            Endereco endereco = converterEnderecoDTOparaEntidade(pacienteDTO.getEndereco());
            paciente.setEndereco(endereco);
            enderecoRepository.save(endereco);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Erro de integridade de dados ao cadastrar o endereço", e);
        } catch (Exception e) {
            throw new RuntimeException("Erro interno ao processar a solicitação", e);
        }
        return paciente;
    }

    private void validarCnpj(String cnpj) {
        if (!CnpjValidator.isValid(cnpj)) {
            throw new IllegalArgumentException("CNPJ inválido: " + cnpj);
        }
    }

    private void validarDataNoPassado(LocalDate data) {
        if (data != null && !DatePastValidator.isPastDate(data)) {
            throw new IllegalArgumentException("A data de fundação deve estar no passado.");
        }
    }
}


