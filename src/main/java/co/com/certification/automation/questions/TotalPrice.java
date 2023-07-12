package co.com.certification.automation.questions;

import co.com.certification.automation.userinterface.ShoppingCartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TotalPrice implements Question<Double> {
    @Override
    public Double answeredBy(Actor theActor) {
        return Double.parseDouble(
                ShoppingCartPage.ELEMENT_WITH_TOTAL_PRICE.resolveFor(theActor).getText()
        );
    }

    public static TotalPrice getProductsTotalPrice(){
        return new TotalPrice();
    }
}
