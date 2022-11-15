package api_learning;

import com.sun.net.httpserver.BasicAuthenticator;
import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;
import java.util.Base64;

public class BasicAuth implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            String username = "admin";
            String password = "admin";
            driver.get("https://" + username + ":" + password + "@the-internet.herokuapp.com".concat(BASIC_AUTH_SLUG));
            Thread.sleep(2000);

            WebElement contentElem = driver.findElement(By.cssSelector(".example p"));
            System.out.println("Content: " + contentElem.getText());
        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
