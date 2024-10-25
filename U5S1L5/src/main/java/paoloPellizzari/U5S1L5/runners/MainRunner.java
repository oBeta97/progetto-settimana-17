package paoloPellizzari.U5S1L5.runners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import paoloPellizzari.U5S1L5.entities.Postazione;
import paoloPellizzari.U5S1L5.entities.Prenotazione;
import paoloPellizzari.U5S1L5.entities.Utente;
import paoloPellizzari.U5S1L5.enums.TipoPostazione;
import paoloPellizzari.U5S1L5.repositories.PostazioneRepository;
import paoloPellizzari.U5S1L5.services.PostazioneService;
import paoloPellizzari.U5S1L5.services.PrenotazioneService;
import paoloPellizzari.U5S1L5.services.UtenteService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class MainRunner implements CommandLineRunner {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private UtenteService utenteService;

    @Override
    public void run(String... args) throws Exception {

    }
}
