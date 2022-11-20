package tests;

import driver.DriverFactory;
import models.components.LoginFormComponent;
import models.pages.HerokuLoginPage;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginPageTest implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(BASE_URL.concat(LOGIN_FORM_SLUG));

            HerokuLoginPage loginPage = new HerokuLoginPage(driver);
            System.out.println(loginPage.footerComp().getLinkText());

            LoginFormComponent loginFormComp = loginPage.loginFormComp();
            loginFormComp.usernameElem().sendKeys("test");

            Thread.sleep(2000);

        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
