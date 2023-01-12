package com.inetbanking.testCases;


import com.inetbanking.pageObjects.PlanDayLogin;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TC_PlanDay_001 extends BaseClass
{

	PlanDayLogin planDayLogin= new PlanDayLogin();
	@Test(description = "Test 1 Verifies if username, password and login button fields are displayed")
	public void VerifyLoginFieldsAvailability() {
		driver.findElement(planDayLogin.cookieOK).click();
		Assert.assertTrue(driver.findElement(planDayLogin.usernameLocator).isDisplayed());
		Assert.assertTrue(driver.findElement(planDayLogin.passwordLocator).isDisplayed());
		Assert.assertTrue(driver.findElement(planDayLogin.loginButtonLocator).isDisplayed());

	}

	@Test(description = "Test 2 Verify if invalid login credentials produces validation message")
	public void VerifyIncorrectLoginCredentialsError() {

		boolean isValidationMessageDisplayed = false;
		driver.findElement(planDayLogin.cookieOK).click();
		driver.findElement(planDayLogin.usernameLocator).sendKeys("xyz@gmail.com");
		driver.findElement(planDayLogin.passwordLocator).sendKeys("1234");
		driver.findElement(planDayLogin.loginButtonLocator).click();

		if (driver.findElements(planDayLogin.validationMessageLocator).size() != 0) {
			isValidationMessageDisplayed = true;
		}
		Assert.assertTrue(isValidationMessageDisplayed);

	}

	@Test(description = "Test 3 Verify successful login")
	public void VerifyLogin() {
		driver.findElement(planDayLogin.cookieOK).click();
		planDayLogin.handleLogin();
		Assert.assertEquals(driver.getTitle(), "Planday");
	}

	@Test(description = "Test 4,5 Verify click on schdeule redirects to the correct /schedule page")
	public void VerifyRedirectUrlContainsSchedule() {
		driver.findElement(planDayLogin.cookieOK).click();
		planDayLogin.handleLogin();
		driver.findElement(planDayLogin.scheduleLocator).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/schedule"));
	}

	@Test(description = "Test 6 Count and seert that the number of employees displayed is 3")
	public void CountAndAssertNumberOfEmployees() {
		driver.findElement(planDayLogin.cookieOK).click();
		planDayLogin.handleLogin();
		driver.findElement(planDayLogin.scheduleLocator).click();
		WebElement iframe = driver.findElement(planDayLogin.iframeLocator);
		driver.switchTo().frame(iframe);

		int size = driver.findElements(planDayLogin.employeeCountLocator).size();
		Assert.assertEquals((size - 1), 3);

	}

	@Test(description = "Test 7,8, 9 Verify shift created is visible on the schedule grid")
	public void VerifyShiftShownOnScheduleGrid() {
		driver.findElement(planDayLogin.cookieOK).click();
		planDayLogin.handleLogin();

		driver.findElement(planDayLogin.scheduleLocator).click();

		WebElement iframe = driver.findElement(planDayLogin.iframeLocator);
		driver.switchTo().frame(iframe);

		driver.findElement(planDayLogin.nextWeekInterval).click();

		driver.findElement(planDayLogin.todayButtonLocator).click();
		driver.findElement(planDayLogin.addShiftLocator).click();
		driver.findElement(planDayLogin.shiftStartTime).sendKeys("9:00");
		driver.findElement(planDayLogin.shiftEndTime).sendKeys("17:00");
		driver.findElement(planDayLogin.createButtonLocator).click();
		WebElement ele = driver.findElement(planDayLogin.shiftCreatedLocator);
		Assert.assertTrue(ele.getText().contains("Shift"));

	}
	
	
}
