package io.github.medeirosavio.repository;

import io.github.medeirosavio.model.Laboratorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LaboratorioRepository extends JpaRepository<Laboratorio,Long> {
}
