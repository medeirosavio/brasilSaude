package io.github.medeirosavio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UPA extends Empresa{

    @OneToOne(mappedBy = "upa", cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;
    @OneToMany(mappedBy = "upa")
    private List<Paciente> pacientes = new ArrayList<>();
}
