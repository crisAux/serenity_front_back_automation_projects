package co.com.certification.automation.stepdefinitions;

import co.com.certification.automation.model.Product;
import co.com.certification.automation.questions.AddedProductsAmountList;
import co.com.certification.automation.questions.AddedProductsNameList;
import co.com.certification.automation.questions.AddedProductsPriceList;
import co.com.certification.automation.tasks.ArriveToCabeceraSectionTask;
import co.com.certification.automation.tasks.GoToShoppingCartTask;
import co.com.certification.automation.tasks.SelectSeveralProductsRandomlyTask;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static co.com.certification.automation.webHooks.WebCommonSteps.EXITO_USER;
import static co.com.certification.automation.webHooks.WebCommonSteps.actor;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import static org.hamcrest.core.Is.is;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class AddProductsShoppingCartDefinition {

    private List<Product> productsInShoppingCart;
    private List<Double> priceInProductsList=new ArrayList<>();

    private List<Integer> amountInProductsList=new ArrayList<>();
    private List<String> nameInProductsList=new ArrayList<>();
    private double totalPrice=0;


    @Given("Cesar esta en la seccion de cabeceras de la categoria de dormitorio")
    public void cesarEstaEnLaSeccionDeCabecerasDeLaCategoriaDeDormitorio() {
        actor.wasAbleTo(
                ArriveToCabeceraSectionTask.arriveToHeadersSection()
        );
    }

    @When("Cesar agrega de forma aleatoria varios de estos productos al carrito de compras en diferentes cantidades")
    public void cesarAgregaDeFormaAleatoriaVariosDeEstosProductosAlCarritoDeComprasEnDiferentesCantidades() {

        actor.wasAbleTo(
                SelectSeveralProductsRandomlyTask.selectSeveralProductsRandomlyTask()
        );
        productsInShoppingCart = SelectSeveralProductsRandomlyTask.getAllProductsInShoppingCart();
        orderInformationObtainedOnTheScreen();
    }

    private void orderInformationObtainedOnTheScreen(){
        for (Product productGetted:productsInShoppingCart) {
            priceInProductsList.add(productGetted.getPrice());
            amountInProductsList.add(productGetted.getAmount());
            nameInProductsList.add(productGetted.getNameOfProduct());
            totalPrice+=(productGetted.getPrice()*productGetted.getAmount());
        }
        Collections.sort(priceInProductsList);
        Collections.sort(amountInProductsList);
        Collections.sort(nameInProductsList);
    }

    @Then("Cesar verifica que los nombres de los productos en el carrito de compras corresponda a lo agregado")
    public void cesarVerificaQueLosNombresDeLosProductosEnElCarritoDeComprasCorrespondaALoAgregado() {
        actor.wasAbleTo(
                GoToShoppingCartTask.goToShoppingCart(EXITO_USER)
        );
        actor.should(GivenWhenThen.seeThat(AddedProductsNameList.listOfAddedProducts(),
                is(nameInProductsList)));
    }

    @And("Verifica que el total de los precios de los productos corresponda")
    public void verificaQueElTotalDeLosPreciosDeLosProductosCorresponda() {
        actor.should(GivenWhenThen.seeThat(AddedProductsPriceList.listOfAddedProducts(),
                is(priceInProductsList)));
    }

    @And("Verifica que las cantidades de los productos sea lo agregado en el proceso")
    public void verificaQueLasCantidadesDeLosProductosSeaLoAgregadoEnElProceso() {
        actor.should(GivenWhenThen.seeThat(AddedProductsAmountList.listOfAddedProducts(),
                is(amountInProductsList)));
    }

    @And("que el total de los productos sea igual a las cantidades de los productos agregados")
    public void queElTotalDeLosProductosSeaIgualALasCantidadesDeLosProductosAgregados() {
    }
}
