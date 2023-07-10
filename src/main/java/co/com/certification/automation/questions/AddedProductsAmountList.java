package co.com.certification.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class AddedProductsAmountList implements Question<List<Integer>> {
    @Override
    public List<Integer> answeredBy(Actor actor) {
        return null;
    }

    public static Question<List<Integer>> listOfAddedProducts(){
        return new AddedProductsAmountList();
    }
}
