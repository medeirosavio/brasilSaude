package io.github.medeirosavio.repository;

import io.github.medeirosavio.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HospitalRepository extends JpaRepository<Hospital,Long> {
}
