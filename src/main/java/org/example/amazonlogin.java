package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class amazonlogin {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set path to your ChromeDriver if not in PATH
        System.setProperty("webdriver.chrome.driver", "/home/baishali/Downloads/chromedriver-linux64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    @Test
    public  void Login()
    {
        driver.get("https://www.amazon.in/-/hi/ap/signin?openid.pape.max_auth_age=3600&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fspr%2Freturns%2Fgift&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=amzn_psr_desktop_in&openid.mode=checkid_setup&language=en_IN&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement amazonLogo= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@aria-label='Amazon']")));
        Assert.assertTrue(amazonLogo.isDisplayed(),"Amazon Logo is not displayed");

        WebElement amazonLogin= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
        amazonLogin.click();
        amazonLogin.sendKeys("baishali169@gmail.com");

        WebElement amazonContinue =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='continue']")));
        amazonContinue.click();
        WebElement amazonPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='ap_password']")));
        amazonPassword.sendKeys("Danny@2728");



    }

}
