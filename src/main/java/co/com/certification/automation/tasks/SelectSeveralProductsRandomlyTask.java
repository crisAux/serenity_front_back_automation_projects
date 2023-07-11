package co.com.certification.automation.tasks;

import co.com.certification.automation.model.Product;
import co.com.certification.automation.userinterface.CabecerasPage;
import io.cucumber.datatable.internal.difflib.Chunk;
import net.serenitybdd.core.pages.ClickStrategy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.HoverOverTarget;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollTo;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectSeveralProductsRandomlyTask implements Task {

    private List<Product> products;
    public SelectSeveralProductsRandomlyTask() {
        generateProductsListRandom();
    }

    private void generateProductsListRandom() {
        products = new ArrayList<>();
        Set<Integer> generatePositions = new HashSet<>();
        Random random = new Random();
        while (products.size() < 5) {
            int position = random.nextInt(20) + 1;
            if (!(generatePositions.contains(position))) {
                generatePositions.add(position);
                int amount = random.nextInt(10) + 1;
                Product objeto = new Product(position, amount);
                products.add(objeto);
            }
        }
    }

    @Override
    @Step("Seleccionar varios productos de cabecera de cama")
    public <T extends Actor> void performAs(T theActor) {

        String locateForProducts="div[id='gallery-layout-container'] > div:nth-child(%d) div[class*='button-modal']";
        List<WebElementFacade> productsElementsList= CabecerasPage.getAllBuyButtons(theActor);
        for (int i=0; i<products.size();i++){
            Product currentProduct=products.get(i);
            int productCurrentPosition=currentProduct.getPosition();
            By productSelector=By.cssSelector(String.format(locateForProducts,productCurrentPosition));
            Target elementProduct=Target.the("product selected for add to shopping cart")
                    .located(productSelector);
            Point coordinates = elementProduct.resolveFor(theActor).getCoordinates().onPage();
            int positionY=Math.abs(coordinates.y-140);
            BrowseTheWeb.as(theActor).evaluateJavascript(
                    String.format("window.scrollTo(%d, %d)",coordinates.x,positionY)
            );

            waitWithSleep(2);
            elementProduct.resolveFor(theActor).waitUntilEnabled().click();
            //
            Target summaryButton=Target.the("button to add to shopping cart").located(
                    By.cssSelector("div[class*='productSummaryBuyButtonProductDetail'] button")
            );
            waitWithSleep(1);
            summaryButton.resolveFor(theActor).waitUntilEnabled().click();
            waitWithSleep(1);
            for (int j=0;j<currentProduct.getAmount()-1;j++){
                Target addOneItem=Target.the("button to add a item from the product")
                        .located(By.cssSelector("button[class*='product-summary-add-to-car-plus']"));
                addOneItem.resolveFor(theActor).waitUntilEnabled().click();
            }
            waitWithSleep(1);
            Target linkToContinueBuying=Target.the("link to continue buying").located(By.cssSelector("p[class='exito-vtex-components-4-x-continue']"));
            linkToContinueBuying.resolveFor(theActor).waitUntilEnabled().click();
            waitWithSleep(1);

        }

    }

    private static void waitWithSleep(int timeInSeconds) {
        try {
            Thread.sleep(Duration.ofSeconds(timeInSeconds));
        } catch (InterruptedException e) {

        }
    }

    public static SelectSeveralProductsRandomlyTask selectSeveralProductsRandomlyTask(){
        return instrumented(SelectSeveralProductsRandomlyTask.class);
    }
}
