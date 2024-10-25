package paoloPellizzari.U5S1L5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import paoloPellizzari.U5S1L5.entities.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    boolean existsByUsernameOrEmail(String nome, String email);

}
