package io.github.medeirosavio.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Leito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoLeito tipoLeito;
    private StatusLeito statusLeito;

    @OneToMany(mappedBy = "leito")
    private List<RegistroOcupacao> registrosOcupacao = new ArrayList<>();

    public Leito() {
    }
    public Leito(TipoLeito tipoLeito, StatusLeito statusLeito) {
        this.tipoLeito = tipoLeito;
        this.statusLeito = statusLeito;
    }
}
