package base;

import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.*;

public class BankManagerTest extends BaseTests {
    @Test
    public void testAddNewCustomer() {
        /**
         * 1. Go to this URL
         * 2. Click on Banking link under "AngularJS Elements" List
         * 3. Click on Bank Manager Login
         * 4. Click on Add Customer
         * 5. Fill all fields and submit
         * 6. Get the customer id from the alert then close the alert
         * 7. Click on Customers Tab
         * 8. Assert that the user order in the list is the same as the value retrieved from
         * the alert
         * 9. Assert that the user details are precisely the same as entered in the form
         */
        BankPage bankPage = homePage.clickBankLink();
        getWindowManager().switchToNewTab();
        BankManagerPage bankManagerPage = bankPage.clickBankbtn();
        AddCustomerPage addCustomerPage = bankManagerPage.clickAddCustomerBtn();
        addCustomerPage.fillAllData("Ahmed", "Mahmoud", "1234");
        String alertMsg = addCustomerPage.getAlertMessage();
        addCustomerPage.closeAlertPopUp();
        CustomersPage customersPage = addCustomerPage.clickCustomersBtn();
        assertTrue(alertMsg.contains("customer id :" + customersPage.getListSize()));
        assertTrue(customersPage.getLastOrderData().contains("Ahmed Mahmoud 1234"), "Rwo not existed");
    }

    @Test(dependsOnMethods = "testAddNewCustomer")
    public void testAccountNumberFromAlert() {
        /**
         * 1- Click on Open Account
         * 2. Select the customer entered in scenario 1
         * 3. Select a random currency (each run should have a random selection)
         * 4. Submit account
         * 5. Get the account number from the alert then close the alert
         * 6. Click on Customers
         * 7. Assert that the Account Number retrieved from the alert is displayed in its
         * cell for the created customer
         */
        BankPage bankPage = homePage.clickBankLink();
        getWindowManager().switchToNewTab();
        BankManagerPage bankManagerPage = bankPage.clickBankbtn();
        OpenAccountPage openAccountPage = bankManagerPage.clickOpenAccountBtn();
        openAccountPage.clickCustomerSelect();
        openAccountPage.selectCustomer("Ahmed Mahmoud");
        openAccountPage.selectRandomCurrency();
        openAccountPage.clickSubmit();
        openAccountPage.closeAlertPopUp();
    }

    @Test(dependsOnMethods = "testAccountNumberFromAlert")
    public void testDeleteCreatedCustomer() {
        /**
         * 1. Delete the created customer in the first scenario
         * 2. Assert that the customer is no longer found in the customers' table
         */
        BankPage bankPage = homePage.clickBankLink();
        getWindowManager().switchToNewTab();
        BankManagerPage bankManagerPage = bankPage.clickBankbtn();
        CustomersPage customersPage = bankManagerPage.clickCustomerBtn();
        customersPage.deleteRecord();
        assertNull(customersPage.checkRecordExisted(), "Record not deleted yet");
    }
}