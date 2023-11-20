package io.github.medeirosavio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospital extends Empresa{
    @OneToOne(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;
    @OneToMany(mappedBy = "hospital")
    private List<Paciente> pacientes = new ArrayList<>();
    @OneToMany(mappedBy = "hospital")
    private List<RegistroOcupacao> registrosOcupacao = new ArrayList<>();

}
