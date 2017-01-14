import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by nako i gera on 13.12.2016 г..
 */
public class AbvLogIn {
    WebDriver driver;
    @Before
    public void SetUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void abvLogIn(){
        driver.get("HTTP://abv.bg/");
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("nako_83");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("GALAfood2");
        WebElement logInButton = driver.findElement(By.id("loginBut"));
        logInButton.submit();
    }
}
