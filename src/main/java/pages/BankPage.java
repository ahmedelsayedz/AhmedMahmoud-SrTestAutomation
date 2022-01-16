package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankPage extends common{
    private final WebDriver driver;
    private final By bankLoginBtn = By.xpath("//button[contains(., 'Bank Manager Login')]");

    public BankPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public BankManagerPage clickBankbtn(){
        clickButton(bankLoginBtn);
        return new BankManagerPage(driver);
    }
}
