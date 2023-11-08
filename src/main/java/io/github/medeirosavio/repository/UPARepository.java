package io.github.medeirosavio.repository;

import io.github.medeirosavio.model.UPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UPARepository extends JpaRepository<UPA,Long> {
}
