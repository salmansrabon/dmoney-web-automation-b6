import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class LoginTestRunner extends Setup {
    @Test
    public void doLogin() throws IOException, ParseException, InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        JSONObject userObj= Utils.readJSONList("./src/test/resources/users.json",0);
        String email= userObj.get("email").toString();
        String password= userObj.get("password").toString();
        loginPage.doLogin(email,password);
        Utils.waitForElement(driver,By.cssSelector(".nav-item.dropdown.notifications"),50);
        String currentUrl=driver.getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.contains("user-list"));
    }
}
