package models.components;

public abstract class LoginPage {
    protected abstract String inputUsername(String username);
    protected abstract String inputPassword(String password);
    protected abstract String clickOnLoginBtn();

    public void login(String username, String password){
        inputUsername(username);
        inputPassword(password);
        clickOnLoginBtn();
    }
}
