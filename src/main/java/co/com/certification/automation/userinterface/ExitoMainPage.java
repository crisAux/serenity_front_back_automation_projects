package co.com.certification.automation.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.exito.com/")
public class ExitoMainPage extends PageObject {

    public static final Target FORM_LOGIN_BUTTON = Target.the("button for go to form login")
            .located(By.cssSelector("span>svg>use[href='#hpa-profile']"));
    public static final Target BUTTON_MENU_EXITO= Target.the("button to click in main menu to exito")
            .located(By.cssSelector("div[class='exito-category-menu-3-x-button'] > button"));
    public static final Target BUTTON_DORMITORIO =  Target.the("buttoon to select domitorio category")
            .located(By.cssSelector("li[id='undefined-nivel2-Dormitorio']"));
    public static final Target BUTTON_CABECERAS = Target.the("button to select cabeceras category")
            .located(By.cssSelector("a[id*='nivel3-Cabeceros']"));
    public static final Target BUTTON_CLOSE_MENU = Target.the("button for close the menu")
            .located(By.cssSelector("div[class='exito-category-menu-3-x-iconClose'] > button"));

    public static final Target LINK_SHOPPING_CART= Target.the("link to all products in shopping cart")
            .located(By.cssSelector("a[class='exito-header-3-x-minicartLink']"));
}
