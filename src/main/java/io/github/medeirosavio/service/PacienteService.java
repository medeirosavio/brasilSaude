package io.github.medeirosavio.service;

import io.github.medeirosavio.dto.EnderecoDTO;
import io.github.medeirosavio.dto.PacienteDTO;
import io.github.medeirosavio.exception.DataIntegrityViolationException;
import io.github.medeirosavio.model.Endereco;
import io.github.medeirosavio.model.Paciente;
import io.github.medeirosavio.model.UPA;
import io.github.medeirosavio.repository.EnderecoRepository;
import io.github.medeirosavio.repository.PacienteRepository;
import io.github.medeirosavio.repository.UPARepository;
import io.github.medeirosavio.util.CpfValidator;
import io.github.medeirosavio.util.DatePastValidator;
import io.github.medeirosavio.util.IdValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PacienteService {

    @Autowired
    private UPARepository upaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public void cadastrarPacienteUPA(PacienteDTO pacienteDTO,Long idUpa) {
        try {
            Paciente paciente = converterDTOparaEntidade(pacienteDTO,idUpa);
            pacienteRepository.save(paciente);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Erro de integridade de dados ao cadastrar o paciente", e);
        } catch (Exception e) {
            throw new RuntimeException("Erro interno ao processar a solicitação", e);
        }
    }

    private Paciente converterDTOparaEntidade(PacienteDTO pacienteDTO,Long idUpa) {
        Paciente paciente = new Paciente();
        UPA upa = upaRepository.getById(idUpa);
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setNome(pacienteDTO.getNome());
        paciente.setDataNascimento(pacienteDTO.getDataNascimento());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setSexo(pacienteDTO.getSexo());
        paciente.setTelefone(pacienteDTO.getTelefone());
        paciente.setDataInicioSintomas(pacienteDTO.getDataInicioSintomas());
        paciente.setDataInternacao(pacienteDTO.getDataInternacao());
        paciente.setUpa(upa);
        validarDataNoPassado(pacienteDTO.getDataInicioSintomas());
        validarDataNoPassado(pacienteDTO.getDataNascimento());
        validarCpf(pacienteDTO.getCpf());
        validarId(idUpa);
        upa.getPacientes().add(paciente);
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

    private void validarDataNoPassado(LocalDate data) {
        if (data != null && !DatePastValidator.isPastDate(data)) {
            throw new IllegalArgumentException("A data de fundação deve estar no passado.");
        }
    }

    private void validarCpf(String cpf) {
        if (!CpfValidator.isValid(cpf)) {
            throw new IllegalArgumentException("CPF inválido" + cpf);
        }
    }

    private void validarId(Long id){
        if (!IdValidator.isIdValid(id)){
            throw new IllegalArgumentException("ID Inválido" + id);
        }
    }


}


