package automation_workshop.query_page_objects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;



public class Login extends BasePage{

    public Home logInAction(String suserEmail, String password) {
        userEmail.findWebElement().sendKeys(suserEmail);
        userPassword.findWebElement().sendKeys(password);
        signInButton.findWebElement().click();
        return new Home();
    }

    public void toggleOnOffCheckBox() {
        userRememberMeCheckBox.findWebElement().click();
    }

    public void goToForgotPasswordPage() {
        forgotPasswordButton.findWebElement().click();
        /* Here we can add this line:  return ForgotPassword();
           For now it is out of this test's scope*/
    }

    private Query userEmail = new Query (By.id("user_email"),driver);
    private Query userPassword = new Query (By.id("user_password"),driver);
    private Query userRememberMeCheckBox = new Query (By.id("user_remember_me"),driver);
    private Query signInButton = new Query (By.cssSelector("input.submit"),driver);
    private Query forgotPasswordButton = new Query (By.xpath("//*[@id='new_user']/div[3]/a"),driver);
}
