import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPage {
    @FindBy(name = "username")
    WebElement txtEmail;
    @FindBy(css = "[type=password]")
    WebElement txtPassword;
    @FindBy(css = "[type=submit]")
    WebElement btnLogin;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void doLogin(String email, String password) throws IOException, ParseException, InterruptedException {
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        Thread.sleep(1000);
        btnLogin.click();
    }
}
