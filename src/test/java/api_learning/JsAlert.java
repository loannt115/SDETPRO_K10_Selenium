package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

public class JsAlert implements Urls {

    private final static By jsAlertSel = By.cssSelector("button[onclick=\"jsAlert()\"]");
    private final static By jsConfirmSel = By.cssSelector("button[onclick=\"jsConfirm()\"]");
    private final static By jsPromptSel = By.cssSelector("button[onclick=\"jsPrompt()\"]");
    private final static By resultSel = By.cssSelector("#result");

    public static void main (String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            //Navigate to the target page
            driver.get(BASE_URL.concat(JS_ALERTS_SLUG));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
            boolean isAcceptedAlert = true;

            //JS Alert | OK
            WebElement triggerJsAlertBtnElem = driver.findElement(jsAlertSel);
            handleAlert(wait, triggerJsAlertBtnElem, true);
            System.out.println("Result: " + (driver.findElement(resultSel).getText()));

            //JS Confirm | Cancel
            WebElement triggerJsConfirmBtnElem = driver.findElement(jsConfirmSel);
            handleAlert(wait, triggerJsConfirmBtnElem, false);
            System.out.println("Result: " + (driver.findElement(resultSel).getText()));

            //JS Prompt | Input text then accept
            WebElement triggerJsPromptBtnElem = driver.findElement(jsPromptSel);
            handleAlert(wait, triggerJsPromptBtnElem, "test");
            System.out.println("Result: " + (driver.findElement(resultSel).getText()));


        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }

    private static void handleAlert(WebDriverWait wait, WebElement alertElem, boolean isAccept){
        alertElem.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        if (isAccept) alert.accept();
        else alert.dismiss();
    }

    private static void handleAlert(WebDriverWait wait, WebElement alertElem, String inputStr){
        alertElem.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(inputStr);
        alert.accept();
    }
}
