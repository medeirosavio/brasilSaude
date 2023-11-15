package io.github.medeirosavio.service;

import io.github.medeirosavio.dto.EnderecoDTO;
import io.github.medeirosavio.dto.LaboratorioDTO;
import io.github.medeirosavio.exception.DataIntegrityViolationException;
import io.github.medeirosavio.model.Endereco;
import io.github.medeirosavio.model.Laboratorio;
import io.github.medeirosavio.repository.EnderecoRepository;
import io.github.medeirosavio.repository.LaboratorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaboratorioService {

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

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
        try {
            Endereco endereco = converterEnderecoDTOparaEntidade(laboratorioDTO.getEndereco());
            laboratorio.setEndereco(endereco);
            enderecoRepository.save(endereco);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Erro de integridade de dados ao cadastrar o endereço", e);
        } catch (Exception e) {
            throw new RuntimeException("Erro interno ao processar a solicitação", e);
        }
        return laboratorio;
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
