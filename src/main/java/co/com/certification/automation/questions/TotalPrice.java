package co.com.certification.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TotalPrice implements Question<Double> {
    @Override
    public Double answeredBy(Actor actor) {
        return null;
    }

    public static TotalPrice getProductsTotalPrice(){
        return new TotalPrice();
    }
}
