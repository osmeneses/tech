package automation_workshop.query_page_objects;

import automation_workshop.DriverBase;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public abstract class BasePage {
     protected RemoteWebDriver driver;

     public BasePage(){
         try {
             driver = DriverBase.getDriver();
         } catch (Exception ignored){
             //This will be thrown when the test starts
             //if it cannot connect to a RemoteWebDriver
         }
     }
}
