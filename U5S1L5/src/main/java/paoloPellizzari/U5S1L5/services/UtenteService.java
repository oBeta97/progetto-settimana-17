package paoloPellizzari.U5S1L5.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paoloPellizzari.U5S1L5.entities.Postazione;
import paoloPellizzari.U5S1L5.entities.Utente;
import paoloPellizzari.U5S1L5.enums.TipoPostazione;
import paoloPellizzari.U5S1L5.exceptions.NotFoundException;
import paoloPellizzari.U5S1L5.exceptions.UserAlreadyExistException;
import paoloPellizzari.U5S1L5.repositories.PostazioneRepository;
import paoloPellizzari.U5S1L5.repositories.UtenteRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepo;


    public void save(Utente u) throws UserAlreadyExistException {

        if(utenteRepo.existsByUsernameOrEmail(u.getUsername(), u.getEmail())) throw new UserAlreadyExistException(u);

        utenteRepo.save(u);

    }

    public void saveList(List<Utente> utenteList) throws UserAlreadyExistException {

        for (Utente u : utenteList)
            this.save(u);
    }

    public Utente findById(long id) throws NotFoundException {

        Optional<Utente> res = utenteRepo.findById(id);

        if(res.isEmpty()) throw new NotFoundException(Utente.class);

        return res.get();

    }


    public List<Utente> getAll(){
        return utenteRepo.findAll();
    }


}
