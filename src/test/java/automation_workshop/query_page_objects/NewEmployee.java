package automation_workshop.query_page_objects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class NewEmployee extends BasePage{


        public void fillOutEmployeeData(String firstName, String lastName, String email, String employeeId, String sEmployeeLiderName, String startWorkingYear, String startWorkingMonth, String startWorkingDay) {
            employeeFirstName.findWebElement().sendKeys(firstName);
            employeeLastName.findWebElement().sendKeys(lastName);
            employeeEmail.findWebElement().sendKeys(email);
            employeeIdentification.findWebElement().sendKeys(employeeId);
            employeeLiderName.findWebElement().sendKeys(sEmployeeLiderName);

            Select selectListYear = new Select(employeeStartWorkingYearSelector.findWebElement());
            selectListYear.selectByVisibleText(startWorkingYear);

            Select selectListMonth = new Select(employeeStartWorkingMonthSelector.findWebElement());
            selectListMonth.selectByVisibleText(startWorkingMonth);

            Select selectListDay = new Select(employeeStartWorkingDaySelector.findWebElement());
            selectListDay.selectByVisibleText(startWorkingDay);
    }

    public void submitForm(){
        createEmployeeButton.findWebElement().click();
    }


//        public NewEmployee openNewEmployeePage() {
//            createNewEmployeeButton.click();
//            return new NewEmployee();
//        }

    private Query employeeFirstName = new Query (By.cssSelector("input#employee_first_name"),driver);
    private Query employeeLastName = new Query (By.cssSelector("input#employee_last_name"),driver);
    private Query employeeEmail = new Query (By.cssSelector("input#employee_email"),driver);
    private Query employeeIdentification = new Query (By.cssSelector("input#employee_identification"),driver);
    private Query employeeLiderName = new Query (By.cssSelector("input#employee_leader_name"),driver);
    private Query employeeStartWorkingYearSelector = new Query (By.cssSelector("select#employee_start_working_on_1i"),driver);
    private Query employeeStartWorkingMonthSelector = new Query (By.cssSelector("select#employee_start_working_on_2i"),driver);
    private Query employeeStartWorkingDaySelector = new Query (By.cssSelector("select#employee_start_working_on_3i"),driver);
    private Query createEmployeeButton = new Query (By.cssSelector("input[type=submit]"),driver);
}
