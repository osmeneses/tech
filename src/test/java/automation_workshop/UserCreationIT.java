package automation_workshop;

import automation_workshop.query_page_objects.*;
import data.Constant;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.net.MalformedURLException;

public class UserCreationIT extends DriverBase {

   private WebDriver driver;

   @BeforeMethod
    public void setup() throws MalformedURLException{
        driver =  DriverBase.getDriver();
   }

    @Test
    public void userCreatedSuccessfully(){
        driver.get(Constant.URL);
        Login login = new Login();
        Home homePage = new Home();
        NewEmployee newEmployee = new NewEmployee();
        UserList userList  = new UserList();
        HeaderWithMenu headerWithMenu  = new HeaderWithMenu();
        login.logInAction(Constant.USER_EMAIL, Constant.USER_PASSWORD);
        homePage.openNewEmployeePage();
        newEmployee.fillOutEmployeeData(Constant.FIRST_NAME, Constant.LAST_NAME, Constant.EMPLOYEE_EMAIL, Constant.EMPLOYEE_IDENTIFICATION, Constant.EMPLOYEE_LIDER_NAME, Constant.START_WORKING_YEAR, Constant.START_WORKING_MONTH, Constant.START_WORKING_DAY);
        newEmployee.submitForm();
        headerWithMenu.clickOnEmployeesInfoTab();
        Assert.assertTrue(userList.getUserNameCreated().contains(Constant.EMPLOYEE_LIDER_NAME));
    }
}
