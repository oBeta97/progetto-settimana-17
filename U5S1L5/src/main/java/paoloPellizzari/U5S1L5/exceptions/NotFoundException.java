package paoloPellizzari.U5S1L5.exceptions;

public class NotFoundException extends Exception {
    public <T> NotFoundException(Class<T> obj) {
        super(obj.getSimpleName() + " not found!");
    }
}
