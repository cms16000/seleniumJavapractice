package Actions;

import PageObjects.PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;


public class Setup {
    public ActionsHolder actions;
    private Assert asserts;

    public WebDriver driver;

    public PageObjects pageObjects;
    public Setup() {

    }

    @BeforeTest
    public void startEngine(){
        driver = setupDriver("chrome", "https://www.gm.com");
        pageObjects = PageFactory.initElements(driver, PageObjects.class);
    }

    @AfterTest
    public void closeEngine(){
        this.driver.close();
    }

    public WebDriver setupDriver(String driverType, String url){
        if(driverType.equals("chrome")){
            driver = new ChromeDriver();
        }
        if(driverType.equals("firefox")){
            driver = new FirefoxDriver();
        }
        if(driverType.equals("edge")){
            driver = new EdgeDriver();
        }
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeClass
    public void beforeClass(ITestContext context){
        actions = new ActionsHolder(asserts);
        actions.Initialize();
    }



}
