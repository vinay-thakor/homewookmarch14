package homework14;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class Login {

    private WebDriver driver;

    @Before
    public void openBrowser() {
        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//open url
        driver.get(baseUrl);
    }

    @Test
    public void login() throws InterruptedException {
        WebElement clickLogin = driver.findElement(By.xpath("//a[@class='ico-login']"));
        clickLogin.click();
        WebElement welcometext = driver.findElement(By.xpath("//div[@class='page-title']//h1[text()=']"));
        String expectedText = "Welcome, Please Sign In!";
        String actualText = welcometext.getText();
        Assert.assertEquals(expectedText, actualText);
        Thread.sleep(2000);
        WebElement enterEmail = driver.findElement(By.xpath("//input[@id='Email'"));
        enterEmail.sendKeys("mytest4@gmail.com");

        WebElement enterPassword = driver.findElement(By.xpath("//input[@name='password'"));
        enterPassword.sendKeys("Test123");

        WebElement clickLoginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button'"));
        clickLoginButton.click();

        WebElement loginSuccessfully = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!']"));
        String expectedLoginPage = "Welcome, Please Sign In!";
        String actualLoginPage = loginSuccessfully.getText();
        Assert.assertEquals(actualLoginPage,expectedLoginPage);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}




