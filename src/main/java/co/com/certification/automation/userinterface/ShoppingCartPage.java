package co.com.certification.automation.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ShoppingCartPage {

    public static final Target INPUT_EMAIL_SHOPPING_CART= Target.the("email to go shopping cart")
            .located(By.cssSelector("input[type='email']"));

    public static final Target BUTTON_CONFIRM_EMAIL=Target.the("button to confirm email")
            .located(By.cssSelector("button[class*='preLoginActiveButton']"));

    public static final Target BUTTON_CONTINUE_SHOPPING=Target.the("button to continue shopping")
            .located(By.cssSelector("div[class*='continueShoppingButton']"));

    public static final Target LIST_OF_PRODUCTS_NAME_IN_SHOPPING_CART=Target.the("list of products name selected in shopping cart")
            .located(By.cssSelector("div[class='exito-checkout-io-0-x-itemCartContent'] span[data-molecule-product-detail-name-span='true']"));

    public static final Target LIST_OF_PRODUCTS_AMOUNT_IN_SHOPPING_CART=Target.the("list of products amount selected in shopping cart")
            .located(By.cssSelector("div[class='exito-checkout-io-0-x-itemCartContent'] span[data-molecule-quantity-und-value='true']"));

    public static final Target LIST_OF_PRODUCTS_PRICE_IN_SHOPPING_CART=Target.the("list of products price selected in shopping cart")
            .located(By.cssSelector("div[class='exito-checkout-io-0-x-itemCartContent'] div[data-molecule-product-detail-price-best-price='true']"));

    public static final Target ELEMENT_WITH_TOTAL_PRICE=Target.the("element with total price")
            .located(By.cssSelector("div[class='exito-checkout-io-0-x-summaryTotal'] span[data-molecule-summary-item-value='true']"));


}
