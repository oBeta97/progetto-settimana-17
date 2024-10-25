package paoloPellizzari.U5S1L5.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import paoloPellizzari.U5S1L5.entities.Postazione;
import paoloPellizzari.U5S1L5.entities.Prenotazione;
import paoloPellizzari.U5S1L5.entities.Utente;
import paoloPellizzari.U5S1L5.enums.TipoPostazione;
import paoloPellizzari.U5S1L5.exceptions.PostazioneOccupataException;
import paoloPellizzari.U5S1L5.repositories.PostazioneRepository;
import paoloPellizzari.U5S1L5.repositories.PrenotazioneRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepo;

    public List<Postazione> getPostazioniByTipoAndCitta(TipoPostazione tipo, String cittaEdificio){

        return postazioneRepo.findByTipoAndEdificio (tipo, cittaEdificio);

    }

}
