package co.com.certification.automation.util.resources;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class LoginManager {
    private LoginManager() {
        loadCredentials();
    }

    public static LoginManager instance;

    public static LoginManager getInstance(){
        if(instance==null){
            return new LoginManager();
        }
        else {
            return instance;
        }
    }
    private static final String CONFIG_FILE = "src/main/resources/config.properties";
    private String username;
    private String password;
    public void loadCredentials() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE)) {
            properties.load(fileInputStream);
            username = properties.getProperty("username_exito");
            password = properties.getProperty("password_exito");
        } catch (IOException e) {
            username = "USER_DEFAULT";
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}