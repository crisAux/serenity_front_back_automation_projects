package co.com.certification.automation.tasks;

import co.com.certification.automation.exceptions.RepositoryAlreadyExistsError;
import co.com.certification.automation.exceptions.RepositoryModelCreationException;
import co.com.certification.automation.interactions.SelectDropDownButton;
import co.com.certification.automation.model.enumerables.GitIgnore;
import co.com.certification.automation.model.enumerables.License;
import co.com.certification.automation.userinterface.CreateNewRepositoryPageEliminar;
import co.com.certification.automation.userinterface.UserGitHubHomePageEliminar;
import co.com.certification.automation.util.builder.Builder;
import co.com.certification.automation.util.validations.Validations;
import co.com.certification.automation.model.Repository;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class CreateRepositoryEliminar implements Task {

    private final Repository repository;

    public CreateRepositoryEliminar(Repository repository) {
        this.repository = repository;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(UserGitHubHomePageEliminar.NEW_REPOSITORY),
                Enter.theValue(repository.name()).into(CreateNewRepositoryPageEliminar.REPOSITORY_NAME)
        );

        actor.should(GivenWhenThen.seeThat(WebElementQuestion.the(CreateNewRepositoryPageEliminar.MESSAGE_REPOSITORY_ALREADY_EXISTS), isNotVisible())
                .orComplainWith(RepositoryAlreadyExistsError.class,
                        RepositoryAlreadyExistsError.withMessageBy(repository.name())));

        actor.attemptsTo(
                Check.whether(Validations.isNotEmptyOrNull(repository.description()))
                        .andIfSo(Enter.theValue(repository.description()).into(CreateNewRepositoryPageEliminar.REPOSITORY_DESCRIPTION)),
                Check.whether(repository.isInitializeWithREADME())
                        .andIfSo(Click.on(CreateNewRepositoryPageEliminar.INITIALIZE_THIS_REPOSITORY_WITH_README)),
                Scroll.to(CreateNewRepositoryPageEliminar.CREATE_REPOSITORY),
                Check.whether(repository.gitIgnore() != GitIgnore.NONE)
                        .andIfSo(SelectDropDownButton.addGitIgnoreFilteringBy(repository.gitIgnore())),
                Check.whether(repository.license() != License.NONE)
                        .andIfSo(SelectDropDownButton.addLicenseFilteringBy(repository.license())),
                Click.on(CreateNewRepositoryPageEliminar.CREATE_REPOSITORY)
        );
    }

    public static CreateRepositoryEliminar withTheFollowingData(Builder<Repository> builder) throws RepositoryModelCreationException {
        return instrumented(CreateRepositoryEliminar.class, builder.build());
    }

}
