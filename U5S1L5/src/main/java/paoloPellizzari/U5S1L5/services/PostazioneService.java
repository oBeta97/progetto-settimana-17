package paoloPellizzari.U5S1L5.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import paoloPellizzari.U5S1L5.entities.Edificio;
import paoloPellizzari.U5S1L5.entities.Postazione;
import paoloPellizzari.U5S1L5.entities.Prenotazione;
import paoloPellizzari.U5S1L5.entities.Utente;
import paoloPellizzari.U5S1L5.enums.TipoPostazione;
import paoloPellizzari.U5S1L5.exceptions.NotFoundException;
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


    public void save(Postazione p){
        postazioneRepo.save(p);
    }

    public void saveList(List<Postazione> postazioneList){
        for (Postazione p : postazioneList)
            this.save(p);
    }


    public Postazione getById(long id) throws NotFoundException {
        Optional<Postazione> res = postazioneRepo.findById(id);

        if (res.isEmpty()) throw new NotFoundException(Postazione.class);

        return res.get();

    }

    public List<Postazione> getPostazioniByTipoAndCitta(TipoPostazione tipo, String cittaEdificio){
        return postazioneRepo.findByTipoAndEdificio (tipo, cittaEdificio);
    }

    public List<Postazione> getAll(){
        return postazioneRepo.findAll();
    }

}
