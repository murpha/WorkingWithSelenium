import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by nako i gera on 10.12.2016 г..
 */
public class abvTest {
    WebDriver driver;
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void GoogleSearch(){
        driver.get("https://www.google.bg/");
        WebElement SearchField = driver.findElement(By.id("lst-ib"));
        Assert.assertTrue(SearchField.isDisplayed());
        SearchField.sendKeys("QA");
        SearchField.submit();
    }
}
