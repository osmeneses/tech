package automation_workshop.config;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static automation_workshop.config.DriverType.*;


public class DriverFactory {
    private RemoteWebDriver webDriver;
    private DriverType selectedDriverType;
    private final String operatingSystem = System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture = System.getProperty("os.arch");

    public DriverFactory(){
        DriverType driverType = CHROME;
        String browser = System.getProperty("browser",driverType.toString().toUpperCase());
        System.out.println("Driver Factory - el browser encontrado en el xml fue:"+browser);
        System.out.println("Driver Factory - el VALOR QUE NO PROCESA ES:"+valueOf(browser));

        try{
            driverType = valueOf(browser);
            System.out.println("Driver Factory - el browser asignado fue:"+driverType);
        }
        catch(IllegalArgumentException ignored){
            System.err.println("Unknown driver specified, defaulting to ' " + driverType + "'...");
        }
        catch(NullPointerException ignored){
            System.err.println("No driver specified, defaulting to ' " + driverType + "'...");
        }
        selectedDriverType = driverType;

    }

    public RemoteWebDriver getDriver(){
        if (null == webDriver){
            instantiateWebDriver(selectedDriverType);
            System.out.println("Current thread: "+ Thread.currentThread().getId());
        }
        return  webDriver;
    }

    public void quitDriver(){
        if (null != webDriver){
            webDriver.quit();
            webDriver = null;
        }
    }

    private void instantiateWebDriver(DriverType driverType){
        System.out.println("Selected Browser: "+ selectedDriverType);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        webDriver = driverType.getWebDriverObject(desiredCapabilities);
    }
}
