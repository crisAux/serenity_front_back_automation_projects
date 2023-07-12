package co.com.certification.automation.questions;

import co.com.certification.automation.userinterface.*;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddedProductsPriceList implements Question<List<Double>> {
    @Override
    public List<Double> answeredBy(Actor theActor) {
        List<WebElementFacade> elementsProductsPriceList= ShoppingCartPage.LIST_OF_PRODUCTS_PRICE_IN_SHOPPING_CART.resolveAllFor(theActor);
        List<Double> productsPriceList=new ArrayList<>();
        for (WebElementFacade elementProduct:elementsProductsPriceList) {
            productsPriceList.add(Double.parseDouble(elementProduct.getText().replace("$ ","").replace(".","")));
        }
        Collections.sort(productsPriceList);
        return productsPriceList;
    }

    public static Question<List<Double>> listOfAddedProducts(){
        return new AddedProductsPriceList();
    }
}
