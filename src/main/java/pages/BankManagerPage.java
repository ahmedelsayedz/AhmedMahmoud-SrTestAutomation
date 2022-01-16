package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankManagerPage extends common{

    private final WebDriver driver;
    private final By addCustomerBtn = By.xpath("//div[@class='center']//button[contains(., 'Add Customer')]");
    private final By openAccountBtn = By.xpath("//div[@class='center']//button[contains(., 'Open Account')]");
    private final By addCustomersBtn = By.xpath("//div[@class='center']//button[contains(., 'Customers')]");

    public BankManagerPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public AddCustomerPage clickAddCustomerBtn(){
        clickButton(addCustomerBtn);
        return new AddCustomerPage(driver);
    }

    public OpenAccountPage clickOpenAccountBtn(){
        clickButton(openAccountBtn);
        return new OpenAccountPage(driver);
    }

    public CustomersPage clickCustomerBtn() {
        clickButton(addCustomersBtn);
        return new CustomersPage(driver);
    }
}
