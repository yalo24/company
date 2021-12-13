import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private String login ="olgarizkovic@gmail.com";
    private String password ="kalendar";

    LoginPage(WebDriver driver){
        super(driver);
    }
    public String getLogin(){
        return login;
    }
    public String getPassword() {
        return password;
    }
}
