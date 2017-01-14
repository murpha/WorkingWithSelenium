import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by nako i gera on 16.12.2016 г..
 */
public class GoogleLogIn {
    WebDriver driver;
    @Before
    public void SetUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @After
    public void TearDown(){
        driver.quit();
    }
    @Test
    public void GoogleLogIn(){
        driver.get("http://gmail.com");
        WebElement name = driver.findElement(By.id("Email"));
        name.sendKeys("atanaspeev1983@gmail.com");
        WebElement nextButton = driver.findElement(By.id("next"));
        nextButton.click();
        WebElement passField = driver.findElement(By.id("Passwd"));
        passField.sendKeys("GALAfood2");
        WebElement nextButton2 = driver.findElement(By.id("signIn"));
        nextButton2.click();


    }
}
