package paoloPellizzari.U5S1L5.exceptions;

import paoloPellizzari.U5S1L5.entities.Utente;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(Utente u) {
        super("L'utente " + u + "esiste già nel database");
    }
}
