package automation_workshop.query_page_objects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;


public class UserList extends Home{

        public String getHeadingText() {
            return heading.findWebElement().getText();
        }

        public String getUserNameCreated() {
            return userNameCreated.findWebElement().getText();
        }

        private Query heading = new Query (By.cssSelector("#content > h1"),driver);
        private Query userNameCreated = new Query (By.xpath("//td[text()='OSM']"),driver);
}



