package co.com.certification.automation.questions;

import co.com.certification.automation.userinterface.*;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddedProductsAmountList implements Question<List<Integer>> {
    @Override
    public List<Integer> answeredBy(Actor theActor) {
       List<WebElementFacade> elementsProductsAmountList= ShoppingCartPage.LIST_OF_PRODUCTS_AMOUNT_IN_SHOPPING_CART.resolveAllFor(theActor);
       List<Integer> productsAmountList=new ArrayList<>();
        for (WebElementFacade elementProduct:elementsProductsAmountList) {
            productsAmountList.add(Integer.parseInt(elementProduct.getText()));
        }
        Collections.sort(productsAmountList);
        return productsAmountList;
    }

    public static Question<List<Integer>> listOfAddedProducts(){
        return new AddedProductsAmountList();
    }
}
