import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by nako i gera on 14.1.2017 г..
 */
public class Exercise15140117 extends exercise14130117{
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
    public void elementsPresent(){
        Actions builder = new Actions(driver);
        driver.get("http://demo.cs-cart.com/stores/33dfe0f084c3181e/");
        java.util.List<WebElement> navigationMenu = driver.findElements(By.className("ty-menu__item"));
        Assert.assertTrue(navigationMenu.size() == 11);



    }
    @Test
    public void checkFooterItemsPresent(){
        Actions builder = new Actions(driver);
        driver.get("http://demo.cs-cart.com/stores/33dfe0f084c3181e/");
        List<WebElement> footer = driver.findElements(By.className("ty-footer"));
        Assert.assertTrue(footer.size() == 4);

        for (WebElement element: footer
             ) {
            Assert.assertTrue(element.isDisplayed());
        }
    }
    @Test
    public void HTCTest() throws IOException {
        Actions builder = new Actions(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.get("http://demo.cs-cart.com/stores/33dfe0f084c3181e/");
        WebElement electronics = driver.findElement(By.xpath("//li[@class='ty-menu__item cm-menu-item-responsive ty-menu-item__electronics']"));
        builder.moveToElement(electronics).build().perform();
        driver.findElement(By.xpath("//a[contains(.,\"HTC\")]")).click();
        WebElement htc1 = driver.findElement(By.id("det_img_71"));
        builder.moveToElement(htc1).build().perform();
        jse.executeScript("return $(\"[data-ca-view-id='71']\").click()");
        //Helper.takeScreenShot("htc", driver);
        driver.findElement(By.xpath("//a[@class='cm-increase ty-value-changer__increase']")).click();
        driver.findElement(By.id("button_cart_ajax71")).click();
        //driver.findElement()
    }

}
