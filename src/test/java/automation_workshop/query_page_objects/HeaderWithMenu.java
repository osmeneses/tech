package automation_workshop.query_page_objects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;


public class HeaderWithMenu extends HeaderLoginPage{

    public UserList clickOnEmployeesInfoTab() {
        employeesInfoTab.findWebElement().click();
        return new UserList();
    }

    public void clickOnAdministrativeUsersTab() {
        administrativeUsersTab.findWebElement().click();
    }

    public void clickOnMyAcoountTab() {
        myAccountTab.findWebElement().click();
    }

    public String getElementLoggedInUserText() {
        return elementLoggedInUser.findWebElement().getText();
    }


    public Login clickLogoutButton() {
        logoutbutton.findWebElement().click();
        return new Login();
    }

    private Query elementLoggedInUser = new Query (By.cssSelector("ul#user_information"),driver);
    private Query logoutbutton = new Query (By.cssSelector("#user_information > span > a"),driver);
    private Query employeesInfoTab = new Query (By.cssSelector("#menu > li > a[href='/employees"),driver);
    private Query administrativeUsersTab = new Query (By.cssSelector("#menu > li > a[href='/users']"),driver);
    private Query myAccountTab = new Query (By.cssSelector("#menu > li > a[href='/my_account']"),driver);

}
