package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenAccountPage extends common {

    private final By customerNameDDL = By.id("userSelect");
    private final By currencyDDL = By.xpath("//select[@id='currency']");
    private final By submitButton = By.xpath("//button[@type='submit']");

    public OpenAccountPage(WebDriver driver){
        super(driver);
    }

    public void clickCustomerSelect(){
        clickButton(customerNameDDL);
    }

    public void selectCustomer(String fullName){
        selectByVisibleText(customerNameDDL, fullName);
    }

    public void selectRandomCurrency(){
        selectRandomIndex(currencyDDL, 1, 3);
    }

    public void clickSubmit(){
        clickButton(submitButton);
    }

    public String readAlertMessage(){
        return getAlertText();
    }

    public void closeAlertPopUp(){
        closeAlert();
    }
}
