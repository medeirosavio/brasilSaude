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
        hospitalService.cadastrarHospital(hospitalDTO);
        return new ResponseEntity<>("Hospital cadastrado com sucesso", HttpStatus.CREATED);
    }

    @PostMapping("/cadastrar/upa")
    public ResponseEntity<String> cadastrarUPA(@RequestBody UPADTO upadto) {
        upaService.cadastrarUPA(upadto);
        return new ResponseEntity<>("UPA cadastrada com sucesso", HttpStatus.CREATED);
    }

    @PostMapping("/cadastrar/laboratorio")
    public ResponseEntity<String> cadastrarLaboratorio(@RequestBody LaboratorioDTO laboratorioDTO) {
        laboratorioService.cadastrarLaboratorio(laboratorioDTO);
        return new ResponseEntity<>("Laboratorio cadastrado com sucesso", HttpStatus.CREATED);
    }

    @PostMapping("/cadastrar/funcionario")
    public ResponseEntity<String> cadastrarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        funcionarioService.cadastrarFuncionario(funcionarioDTO);
        return new ResponseEntity<>("Funcionario cadastrado com sucesso", HttpStatus.CREATED);
    }

    @DeleteMapping("/funcionario/{id}")
    public ResponseEntity<String> removerFuncionario(@PathVariable Long id) {
            funcionarioService.removerFuncionario(id);
            return ResponseEntity.ok("Funcionário removido com sucesso.");
    }


}
