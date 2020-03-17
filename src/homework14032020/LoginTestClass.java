package homework14032020;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTestClass {

    WebDriver driver;

    @Before
    public void openBrowser() {
        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfully() throws InterruptedException {
        WebElement loginLink = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginLink.click();
        Thread.sleep(2000);

        WebElement welcomeMsg = driver.findElement(By.xpath("//Strong[text()='Returning Customer']"));
        String expectedMsg = "Returning Customer";
        String actualMsg = welcomeMsg.getText();
        Assert.assertEquals(expectedMsg, actualMsg);
        Thread.sleep(2000);

        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("xyz@gmail.com");
        Thread.sleep(1000);

        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("abc123");
        Thread.sleep(1000);

        WebElement rememberMe = driver.findElement(By.id("RememberMe"));
        rememberMe.click();
        Thread.sleep(1000);

        WebElement loginBtn = driver.findElement(By.xpath("//div[@class='buttons']//input[@class='button-1 login-button']"));
        loginBtn.click();
        Thread.sleep(2000);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }


}





