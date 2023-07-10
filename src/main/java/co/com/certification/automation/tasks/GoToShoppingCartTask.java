package co.com.certification.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class GoToShoppingCartTask implements Task {
    @Override
    @Step("Ir al carrito de compras con el resumen de productos agregados")
    public <T extends Actor> void performAs(T actor) {

    }
}
