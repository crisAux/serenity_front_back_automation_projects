package co.com.certification.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class AddedProductsNameList implements Question<List<String>> {
    @Override
    public List<String> answeredBy(Actor actor) {
        return null;
    }

    public static Question<List<String>> listOfAddedProducts(){
        return new AddedProductsNameList();
    }
}
