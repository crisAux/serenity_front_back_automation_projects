package co.com.certification.automation.exceptions;

public class LandingPageExitoError extends AssertionError  {

    public static final String MESSAGE_MAIN_PAGE_NOT_LOADED = "The main page of exito.com could not be loaded";

    public static final String MAIN_MENU_NOT_LOADED = "The main page of exito.com could not be loaded";

    public static final String MESSAGE_LOGIN_FORM_NOT_LOADED = "The exito.com login form could not be loaded";
    public static final String MESSAGE_FAILED_AUTHENTICATION = "Authentication failed";

    public LandingPageExitoError(String message, Throwable cause) {
        super(message, cause);
    }
}