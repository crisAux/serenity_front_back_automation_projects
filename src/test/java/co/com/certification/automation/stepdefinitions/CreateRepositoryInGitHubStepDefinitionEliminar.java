package co.com.certification.automation.stepdefinitions;

import co.com.certification.automation.model.enumerables.GitIgnore;
import co.com.certification.automation.model.enumerables.License;
import co.com.certification.automation.questions.TheCurrent;
import co.com.certification.automation.questions.TheRepository;
import co.com.certification.automation.tasks.CreateRepositoryEliminar;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.certification.automation.model.builders.RepositoryBuilder.name;
import static co.com.certification.automation.model.builders.UserBuilder.theUser;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.Is.is;

public class CreateRepositoryInGitHubStepDefinitionEliminar {

    private static final String CESAR = "Cesar";
    private static final String GITHUB_USER = System.getProperty("github-user");
    private static final String SECRET = System.getProperty("password");
    private static final String OPERA = "opera";
    public static final String REPOSITORY_NAME = "TEST_BDD";
    private static final String BASE_URL_OF_REPOSITORY_CREATED = String.format("https://github.com/%s/%s", GITHUB_USER, REPOSITORY_NAME);

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        verifyIfDriverIsOpera();
    }

    private void verifyIfDriverIsOpera() {
        /*
        if(OPERA.equals(System.getProperty("context"))){
            OperaOptions operaOptions = new OperaOptions();
            operaOptions.setBinary(System.getProperty("binary"));
            BrowseTheWeb.as(theActorCalled(CESAR)).setDriver(new OperaDriver(operaOptions));
        }

         */
    }

    @Given("^Cesar wants to start versioning$")
    public void startVersioning() {

    }

    @When("^Cesar creates a repository$")
    public void createRepository() {
        theActorInTheSpotlight().attemptsTo(
                CreateRepositoryEliminar.withTheFollowingData(
                        name(REPOSITORY_NAME)
                        .description("repository for bdd tests")
                        .initializeWithREADME()
                        .gitIgnore(GitIgnore.JAVA)
                        .license(License.MIT)
                )
        );
    }

    @Then("^Cesar should see the repository created$")
    public void shouldSeeTheRepositorioCreated() {
        theActorInTheSpotlight().should(
                seeThat(TheRepository.name(), is(REPOSITORY_NAME))
        );
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                TheCurrent.url(), is(BASE_URL_OF_REPOSITORY_CREATED))
        );
    }

}