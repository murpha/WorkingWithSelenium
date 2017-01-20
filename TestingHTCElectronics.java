import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Atanas on 14.1.2017 г..
 */
public class TestingHTCElectronics {
    WebDriver driver;

    @Before
    public void SetUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @After
    public void TearDown(){
        driver.quit();
    }
    @Test
    public void HTCTesting() throws IOException {
        Actions builder = new Actions(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        driver.get("http://demo.cs-cart.com/stores/0bc44201c7d9840f/");
        WebElement electronics = driver.findElement(By.xpath("//li[@class='ty-menu__item cm-menu-item-responsive ty-menu-item__electronics']"));
        builder.moveToElement(electronics).build().perform();
        driver.findElement(By.xpath("//a[contains(.,'HTC')]")).click();
        WebElement HTC1 = driver.findElement(By.id("det_img_71"));
        builder.moveToElement(HTC1).perform();
        jse.executeScript("return $(\"[data-ca-view-id='71']\").click()\n");
        driver.findElement(By.xpath("//a[@class='cm-increase ty-value-changer__increase']")).click();
        driver.findElement(By.id("button_cart_ajax71")).click();
        WebElement hiddenButton = driver.findElement(By.xpath("//a[@class='ty-btn ty-btn__secondary cm-notification-close ']"));
        jse.executeScript("arguments[0].click();", hiddenButton);








    }
}
