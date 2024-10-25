package paoloPellizzari.U5S1L5.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paoloPellizzari.U5S1L5.entities.Edificio;
import paoloPellizzari.U5S1L5.exceptions.EdificioAlreadyExistException;
import paoloPellizzari.U5S1L5.repositories.EdificioRepository;

import java.util.List;

@Service
@Slf4j
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepo;

    public void save(Edificio e) throws EdificioAlreadyExistException {

        if(edificioRepo.existsByIndirizzo(e.getIndirizzo())) throw new EdificioAlreadyExistException(e);

        edificioRepo.save(e);

    }

    public void saveList(List<Edificio> edificioList) throws EdificioAlreadyExistException {
        for(Edificio e : edificioList)
            this.save(e);
    }

    public List<Edificio> getAll(){
        return edificioRepo.findAll();
    }

}
