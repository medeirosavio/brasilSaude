package io.github.medeirosavio.controller;

import io.github.medeirosavio.dto.FuncionarioDTO;
import io.github.medeirosavio.dto.HospitalDTO;
import io.github.medeirosavio.dto.LaboratorioDTO;
import io.github.medeirosavio.dto.UPADTO;
import io.github.medeirosavio.exception.DataIntegrityViolationException;
import io.github.medeirosavio.exception.NotFoundException;
import io.github.medeirosavio.service.FuncionarioService;
import io.github.medeirosavio.service.HospitalService;
import io.github.medeirosavio.service.LaboratorioService;
import io.github.medeirosavio.service.UPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/administrador")
public class AdministradorController {

    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private UPAService upaService;
    @Autowired
    private LaboratorioService laboratorioService;
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/cadastrar/hospital")
    public ResponseEntity<String> cadastrarHospital(@RequestBody HospitalDTO hospitalDTO) {
        try {
            hospitalService.cadastrarHospital(hospitalDTO);
            return new ResponseEntity<>("Hospital cadastrado com sucesso", HttpStatus.CREATED);
        } catch (NotFoundException e) {
            return new ResponseEntity<>("Hospital não encontrado", HttpStatus.NOT_FOUND);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Erro de integridade de dados ao cadastrar o hospital", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno ao processar a solicitação", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/cadastrar/upa")
    public ResponseEntity<String> cadastrarUPA(@RequestBody UPADTO upadto) {
        try {
            upaService.cadastrarUPA(upadto);
            return new ResponseEntity<>("UPA cadastrada com sucesso", HttpStatus.CREATED);
        } catch (NotFoundException e) {
            return new ResponseEntity<>("UPA não encontrada", HttpStatus.NOT_FOUND);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Erro de integridade de dados ao cadastrar a UPA", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno ao processar a solicitação", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/cadastrar/laboratorio")
    public ResponseEntity<String> cadastrarLaboratorio(@RequestBody LaboratorioDTO laboratorioDTO) {
        try {
            laboratorioService.cadastrarLaboratorio(laboratorioDTO);
            return new ResponseEntity<>("Laboratorio cadastrado com sucesso", HttpStatus.CREATED);
        } catch (NotFoundException e) {
            return new ResponseEntity<>("Laboratorio não encontrado", HttpStatus.NOT_FOUND);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Erro de integridade de dados ao cadastrar o laboratorio", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno ao processar a solicitação", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/cadastrar/funcionario")
    public ResponseEntity<String> cadastrarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        try {
            funcionarioService.cadastrarFuncionario(funcionarioDTO);
            return new ResponseEntity<>("Funcionario cadastrado com sucesso", HttpStatus.CREATED);
        } catch (NotFoundException e) {
            return new ResponseEntity<>("Funcionario não encontrado", HttpStatus.NOT_FOUND);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Erro de integridade de dados ao cadastrar o funcionario", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno ao processar a solicitação", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/funcionario/{id}")
    public ResponseEntity<String> removerFuncionario(@PathVariable Long id) {
        try {
            funcionarioService.removerFuncionario(id);
            return ResponseEntity.ok("Funcionário removido com sucesso.");
        } catch (NotFoundException e) {
            return ResponseEntity.status(404).body("Funcionário não encontrado.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao remover o funcionário.");
        }
    }


}
