package tests;

import driver.DriverFactory;
import models.pages.LoginPageMod02;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginMod02Test implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(BASE_URL.concat(LOGIN_FORM_SLUG));

            LoginPageMod02 loginPage = new LoginPageMod02(driver);
            loginPage.inputUsername("test");
            loginPage.inputPassword("12345678");
            loginPage.clickOnLoginBtn();

            Thread.sleep(2000);

        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }

}
