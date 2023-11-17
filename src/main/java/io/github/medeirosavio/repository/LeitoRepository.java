package io.github.medeirosavio.repository;

import io.github.medeirosavio.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LeitoRepository extends JpaRepository<Endereco,Long> {
}
