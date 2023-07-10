package co.com.certification.automation.stepdefinitions;

import co.com.certification.automation.tasks.ArriveToExitoMainPageTask;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.certification.automation.webHooks.WebCommonSteps.actor;

public class AddProductsShoppingCartDefinition {

    @Given("Cesar esta en la seccion de cabeceras de la categoria de dormitorio")
    public void cesarEstaEnLaSeccionDeCabecerasDeLaCategoriaDeDormitorio() {
        actor.wasAbleTo(
                ArriveToExitoMainPageTask.arriveToExitoMainPage());
    }

    @When("Cesar agrega de forma aleatoria varios de estos productos al carrito de compras en diferentes cantidades")
    public void cesarAgregaDeFormaAleatoriaVariosDeEstosProductosAlCarritoDeComprasEnDiferentesCantidades() {
    }

    @Then("Cesar verifica que los nombres de los productos en el carrito de compras corresponda a lo agregado")
    public void cesarVerificaQueLosNombresDeLosProductosEnElCarritoDeComprasCorrespondaALoAgregado() {
    }

    @And("Verifica que el total de los precios de los productos corresponda")
    public void verificaQueElTotalDeLosPreciosDeLosProductosCorresponda() {
    }

    @And("Verifica que las cantidades de los productos sea lo agregado en el proceso")
    public void verificaQueLasCantidadesDeLosProductosSeaLoAgregadoEnElProceso() {
    }

    @And("que el total de los productos sea igual a las cantidades de los productos agregados")
    public void queElTotalDeLosProductosSeaIgualALasCantidadesDeLosProductosAgregados() {
    }
}
