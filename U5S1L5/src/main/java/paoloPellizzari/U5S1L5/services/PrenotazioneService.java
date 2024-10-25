package paoloPellizzari.U5S1L5.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paoloPellizzari.U5S1L5.entities.Postazione;
import paoloPellizzari.U5S1L5.entities.Prenotazione;
import paoloPellizzari.U5S1L5.entities.Utente;
import paoloPellizzari.U5S1L5.exceptions.PostazioneOccupataException;
import paoloPellizzari.U5S1L5.exceptions.UserAlreadyBusyException;
import paoloPellizzari.U5S1L5.exceptions.UserAlreadyExistException;
import paoloPellizzari.U5S1L5.repositories.PrenotazioneRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepo;

    public void save(Prenotazione p) throws PostazioneOccupataException, UserAlreadyBusyException {

        // Verifica che la postazione non sia già prenotata
        if (!prenotazioneRepo.getPrenotazioniByDateAndPostaione(p.getData(), p.getPostazione()).isEmpty()) throw new PostazioneOccupataException(p.getPostazione(), p.getData());

        // Verifica che l'utente non sia già occupato in quella data
        if(prenotazioneRepo.existsByDataAndUtente(p.getData(), p.getUtente())) throw new UserAlreadyBusyException(p.getUtente(), p.getData());


        prenotazioneRepo.save(p);
    }

    public void saveList(List<Prenotazione> prenotazioneList) throws UserAlreadyBusyException, PostazioneOccupataException {
        for (Prenotazione p : prenotazioneList)
            this.save(p);
    }


    public boolean existPrenotazioneUtenteNellaData(Utente u, LocalDate date){
        return prenotazioneRepo.existsByDataAndUtente(date,u);
    }



}
