package io.github.medeirosavio.service;

import io.github.medeirosavio.exception.NotFoundException;
import io.github.medeirosavio.repository.HospitalRepository;
import io.github.medeirosavio.repository.LaboratorioRepository;
import io.github.medeirosavio.repository.UPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityValidationService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    @Autowired
    private UPARepository upaRepository;

    public Object validarEntidadePorId(Long id) {
        // Lógica para determinar o tipo de entidade associada ao ID
        if (hospitalRepository.existsById(id)) {
            return hospitalRepository.findById(id).orElseThrow(() -> new NotFoundException("Hospital não encontrado"));
        } else if (laboratorioRepository.existsById(id)) {
            return laboratorioRepository.findById(id).orElseThrow(() -> new NotFoundException("Laboratório não encontrado"));
        } else if (upaRepository.existsById(id)) {
            return upaRepository.findById(id).orElseThrow(() -> new NotFoundException("UPA não encontrada"));
        } else {
            throw new NotFoundException("Entidade não encontrada para o ID: " + id);
        }
    }
}
