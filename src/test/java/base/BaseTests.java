package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.HomePage;
import utils.WindowManager;

import java.time.Duration;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://www.way2automation.com/protractor-angularjs-practice-website.html");
        homePage = new HomePage(driver);
    }

    @AfterSuite
    public void tearDown(){
        if (driver!= null)
            driver.quit();
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

}
