package co.com.certification.automation.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class RepositoryPageEliminar {
    public static final Target REPOSITORY_NAME = Target.the("repository name")
            .locatedBy("//*[@id=\"js-repo-pjax-container\"]//strong[@itemprop='name']/a");
}
