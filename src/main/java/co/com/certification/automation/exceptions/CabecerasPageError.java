package co.com.certification.automation.exceptions;

public class CabecerasPageError extends AssertionError{

    public static final String MESSAGE_CABECERA_PAGE_NOT_LOADED = "The cabecera page of exito.com could not be loaded";

    public CabecerasPageError(String message, Throwable cause) {
        super(message, cause);
    }
}
