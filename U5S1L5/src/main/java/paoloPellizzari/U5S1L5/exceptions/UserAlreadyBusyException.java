package paoloPellizzari.U5S1L5.exceptions;

import paoloPellizzari.U5S1L5.entities.Utente;

import java.time.LocalDate;

public class UserAlreadyBusyException extends Exception {
    public UserAlreadyBusyException(Utente u, LocalDate date) {
        super("L'utente " + u + " risulta gia occupato in data " + date);
    }
}
