package io.github.medeirosavio.repository;

import io.github.medeirosavio.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
