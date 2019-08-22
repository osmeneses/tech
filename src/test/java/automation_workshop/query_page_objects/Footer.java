package automation_workshop.query_page_objects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;



public class Footer extends BasePage{

    public String getGAPLinkText() {
        return goToGAPLink.findWebElement().getText();
    }

    public void clickOnGAPLink() {
        goToGAPLink.findWebElement().click();
    }

    public String getW3Validator() {
        return goToW3Validator.findWebElement().getText();
    }

    public void clickOnHTML5Link() {
        goToW3Validator.findWebElement().click();
    }

    private Query goToGAPLink = new Query (By.cssSelector("#footer > p > a:nth-child(1)"),driver);
    private Query goToW3Validator = new Query (By.cssSelector("#footer > p > a:nth-child(2)"),driver);

}
