package io.github.medeirosavio.controller;

import io.github.medeirosavio.dto.PacienteDTO;
import io.github.medeirosavio.exception.DataIntegrityViolationException;
import io.github.medeirosavio.exception.NotFoundException;
import io.github.medeirosavio.service.HospitalService;
import io.github.medeirosavio.service.LaboratorioService;
import io.github.medeirosavio.service.PacienteService;
import io.github.medeirosavio.service.UPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empresa")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/cadastrar/upa/paciente")
    public ResponseEntity<String> cadastrarPacienteUPA(@RequestBody PacienteDTO pacienteDTO, @RequestParam Long idUpa) {
        pacienteService.cadastrarPacienteUPA(pacienteDTO,idUpa);
        return new ResponseEntity<>("Paciente cadastrado com sucesso", HttpStatus.CREATED);
    }

    @PostMapping("/cadastrar/hospital/paciente")
    public ResponseEntity<String> cadastrarPacienteHospital(@RequestBody PacienteDTO pacienteDTO, @RequestParam Long idHospital) {
        pacienteService.cadastrarPacienteHospital(pacienteDTO,idHospital);
        return new ResponseEntity<>("Paciente cadastrado com sucesso", HttpStatus.CREATED);
    }

    @PostMapping("/cadastrar/laboratorio/paciente")
    public ResponseEntity<String> cadastrarPacienteLaboratorio(@RequestBody PacienteDTO pacienteDTO, @RequestParam Long idLaboratorio) {
        pacienteService.cadastrarPacienteLaboratorio(pacienteDTO,idLaboratorio);
        return new ResponseEntity<>("Paciente cadastrado com sucesso", HttpStatus.CREATED);
    }


}
