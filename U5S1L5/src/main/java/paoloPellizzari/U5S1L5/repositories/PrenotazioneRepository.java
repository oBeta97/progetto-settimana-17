package paoloPellizzari.U5S1L5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import paoloPellizzari.U5S1L5.entities.Postazione;
import paoloPellizzari.U5S1L5.entities.Prenotazione;
import paoloPellizzari.U5S1L5.entities.Utente;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {


    @Query("SELECT pr FROM Prenotazione pr JOIN pr.postazione po WHERE pr.data = :data AND po = :postazione")
    List<Prenotazione> getPrenotazioniByDateAndPostaione(LocalDate data, Postazione postazione);

    boolean existsByDataAndUtente(LocalDate data, Utente utente);


}
