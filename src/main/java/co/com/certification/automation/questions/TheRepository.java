package co.com.certification.automation.questions;

import co.com.certification.automation.userinterface.RepositoryPageEliminar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("the name of the repository")
public class TheRepository implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return RepositoryPageEliminar.REPOSITORY_NAME.resolveFor(actor).getText();
    }

    public static TheRepository name() {
        return new TheRepository();
    }
}