package homework14032020;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RegistrationTestCase {

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

/*
Test Case 1 User should navigate to register page successfully.
Click on Register Link
Message   “Your Personal Details“
Assert above message.
*/

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        WebElement registerLink = driver.findElement(By.xpath("//div[@class='header-links-wrapper']//a[contains(text(),'Register')]"));
        registerLink.click();
        Thread.sleep(2000);
        WebElement welcomeText = driver.findElement(By.xpath("//div[@class='page-body']//strong[text()='Your Personal Details']"));
        String expectedText = "Your Personal Details";
        String actualText = welcomeText.getText();
        Assert.assertEquals(expectedText, actualText);
    }

/*
Test Case 2 User should register successfully.
Click on Register
Enter correct details in field
Click on register  button.
Expected Result:
Success Message  “Your registration completed”
Assert above message.
*/

    @Test
    public void userShouldRegisterSuccessfully() throws InterruptedException {

        WebElement registerLink = driver.findElement(By.xpath("//div[@class='header-links-wrapper']//a[contains(text(),'Register')]"));
        registerLink.click();

        Thread.sleep(3000);
        WebElement genderMale = driver.findElement(By.xpath("//input[@id='gender-male']"));
        WebElement genderFemale = driver.findElement(By.xpath("//input[@id='gender-female']"));
        genderMale.click();
        //genderFemale.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Hemal");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("Sheth");
        Thread.sleep(3000);
        WebElement dateOfBirth = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        dateOfBirth.sendKeys("1");
        Thread.sleep(3000);
        WebElement monthOfBirth = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        monthOfBirth.sendKeys("January");
        Thread.sleep(3000);
        WebElement yearOfYear = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        yearOfYear.sendKeys("1910");
        Thread.sleep(3000);

        WebElement emailId = driver.findElement(By.xpath("//input[@id='Email']"));
        emailId.click();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        emailId.sendKeys("xyz"+randomInt+"@gmail.com");
        Thread.sleep(3000);

        WebElement companyName = driver.findElement(By.xpath("//input[@id='Company'] "));
        companyName.sendKeys("Square1");
        WebElement newsLetter = driver.findElement(By.xpath("//input[@id='Newsletter']"));
        newsLetter.click();
        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("abc123");
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPassword.sendKeys("abc123");
        WebElement registerBtn = driver.findElement(By.xpath("//input[@id='register-button']"));
        registerBtn.click();
        WebElement successText = driver.findElement(By.xpath("//div[@class='master-wrapper-content']//div[text()='Your registration completed']"));
        String expectedText = "Your registration completed";
        String actualText = successText.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void closeBrowser() throws InterruptedException {
        driver.quit();
        Thread.sleep(2000);
    }

}




