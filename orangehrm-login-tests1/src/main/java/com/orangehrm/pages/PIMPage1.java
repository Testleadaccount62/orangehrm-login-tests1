package com.orangehrm.pages;

import org.openqa.selenium.By;

import com.orange.utils.CommonUtils1;

public class PIMPage1 {

	
		 

			//  Updated Web locators for https://opensource-demo.orangehrmlive.com

			private static final By by_pim = By.xpath("//span[text()='PIM']");
			private static final By by_addEmp = By.xpath("//a[contains(@href, '/pim/addEmployee')]");
			private static final By by_firstName = By.name("firstName");
			private static final By by_lastName = By.name("lastName");
			private static final By by_save = By.xpath("//button[@type='submit']");
			private static final By by_empName = By.xpath("//h6[text()='Personal Details']");

			// Getter/Setter Helper functions (same structure)

			public static void clickOnElement() throws Exception {
				CommonUtils1.clickElement(getPim());
			}

			public static By getPim() throws Exception {
				return by_pim;
			}

			public static By getAddEmp() throws Exception {
				return by_addEmp;
			}

			public static By getFirstName() throws Exception {
				return by_firstName;
			}

			public static By getLastName() throws Exception {
				return by_lastName;
			}

			// No frame required in new UI
			public static By getSave() throws Exception {
				return by_save;
			}

			public static By getBackButton() throws Exception {
				// No back button in modern UI, navigation is direct
				return null;
			}

			public static By getEmpName() throws Exception {
				return by_empName;
			}
		



}
