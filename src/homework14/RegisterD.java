package homework14;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.ClientInfoStatus;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RegisterD {
    private WebDriver driver;


    @Before
    public void openBrowser() {
        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(baseUrl);

    }

    @Test
    public void UserShouldLoginSucessfullyRegister() {
        WebElement register123 = driver.findElement(By.xpath("//a[@class='ico-register']"));
        register123.click();
        WebElement welcomemesg = driver.findElement(By.xpath("//div[@class='title']//strong[contains(text(),'Your Personal Details')]"));
        String expectedtest = "Your Personal Details";
        String actualText = welcomemesg.getText();
        Assert.assertEquals(expectedtest, actualText);
    }

    @Test
    public void VerfityUserSholdRegisterSucessfully() throws InterruptedException {
        Thread.sleep(3000);
        WebElement register = driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();
        WebElement welcometext = driver.findElement(By.xpath("//strong[contains(text(),'Your Personal Details')]"));
        String expectedText = "Your Personal Details";
        String actualText = welcometext.getText();
        Thread.sleep(2000);
        WebElement clickOnMale = driver.findElement(By.xpath("//input[@id='gender-male']"));
        clickOnMale.click();


        WebElement firstname = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstname.sendKeys("mytestone");


        WebElement Secoundname = driver.findElement(By.xpath("//input[@id='LastName']"));
        Secoundname.sendKeys("forwork");



        WebElement dateofbirt = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        dateofbirt.sendKeys("4");


        WebElement month = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        month.sendKeys("april");

        WebElement year = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        year.sendKeys("1994");

        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys("mytest4@gmail.com");

        WebElement companyname = driver.findElement(By.xpath("//input[@id='Company']"));
        companyname.sendKeys("My test for you");

        WebElement newesletertick = driver.findElement(By.xpath("//input[@id='Newsletter']"));
        newesletertick.click();

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Mytest123");

        WebElement conformpassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        conformpassword.sendKeys("Mytest123");

        WebElement register1 = driver.findElement(By.xpath("//input[@name='register-button']"));
        register1.click();

        WebElement actualRegSuccessfully = driver.findElement(By.xpath("//div[@class='page-body']//div[text()='Your registration completed']"));
        String expectedRegText = "Your registration completed";
        String actualRegpPage = actualRegSuccessfully.getText();
        Assert.assertEquals(actualRegpPage,expectedRegText);

    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
//Your registration completed
//Your registration completed
