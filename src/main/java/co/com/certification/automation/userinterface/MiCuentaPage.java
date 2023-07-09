package co.com.certification.automation.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MiCuentaPage {

    public static final Target GO_TO_LOGIN_BUTTON = Target.the("button for go to login with email and password")
            .located(By.cssSelector("ul[class='vtex-login-2-x-optionsList list pa0'] > li:nth-child(2)"));
    public static final Target INPUT_EMAIL= Target.the("input for email").located(By.cssSelector("input[placeholder*='email']"));

    public static final Target INPUT_PASSWORD= Target.the("input for password").located(By.cssSelector("input[placeholder*='contras']"));

    public static final Target SING_IN= Target.the("button to make login").located(By.cssSelector("div[class*='auto']>button[class*='vtex-button']"));


}
