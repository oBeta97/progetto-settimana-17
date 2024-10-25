package paoloPellizzari.U5S1L5.exceptions;

import paoloPellizzari.U5S1L5.entities.Edificio;

public class EdificioAlreadyExistException extends Exception {
    public EdificioAlreadyExistException(Edificio e) {
        super("L'edificio " + e + " esiste gia nel database!");
    }
}
