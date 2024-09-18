package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;



public class amaznloginwebsite {

    WebDriver driver;

    @DataProvider(name = "LoginData")
    public Object[][] provideLoginData() {
        return new Object[][] {
                { "baishali169@gmail.com", "11111111" },
                // You can add more test data here
        };
    }


    @BeforeMethod
    public void setUp() {
        // Set path to your ChromeDriver if not in PATH
        System.setProperty("webdriver.chrome.driver", "/home/baishali/Downloads/chromedriver-linux64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "LoginData")
    public void loginPage(String Email, String Password) throws InterruptedException {
        //land on login page
        driver.get("https://www.amazon.in/s?k=login+amazon+account&adgrpid=59671903835&ext_vrnc=hi&hvadid=590652406969&hvdev=c&hvlocphy=9195217&hvnetw=g&hvqmt=e&hvrand=11888780810796623176&hvtargid=kwd-837441119212&hydadcr=24542_2265395&tag=googinhydr1-21&ref=pd_sl_2cwzc6x246_e");
        WebElement Element_to_hover = driver.findElement(By.xpath("//a[@data-nav-ref='nav_ya_signin']"));

        //using mouse acion to click on signin
        Actions action= new Actions(driver);
        action.moveToElement(Element_to_hover).perform();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement AmazonSignin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='nav-action-inner']")));
        AmazonSignin.click();

        //enter emailid and click
        WebElement SigninField=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
        SigninField.sendKeys(Email);
        WebElement ClickContinues = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='continue']")));
        ClickContinues.click();

        //enter password and click continue
        WebElement PasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        PasswordField.sendKeys(Password);
        WebElement ClickSignin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='signInSubmit']")));
        ClickSignin.click();

        //enter otp and click enter
        //WebElement OTPField =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-labelledby='cvf-submit-otp-button-announce']")));
        // WebElement Submitcode =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-labelledby='cvf-submit-otp-button-announce']")));
        //Submitcode.click();
        WebElement accountName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")));
        Assert.assertTrue(accountName.getText().contains("Baishali"), "Login not successful");




    }

}
