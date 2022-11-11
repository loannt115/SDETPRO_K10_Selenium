package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import support.ui.SelectEx;
import url.Urls;

public class DropDown {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            //Navigate to the dropdown page
            driver.get(Urls.BASE_URL.concat(Urls.DROPDOWN_SLUG));

            //Locate the select tag/dropdown
            WebElement dropdownElem = driver.findElement(By.cssSelector("#dropdown"));
            SelectEx select = new SelectEx(dropdownElem);
            Thread.sleep(1000);

            //Select by visible text
            select.selectByVisibleText("Option 2");
            Thread.sleep(1000);

            //select.selectOption1();
            select.selectOption01();
            Thread.sleep(1000);

            //Select by index
            select.selectByIndex(2);
            Thread.sleep(1000);

            //Select by value
            select.selectByValue("1");

            //Debug only
            Thread.sleep(2000);
        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
