package co.com.certification.automation.questions;

import co.com.certification.automation.userinterface.*;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddedProductsNameList implements Question<List<String>> {
    @Override
    public List<String> answeredBy(Actor theActor) {
        List<WebElementFacade> elementsProductsAmountList= ShoppingCartPage.LIST_OF_PRODUCTS_NAME_IN_SHOPPING_CART.resolveAllFor(theActor);
        List<String> productsNameList=new ArrayList<>();
        for (WebElementFacade elementProduct:elementsProductsAmountList) {
            productsNameList.add(elementProduct.getText());
        }
        Collections.sort(productsNameList);
        return productsNameList;
    }

    public static Question<List<String>> listOfAddedProducts(){
        return new AddedProductsNameList();
    }
}
