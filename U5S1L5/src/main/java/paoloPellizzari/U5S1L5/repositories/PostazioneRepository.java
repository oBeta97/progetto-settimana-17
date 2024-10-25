package paoloPellizzari.U5S1L5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import paoloPellizzari.U5S1L5.entities.Edificio;
import paoloPellizzari.U5S1L5.entities.Postazione;
import paoloPellizzari.U5S1L5.enums.TipoPostazione;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione,Long> {

    @Query("SELECT p FROM Postazione p JOIN p.edificio e WHERE p.tipo = :tipo AND e.citta = :cittaEdificio")
    List<Postazione> findByTipoAndEdificio(TipoPostazione tipo, String cittaEdificio);
}
