import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class Utils {
    public static JSONObject readJSONList(String file, int index) throws IOException, ParseException {
        JSONParser parser=new JSONParser();
        JSONArray jsonArray= (JSONArray) parser.parse(new FileReader(file));
        JSONObject jsonObject= (JSONObject) jsonArray.get(index);
        return jsonObject;
    }
    public static void waitForElement(WebDriver driver, By by, int timeouts){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeouts));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }
}
