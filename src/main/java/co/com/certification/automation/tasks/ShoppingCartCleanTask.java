package co.com.certification.automation.tasks;

import co.com.certification.automation.userinterface.MiCuentaPage;
import co.com.certification.automation.userinterface.ShoppingCartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ShoppingCartCleanTask implements Task {
    @Step("clean all items in shopping cart")
    @Override
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Click.on(ShoppingCartPage.BUTTON_CLEAN_SHOPING_CART),
                Click.on(ShoppingCartPage.BUTTON_CONFIRM_CLEAN_SHOPING_CART),
                Wait.until(
                        WebElementQuestion.the(ShoppingCartPage.TITLE_CLEAN_SHOPING_CART) , WebElementStateMatchers.isEnabled()
                ).forNoMoreThan(30).seconds()
        );
    }

    public static ShoppingCartCleanTask cleanShoppingCart(){
        return instrumented(ShoppingCartCleanTask.class);
    }
}
