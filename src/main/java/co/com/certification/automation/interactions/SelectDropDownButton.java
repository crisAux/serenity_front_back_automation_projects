package co.com.certification.automation.interactions;

import co.com.certification.automation.model.enumerables.GitIgnore;
import co.com.certification.automation.model.enumerables.License;
import co.com.certification.automation.userinterface.CreateNewRepositoryPageEliminar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

import java.util.concurrent.Callable;

import static java.util.concurrent.TimeUnit.SECONDS;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.awaitility.Awaitility.await;

public class SelectDropDownButton implements Interaction {

    private final Target button;
    private final Target filter;
    private final String valueFilter;
    private final String cssSelectorForElementSelected;

    public SelectDropDownButton(Target button, Target filter, String valueFilter, String selectorForElementSelected) {
        this.valueFilter = valueFilter;
        this.button = button;
        this.filter = filter;
        this.cssSelectorForElementSelected = selectorForElementSelected;
    }

    public static SelectDropDownButton addGitIgnoreFilteringBy(GitIgnore valueFilter) {
        return instrumented(SelectDropDownButton.class, CreateNewRepositoryPageEliminar.ADD_GITIGNORE,
                CreateNewRepositoryPageEliminar.FILTER_GITIGNORE, valueFilter.toString(),
                String.format(CreateNewRepositoryPageEliminar.SELECTOR_FORMAT_GITIGNORE, valueFilter));
    }

    public static SelectDropDownButton addLicenseFilteringBy(License valueFilter) {
        return instrumented(SelectDropDownButton.class, CreateNewRepositoryPageEliminar.ADD_LICENSE,
                CreateNewRepositoryPageEliminar.FILTER_LICENSE, valueFilter.toString(),
                String.format(CreateNewRepositoryPageEliminar.SELECTOR_FORMAT_LICENSE, valueFilter));
    }

    @Override
    @Step("{0} clicks on #button is filtered by #valueFilter and click on the resulting item")
    public <T extends Actor> void performAs(T actor) {
        button.resolveFor(actor).click();
        filter.resolveFor(actor).sendKeys(valueFilter);
        Target selectedItem = Target.the("selected item").locatedBy(cssSelectorForElementSelected);
        await().forever().pollInterval(1, SECONDS).until(isNotNull(selectedItem.resolveFor(actor)));
        selectedItem.resolveFor(actor).click();
    }

    private Callable<Boolean> isNotNull(WebElement element) {
        return () -> element != null;
    }
}
