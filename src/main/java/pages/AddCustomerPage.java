package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomerPage extends common {

    private final WebDriver driver;
    private final By firstNameField = By.xpath("//input[@placeholder='First Name']");
    private final By lastNameField = By.xpath("//input[@placeholder='Last Name']");
    private final By postCodeField = By.xpath("//input[@placeholder='Post Code']");
    private final By addCustomerBtn = By.xpath("//button[@class='btn btn-default']");

    private final By customerBtn = By.xpath("//div[@class='center']//button[contains(., 'Customers')]");

    public AddCustomerPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void fillAllData(String firstName, String lastName, String postCode){
        setTextElementText(firstNameField, firstName);
        setTextElementText(lastNameField, lastName);
        setTextElementText(postCodeField, postCode);
        clickButton(addCustomerBtn);
    }

    public String getAlertMessage() {
        return getAlertText();
    }

    public void closeAlertPopUp(){
        closeAlert();
    }

    public CustomersPage clickCustomersBtn(){
        clickButton(customerBtn);
        return new CustomersPage(driver);
    }
}
