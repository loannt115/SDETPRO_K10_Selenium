package models.components;

public class InternalLoginPage extends LoginPage{
    @Override
    public String inputUsername(String username) {
        System.out.println("Input username with internal login page");
        return null;
    }

    @Override
    public String inputPassword(String password) {
        System.out.println("Input password with internal login page");
        return null;
    }

    @Override
    public String clickOnLoginBtn() {
        System.out.println("Click on Login button with internal login page");
        return null;
    }
}
