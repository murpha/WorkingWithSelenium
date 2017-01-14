import org.junit.After;
import org.junit.Assert;
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
public class StartingWithWebDriver {
    WebDriver driver;
    @Before
    public void SetUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @After
    public void TearDown(){
        driver.quit();
    }
    @Test
    public void abvRegFormCheck(){
        driver.navigate().to("HTTP://abv.bg/");
        WebElement EntryButton = driver.findElement(By.id("loginBut"));
        Assert.assertTrue(EntryButton.isDisplayed());
        WebElement RegisterButton = driver.findElement(By.linkText("Регистрирай се!"));
        Assert.assertTrue(EntryButton.isDisplayed());
        RegisterButton.click();
        WebElement CreateProfileButton = driver.findElement(By.xpath("//html/body/article/div/div[3]/form/div[14]/div/input"));
        Assert.assertTrue(CreateProfileButton.isDisplayed());
        CreateProfileButton.click();
        java.util.List<WebElement> ErrorMessages = driver.findElements(By.xpath("div[@class=\"abv-error abv-messageGray\"]"));
        for (WebElement element:ErrorMessages
             ) {
            Assert.assertTrue(element.isDisplayed());

        }

    }
}
