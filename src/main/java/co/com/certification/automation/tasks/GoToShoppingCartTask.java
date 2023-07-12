package co.com.certification.automation.tasks;

import co.com.certification.automation.userinterface.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GoToShoppingCartTask implements Task {

    private final String email;

    public GoToShoppingCartTask(String email) {
        this.email = email;
    }

    @Override
    @Step("Ir al carrito de compras con el resumen de productos agregados")
    public <T extends Actor> void performAs(T theActor) {
       theActor.attemptsTo(
               Click.on(ExitoMainPage.LINK_SHOPPING_CART),
               Enter.theValue(email).into(ShoppingCartPage.INPUT_EMAIL_SHOPPING_CART),
               Click.on(ShoppingCartPage.BUTTON_CONFIRM_EMAIL),
               Wait.until(
                       WebElementQuestion.the(ShoppingCartPage.BUTTON_CONTINUE_SHOPPING) , WebElementStateMatchers.isEnabled()
               ).forNoMoreThan(30).seconds()
       );

    }

    public static GoToShoppingCartTask goToShoppingCart(String email){
        return instrumented(GoToShoppingCartTask.class,email);
    }
}
