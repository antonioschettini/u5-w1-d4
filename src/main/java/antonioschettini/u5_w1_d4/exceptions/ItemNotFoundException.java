package antonioschettini.u5_w1_d4.exceptions;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(Long id) {
        super("L'elemento con Id: " + id + " non è stato trovato nel db!");
    }

    public ItemNotFoundException(String message) {
        super(message);
    }
}
