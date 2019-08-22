package automation_workshop;

import automation_workshop.query_page_objects.HeaderWithMenu;
import automation_workshop.query_page_objects.Home;
import automation_workshop.query_page_objects.Login;
import automation_workshop.query_page_objects.NewEmployee;
import data.Constant;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class UserLoginIT extends DriverBase {

   private WebDriver driver;

   @BeforeMethod
    public void setup() throws MalformedURLException{
        driver =  DriverBase.getDriver();
   }

    @Test
    public void userlogInSuccessfully(){
        driver.get(Constant.URL);
        Login login = new Login();
        HeaderWithMenu headerWithMenu  = new HeaderWithMenu();
        Home homePage = new Home();
        login.logInAction(Constant.USER_EMAIL, Constant.USER_PASSWORD);
        Assert.assertTrue(headerWithMenu.siteLogoIsVisible());
        Assert.assertTrue(headerWithMenu.getElementLoggedInUserText().contains("Welcome"));
        Assert.assertTrue(homePage.bannerTextIsVisible());
        Assert.assertEquals("Signed in successfully.",homePage.getBannerText());
    }

}
