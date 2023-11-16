package io.github.medeirosavio.controller;

import io.github.medeirosavio.dto.HospitalDTO;
import io.github.medeirosavio.dto.PacienteDTO;
import io.github.medeirosavio.exception.DataIntegrityViolationException;
import io.github.medeirosavio.exception.NotFoundException;
import io.github.medeirosavio.service.HospitalService;
import io.github.medeirosavio.service.LaboratorioService;
import io.github.medeirosavio.service.UPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private UPAService upaService;
    @Autowired
    private LaboratorioService laboratorioService;

    @PostMapping("/cadastrar/upa/paciente")
    public ResponseEntity<String> cadastrarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        try {
            upaService.cadastrarPaciente(pacienteDTO);
            return new ResponseEntity<>("Paciente cadastrado com sucesso", HttpStatus.CREATED);
        } catch (NotFoundException e) {
            return new ResponseEntity<>("Paciente não encontrado", HttpStatus.NOT_FOUND);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Erro de integridade de dados ao cadastrar o paciente", HttpStatus.BAD_REQUEST);
        }/* catch (Exception e) {
            return new ResponseEntity<>("Erro interno ao processar a solicitação", HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
    }


}
