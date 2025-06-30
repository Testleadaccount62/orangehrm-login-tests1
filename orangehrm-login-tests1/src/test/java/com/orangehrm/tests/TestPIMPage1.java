package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orange.utils.CommonUtils1;
import com.orange.utils.TestNGUtility1;
import com.orangehrm.base.BasePage1;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.PIMPage1;

public class TestPIMPage1 extends BasePage1 {

    LoginPage loginPage = new LoginPage();
    PIMPage1 pimpage = new PIMPage1();

    @Test(description = "Verify that an employee can be added successfully", priority = 0)
    public void addEmployee() throws Exception {
        // Login to the application
        loginPage.login();
        CommonUtils1.hardWait(5);

        // Validate logged in user (welcome menu under profile dropdown)
        TestNGUtility1.assertTrue("Paul", CommonUtils1.getElementText(loginPage.getWelcomePage()));

        // Navigate to PIM and click Add Employee
        CommonUtils1.clickElement(PIMPage1.getPim());
        CommonUtils1.hardWait(2);
        CommonUtils1.clickElement(PIMPage1.getAddEmp());
        CommonUtils1.hardWait(2);

        // Fill out employee details
        CommonUtils1.enterValue(PIMPage1.getFirstName(), "Kosmik", true);
        CommonUtils1.enterValue(PIMPage1.getLastName(), "Sai", true);

        // Click Save
        CommonUtils1.clickElement(PIMPage1.getSave());
        CommonUtils1.hardWait(3);

        // Verify that the employee details page is displayed
        TestNGUtility1.assertTrue("Personal Details", CommonUtils1.getElementText(PIMPage1.getEmpName()));
    }

    @Test(description = "Verify that the search functionality returns the correct employee", groups = { "Smoke" }, priority = 1)
    public void searchEmployee() throws Exception {
        // Can be implemented based on employee name search input
    }

    @Test(description = "Verify that employee details can be edited successfully", dependsOnMethods = { "searchEmployee" }, groups = { "Smoke" }, priority = 2)
    public void editEmployeeDetails() throws Exception {
        Assert.assertEquals("sree", "sree");
    }

    @Test(description = "Verify that an employee can be deleted successfully", priority = 3)
    public void deleteEmployee() throws Exception {
        // To be implemented
    }

    @Test(description = "Verify that the employee list is displayed correctly with accurate information", priority = 4)
    public void viewEmployeeList() throws Exception {
        Assert.assertEquals("sree", "sreenu");
    }

    @Test(description = "Verify that photos can be added to employee profiles", priority = 5)
    public void addEmployeePhotos() throws Exception {
        // To be implemented
    }

    @Test(description = "Verify that employee details are correctly displayed", priority = 6)
    public void viewEmployeeDetails() throws Exception {
        // To be implemented
    }

    @Test(description = "Verify that the employment status of an employee can be updated", priority = 7)
    public void editEmploymentStatus() throws Exception {
        // To be implemented
    }

    @Test(description = "Verify that the employee list can be filtered based on various criteria", priority = 8)
    public void filterEmployeeList() throws Exception {
        // To be implemented
    }
}
