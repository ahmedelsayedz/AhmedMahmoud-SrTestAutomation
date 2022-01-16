package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends common{

    private final WebDriver driver;
    private final By bankingLink = By.xpath("//h2[contains(., 'Banking')]");

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public BankPage clickBankLink(){
        clickButton(bankingLink);
        return new BankPage(driver);
    }

//    public LoginPage clickFormAuthentication(){
//        clickLink("Form Authentication");
//        return new LoginPage(driver);
//    }
//
//    public DropdownPage clickDropDown(){
//        clickLink("Dropdown");
//        return new DropdownPage(driver);
//    }
//
//    public HoversPage clickHovers(){
//        clickLink("Hovers");
//        return new HoversPage(driver);
//    }
//
//    public KeyPressesPage clickKeyPresses(){
//        clickLink("Key Presses");
//        return new KeyPressesPage(driver);
//    }
//
//    public AlertsPage clickJavaScriptAlerts(){
//        clickLink("JavaScript Alerts");
//        return new AlertsPage(driver);
//    }
//
//    public FileUploadPage clickFileUpload(){
//        clickLink("File Upload");
//        return new FileUploadPage(driver);
//    }
//
//    public WysiwygEditorPage clickWysiwygEditor(){
//        clickLink("WYSIWYG Editor");
//        return new WysiwygEditorPage(driver);
//    }
//
//    public LargeAndDeepDomPage clickLargeAndDeepDom(){
//        clickLink("Large & Deep DOM");
//        return new LargeAndDeepDomPage(driver);
//    }
//
//    public InfiniteScrollPage clickInfiniteScroll(){
//        clickLink("Infinite Scroll");
//        return new InfiniteScrollPage(driver);
//    }
//
//    public DynamicLoadingPage clickDynamicLoading(){
//        clickLink("Dynamic Loading");
//        return new DynamicLoadingPage(driver);
//    }
//
//    public MultipleWindowsPage clickMultipleWindows(){
//        clickLink("Multiple Windows");
//        return new MultipleWindowsPage(driver);
//    }
//
//    private void clickLink(String linkText){
//        driver.findElement(By.linkText(linkText)).click();
//    }
//
//    /*=====================================
//       METHODS FOR INDIVIDUAL EXERCISES
//     ======================================*/
//
//    public ForgotPasswordPage clickForgotPassword(){
//        clickLink("Forgot Password");
//        return new ForgotPasswordPage(driver);
//    }
//
//    public HorizontalSliderPage clickHorizonalSlider(){
//        clickLink("Horizontal Slider");
//        return new HorizontalSliderPage(driver);
//    }
//
//    public ContextMenuPage clickContextMenu(){
//        clickLink("Context Menu");
//        return new ContextMenuPage(driver);
//    }
//
//    public FramesPage clickFramesPage(){
//        clickLink("Frames");
//        return new FramesPage(driver);
//    }




}