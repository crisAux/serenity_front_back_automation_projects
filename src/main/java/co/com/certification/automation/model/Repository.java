package co.com.certification.automation.model;

import co.com.certification.automation.exceptions.RepositoryModelCreationException;
import co.com.certification.automation.model.builders.RepositoryBuilder;
import co.com.certification.automation.model.enumerables.GitIgnore;
import co.com.certification.automation.model.enumerables.License;
import co.com.certification.automation.util.validations.Validations;

public class Repository {

    private final String name;
    private final String description;
    private final boolean initializeWithREADME;
    private final GitIgnore gitIgnore;
    private final License license;

    public Repository(RepositoryBuilder builder) throws RepositoryModelCreationException {
        name = builder.getName();
        description = builder.getDescription();
        initializeWithREADME = builder.isInitializeWithREADME();
        gitIgnore = builder.getGitIgnore();
        license = builder.getLicense();
        isValid();
    }

    private void isValid() throws RepositoryModelCreationException {
        if (Validations.isEmptyOrNull(this.name)) {
            throw new RepositoryModelCreationException("The repository does not contain a name");
        }
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public boolean isInitializeWithREADME() {
        return initializeWithREADME;
    }

    public GitIgnore gitIgnore() {
        return gitIgnore;
    }

    public License license() {
        return license;
    }
}
