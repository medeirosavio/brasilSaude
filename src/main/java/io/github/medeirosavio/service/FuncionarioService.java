package io.github.medeirosavio.service;

import io.github.medeirosavio.dto.EnderecoDTO;
import io.github.medeirosavio.dto.FuncionarioDTO;
import io.github.medeirosavio.exception.DataIntegrityViolationException;
import io.github.medeirosavio.exception.NotFoundException;
import io.github.medeirosavio.model.Endereco;
import io.github.medeirosavio.model.Funcionario;
import io.github.medeirosavio.repository.EnderecoRepository;
import io.github.medeirosavio.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public void cadastrarFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            Funcionario funcionario = converterDTOparaEntidade(funcionarioDTO);
            funcionarioRepository.save(funcionario);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Erro de integridade de dados ao cadastrar o funcionário", e);
        } catch (Exception e) {
            throw new RuntimeException("Erro interno ao processar a solicitação", e);
        }
    }

    private Funcionario converterDTOparaEntidade(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario();
        funcionario.setCpf(funcionarioDTO.getCpf());
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setDataNascimento(funcionarioDTO.getDataNascimento());
        funcionario.setEmail(funcionarioDTO.getEmail());
        funcionario.setSexo(funcionarioDTO.getSexo());
        funcionario.setTelefone(funcionarioDTO.getTelefone());
        funcionario.setCargo(funcionarioDTO.getCargo());
        funcionario.setDepartamento(funcionarioDTO.getDepartamento());
        funcionario.setStatus(funcionarioDTO.getStatus());
        funcionario.setDataAdmissao(funcionarioDTO.getDataAdmissao());
        funcionario.setSalario(funcionarioDTO.getSalario());
        try {
            Endereco endereco = converterEnderecoDTOparaEntidade(funcionarioDTO.getEndereco());
            funcionario.setEndereco(endereco);
            enderecoRepository.save(endereco);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Erro de integridade de dados ao cadastrar o endereço", e);
        } catch (Exception e) {
            throw new RuntimeException("Erro interno ao processar a solicitação", e);
        }

        return funcionario;
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

    @Transactional
    public void removerFuncionario(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Funcionário não encontrado"));

        funcionario.removerEndereco();
        funcionarioRepository.delete(funcionario);
    }


}


