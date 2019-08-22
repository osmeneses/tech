package automation_workshop.query_page_objects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;


public class Home extends BasePage{


        public String getBannerText() {
        return bannerLoginSuccessfully.findWebElement().getText();
    }

        public Boolean bannerTextIsVisible() {
            try {
                return bannerLoginSuccessfully.findWebElement().isDisplayed();
            } catch (Exception e) {
                return false;
            }
        }

        public NewEmployee openNewEmployeePage() {
            createNewEmployeeButton.findWebElement().click();
            return new NewEmployee();
        }

        private Query bannerLoginSuccessfully = new Query (By.cssSelector("#content > p.flash_notice"),driver);
        private Query createNewEmployeeButton = new Query (By.cssSelector("#content > p:nth-child(5) > a"),driver);
}
