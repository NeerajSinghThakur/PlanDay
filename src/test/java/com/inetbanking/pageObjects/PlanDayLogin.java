package com.inetbanking.pageObjects;

import org.openqa.selenium.By;

import static com.inetbanking.testCases.BaseClass.driver;

public class PlanDayLogin {
    public static final String TEST_URL = "https://test1234.planday.com/";

    public  By usernameLocator = By.id("Username");
    public  By passwordLocator = By.id("Password");
    public  By loginButtonLocator = By.id("MainLoginButton");
    public   By scheduleLocator = By.xpath("//a[@href='/schedule']");
    public  By validationMessageLocator = By.className("validation-message");
    public  By iframeLocator = By.xpath("//body/div[@id='root']/div[1]/iframe[1]");
    public  By employeeCountLocator = By.xpath("//*[@class='row-header3']");
    public  By nextWeekInterval = By.xpath("//*[@class='button--right date-bar__button']");
    public By todayButtonLocator = By.xpath("//button[text()='Today']");
    public By addShiftLocator =  By.xpath("//div[contains(@class,'virtualized-board__row')][2]/div[contains(@class,'board__cell')][5]");
    public By shiftStartTime = By.id("shiftStartEnd_start");
    public  By shiftEndTime = By.id("shiftStartEnd_end");
    public  By createButtonLocator = By.xpath("/html/body/div[6]/div/div/div/div[6]/div/div/ul/li[2]/button");
    public By shiftCreatedLocator = By.xpath("//div[contains(@class,'virtualized-board__row')][2]");

    public  By cookieOK=By.id("cookie-consent-button");
    public  void handleLogin() {
        driver.findElement(usernameLocator).sendKeys("plandayqa@outlook.com");
        driver.findElement(passwordLocator).sendKeys("APItesting21");
        driver.findElement(loginButtonLocator).click();
    }


}
