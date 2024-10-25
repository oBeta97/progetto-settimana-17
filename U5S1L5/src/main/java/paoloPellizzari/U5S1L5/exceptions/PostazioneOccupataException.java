package paoloPellizzari.U5S1L5.exceptions;

import paoloPellizzari.U5S1L5.entities.Postazione;

import java.time.LocalDate;

public class PostazioneOccupataException extends Exception {
    public PostazioneOccupataException(Postazione p, LocalDate data) {
        super("la postazione con id " + p.getId() + " è già stata prenotata in data " + data);
    }
}
