package paoloPellizzari.U5S1L5.entities;

import jakarta.persistence.*;
import lombok.*;
import paoloPellizzari.U5S1L5.enums.TipoPostazione;

@Entity
@Table(name = "postazioni")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String descrizione;
    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;
    @Column(name = "nr_max_occupanti", nullable = false)
    private int nrMaxOccupanti;
    @ManyToOne
    @JoinColumn(name = "id_edificio")
    private Edificio edificio;

    public Postazione(String descrizione, TipoPostazione tipo, int nrMaxOccupanti, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.nrMaxOccupanti = nrMaxOccupanti;
        this.edificio = edificio;
    }
}
