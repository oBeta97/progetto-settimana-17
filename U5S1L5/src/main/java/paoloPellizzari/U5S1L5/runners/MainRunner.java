package paoloPellizzari.U5S1L5.runners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import paoloPellizzari.U5S1L5.entities.Postazione;
import paoloPellizzari.U5S1L5.entities.Prenotazione;
import paoloPellizzari.U5S1L5.entities.Utente;
import paoloPellizzari.U5S1L5.enums.TipoPostazione;
import paoloPellizzari.U5S1L5.exceptions.*;
import paoloPellizzari.U5S1L5.services.EdificioService;
import paoloPellizzari.U5S1L5.services.PostazioneService;
import paoloPellizzari.U5S1L5.services.PrenotazioneService;
import paoloPellizzari.U5S1L5.services.UtenteService;

import java.time.LocalDate;
import java.util.List;

@Component
@Slf4j
public class MainRunner implements CommandLineRunner {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private EdificioService edificioService;

    @Override
    public void run(String... args) throws Exception {


//        ------------------------- POPOLAZIONE DEL DB ------------------------
//        -------------------------   prego prof :P    --------------------------
//        List<Utente> utenti = new ArrayList<>();
//        utenti.add(new Utente("thechosenone", "Harry Potter", "harry.potter@hogwarts.com"));
//        utenti.add(new Utente("heisenberg", "Walter White", "walter.white@breakingbad.com"));
//        utenti.add(new Utente("yodaspeaks", "Master Yoda", "yoda@starwars.com"));
//        utenti.add(new Utente("theonetrueking", "Jon Snow", "jon.snow@got.com"));
//        utenti.add(new Utente("strangerchild", "Eleven Hopper", "eleven.hopper@strangerthings.com"));
//
//        try{
//            utenteService.saveList(utenti);
//            log.info("Utenti salvati con successo!");
//        } catch (UserAlreadyExistException e) {
//            log.error(e.getMessage());
//        }
//
//
//        List<Edificio> edifici = new ArrayList<>();
//        edifici.add(new Edificio("Wayne Manor", "1007 Mountain Drive", "Gotham City"));
//        edifici.add(new Edificio("Avengers Tower", "890 Fifth Avenue", "New York"));
//        edifici.add(new Edificio("Stark Industries", "200 Park Avenue", "Los Angeles"));
//        edifici.add(new Edificio("Hogwarts Castle", "Hogwarts Grounds", "Scotland"));
//        edifici.add(new Edificio("Central Perk", "90 Bedford Street", "New York"));
//
//        try{
//            edificioService.saveList(edifici);
//            log.info("Edifici salvati con successo!");
//        } catch (EdificioAlreadyExistException e) {
//            log.error(e.getMessage());
//        }
//
//        // Pulisco l'array così da avere i dati degli edifici dal DB
//        edifici.clear();
//        edifici.addAll(edificioService.getAll());
//
//        Random random = new Random();
//        List<Postazione> postazioni = new ArrayList<>();
//
//        postazioni.add(new Postazione("La Stanza Segreta del Boss", TipoPostazione.PRIVATO, 1, edifici.get(random.nextInt(edifici.size()))));
//        postazioni.add(new Postazione("Open Space della Pettegola", TipoPostazione.OPENSPACE, 15, edifici.get(random.nextInt(edifici.size()))));
//        postazioni.add(new Postazione("Sala delle Riunioni Infinite", TipoPostazione.SALA_RIUNIONI, 10, edifici.get(random.nextInt(edifici.size()))));
//        postazioni.add(new Postazione("L’Antro del Geek Solitario", TipoPostazione.PRIVATO, 1, edifici.get(random.nextInt(edifici.size()))));
//        postazioni.add(new Postazione("Sala del Grande Blabla", TipoPostazione.SALA_RIUNIONI, 20, edifici.get(random.nextInt(edifici.size()))));
//
//        try{
//            postazioneService.saveList(postazioni);
//            log.info("Postazioni salvate con successo!");
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//
//        // Pulisco l'array così da avere i dati delle postazioni dal DB
//        postazioni.clear();
//        postazioni.addAll(postazioneService.getAll());
//
//        // Pulisco l'array così da avere i dati degli utenti dal DB
//        utenti.clear();
//        utenti.addAll(utenteService.getAll());
//
//        List<Prenotazione> prenotazioni = new ArrayList<>();
//
//        prenotazioni.add(new Prenotazione(LocalDate.of(2024, 11, 5), utenti.get(random.nextInt(utenti.size())), postazioni.get(random.nextInt(postazioni.size()))));
//        prenotazioni.add(new Prenotazione(LocalDate.of(2024, 12, 10), utenti.get(random.nextInt(utenti.size())), postazioni.get(random.nextInt(postazioni.size()))));
//        prenotazioni.add(new Prenotazione(LocalDate.of(2024, 10, 29), utenti.get(random.nextInt(utenti.size())), postazioni.get(random.nextInt(postazioni.size()))));
//        prenotazioni.add(new Prenotazione(LocalDate.of(2024, 11, 15), utenti.get(random.nextInt(utenti.size())), postazioni.get(random.nextInt(postazioni.size()))));
//        prenotazioni.add(new Prenotazione(LocalDate.of(2024, 12, 1), utenti.get(random.nextInt(utenti.size())), postazioni.get(random.nextInt(postazioni.size()))));
//
//        try{
//            prenotazioneService.saveList(prenotazioni);
//            log.info("Prenotazioni inserite con successo");
//        } catch (UserAlreadyBusyException | PostazioneOccupataException e) {
//            log.error(e.getMessage());
//        }

//        TEST DEI CONTROLLI
//        - La prenotazione può essere effettuata solo se per quel giorno la postazione risulta libera

        try {

            // Vanno midificati gli id perché vengono popolati randomicamente le prenotazioni
            Postazione postazione = postazioneService.getById(5);
            Utente utente = utenteService.findById(3);
            LocalDate dataPrenotazione = LocalDate.of(2024, 11, 15);

            Prenotazione prenotazione = new Prenotazione(dataPrenotazione, utente, postazione);

            // Invia una eccezione perché la postazione è già occupata
            prenotazioneService.save(prenotazione);
            log.info("prenotazione salvata con successo");

        } catch (NotFoundException | PostazioneOccupataException | UserAlreadyBusyException e) {
            log.error(e.getMessage());
        }


//        - Un utente può ricercare le postazioni indicando il tipo di postazione desiderato e la città di interesse
        List<Postazione> ricercaPostazioni = postazioneService.getPostazioniByTipoAndCitta(TipoPostazione.SALA_RIUNIONI, "Scotland");

        for(Postazione p : ricercaPostazioni)
            log.info(p.toString());

//        - Un utente può avere più prenotazioni in corso, ma non può prenotare più di una postazione per una particolare data
        try {
            // Vanno midificati gli id perché vengono popolati randomicamente le prenotazioni
            Postazione postazione = postazioneService.getById(3);
            Utente utente = utenteService.findById(3);
            LocalDate dataPrenotazione = LocalDate.of(2024, 12, 1);

            Prenotazione prenotazione = new Prenotazione(dataPrenotazione, utente, postazione);

            // Invia una eccezione perché la postazione è già occupata
            prenotazioneService.save(prenotazione);
            log.info("prenotazione salvata con successo");

        } catch (NotFoundException | PostazioneOccupataException | UserAlreadyBusyException e) {
            log.error(e.getMessage());
        }


    }
}
