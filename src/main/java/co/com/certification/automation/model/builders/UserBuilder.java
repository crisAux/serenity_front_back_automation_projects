package co.com.certification.automation.model.builders;

import co.com.certification.automation.exceptions.UserModelCreationException;
import co.com.certification.automation.util.builder.Builder;
import co.com.certification.automation.model.User;

public class UserBuilder implements Builder<User> {

    private String username;
    private String password;

    private UserBuilder(String username) {
        this.username = username;
    }

    public User withPassword(String password) throws UserModelCreationException {
        this.password = password;
        return this.build();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public User build() throws UserModelCreationException {
        return new User(this);
    }

    public static UserBuilder theUser(String username){
        return new UserBuilder(username);
    }

}
