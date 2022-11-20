package models.pages;

import models.components.Component;
import models.components.PageFooterComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage extends Component {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        super(driver, driver.findElement(By.tagName("html")));
        this.driver = driver;
    }

    public PageFooterComponent footerComp(){
        return findComponent(PageFooterComponent.class, driver);
    }
}
