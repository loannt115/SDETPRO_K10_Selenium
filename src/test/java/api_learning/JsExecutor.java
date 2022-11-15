package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.*;
import url.Urls;

public class JsExecutor implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(BASE_URL.concat(FLOATING_MENUS_SLUG));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            PageHelper pageHelper = new PageHelper(jsExecutor);

            //Scroll to bottom
            pageHelper.scrollToBottom();

            Thread.sleep(2000);

            //Scroll to top
            pageHelper.scrollToTop();

            Thread.sleep(2000);

            //Go to dynamic control page
            driver.get(BASE_URL.concat(DYNAMIC_CONTROL_SLUG));
            By checkboxFormSel = By.id("checkbox-example");
            By inputFormSel = By.cssSelector("#input-example");
            WebElement checkboxFormElem = driver.findElement(checkboxFormSel);
            WebElement inputFormElem = driver.findElement(inputFormSel);
            pageHelper.removeElement(inputFormElem);
            pageHelper.changeElemStyleToFocusMode(checkboxFormElem);

            Thread.sleep(5000);
        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }

}
