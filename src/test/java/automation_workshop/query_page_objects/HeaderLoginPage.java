package automation_workshop.query_page_objects;
import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;


public class HeaderLoginPage extends BasePage{

    public Boolean siteLogoIsVisible() {
        try {
            return siteLogo.findWebElement().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private Query siteLogo = new Query (By.cssSelector("div#logo"),driver);

}
