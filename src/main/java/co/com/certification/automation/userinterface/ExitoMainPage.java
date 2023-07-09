package co.com.certification.automation.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.exito.com/")
public class ExitoMainPage extends PageObject {

    public static final Target FORM_LOGIN_BUTTON = Target.the("button for go to form login")
            .located(By.cssSelector("span>svg>use[href='#hpa-profile']"));


}
