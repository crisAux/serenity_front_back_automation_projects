package co.com.certification.automation.model;

import co.com.certification.automation.exceptions.UserModelCreationException;
import co.com.certification.automation.model.builders.UserBuilder;
import co.com.certification.automation.util.validations.Validations;

public class User {

    private final String username;
    private final String password;

    public User(UserBuilder builder) {
        this.username = builder.getUsername();
        this.password = builder.getPassword();
        isValid();
    }

    private void isValid(){
        if(Validations.isEmptyOrNull(username) || Validations.isEmptyOrNull(password)){
            throw new UserModelCreationException(
                    String.format("Invalid username (%s) or password (%s)", username, password));
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}