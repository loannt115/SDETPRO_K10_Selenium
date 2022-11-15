package models.components;

public class ExternalLoginPage extends LoginPage{
    @Override
    public String inputUsername(String username) {
        System.out.println("Input username with external login page");
        return null;
    }

    @Override
    public String inputPassword(String password) {
        System.out.println("Input password with external login page");
        return null;
    }

    @Override
    public String clickOnLoginBtn() {
        System.out.println("Click on Login button with external login page");
        return null;
    }
}
