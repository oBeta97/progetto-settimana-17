package paoloPellizzari.U5S1L5.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    @Column(nullable = false)
    private LocalDate data;
    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "id_postazione")
    private Postazione postazione;

    public Prenotazione(LocalDate data, Utente utente, Postazione postazione) {
        this.data = data;
        this.utente = utente;
        this.postazione = postazione;
    }
}
