package co.com.certification.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ProductsAmount implements Question<Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
        return null;
    }

    public static ProductsAmount getProductsTotalPrice(){
        return new ProductsAmount();
    }
}
