package utils;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.io.File;



public class BrowserSetup {

    public static WebDriver selectedDriver;
    public static WebDriver Driver;
    protected static final String browser = System.getProperty("sys.CucumberJVM-Selenium-main.browser");



    static String driverPath = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"drivers"+File.separator;
@Before
    public void iSelectTheBrowser(){
        System.out.println("========BROWSER=================\n"+                    browser);
        switch(browser){
            case "Chrome": selectedDriver=chromeDriver(); break;
            case "Firefox": selectedDriver=firefoxDriver();break;
            case "InternetExplorer": selectedDriver=internetExplorerDriver();break;
            case "Edge": selectedDriver=edgeDriver();break;
            default:
                System.out.println("Wrong Input");
        }
    }
    public static WebDriver chromeDriver(){
        System.out.println(driverPath);
        System.setProperty("webdriver.chrome.driver",driverPath+"chromedriver.exe");
        System.out.println("yayhaaaaaaaaa===================");
        Driver = new ChromeDriver();
        return Driver;
    }

    public static WebDriver firefoxDriver(){
        System.setProperty("webdriver.gecko.driver",driverPath+"geckodriver.exe");
        Driver = new FirefoxDriver();
        return Driver;
    }

    public static WebDriver internetExplorerDriver(){
        System.setProperty("webdriver.ie.driver",driverPath+"IEDriverServer.exe");
        InternetExplorerOptions options = new InternetExplorerOptions().introduceFlakinessByIgnoringSecurityDomains();
        Driver = new InternetExplorerDriver(options);
        return Driver;
    }

    public static WebDriver edgeDriver(){
        System.setProperty("webdriver.edge.driver",driverPath+"msedgedriver.exe");
        Driver = new EdgeDriver();
        return Driver;
    }


    @After("@guru99")
    public void AfterHook(){
        selectedDriver.quit();
    }

}
