package Step;

import Page.checkCartForHTCPage;
import Page.exercise1620012017Page;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Assert;
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
import java.util.List;
import java.util.concurrent.TimeUnit;

import static Page.exercise1620012017Page.*;
import static Page.exercise1620012017Page.cartButton;
import static Page.exercise1620012017Page.increaseButton;

/**
 * Created by nako i gera on 21.1.2017 г..
 */
public class TryToBuyHTC {
    WebDriver driver;

    @Before
    public void SetUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void TearDown() {
        driver.quit();
    }

    @Test
    public void HTCTesting() throws IOException, InterruptedException {
        Actions builder = new Actions(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebDriverWait wait = (new WebDriverWait(driver, 5));

        driver.get(url);

        wait.until(ExpectedConditions.titleIs(title));

        WebElement electronics = driver.findElement(By.xpath(electronicsOptions));

        builder.moveToElement(electronics).build().perform();

        driver.findElement(By.xpath(HTCOptions)).click();

        List<WebElement> HTC = driver.findElements(By.xpath(HTCList));
        Assert.assertTrue(HTC.size() == 2);


        WebElement HTC1 = driver.findElement(By.id(exercise1620012017Page.HTC1));

        builder.moveToElement(HTC1).perform();

        jse.executeScript(quickViewButton);
        WebElement htcBoxTitle = driver.findElement(By.className(HTCBoxTitle));
        Thread.sleep(3000); // replace with wait until
        Assert.assertEquals(htcBoxTitle.getText(),"DROID INCREDIBLE 2");
        WebElement price = driver.findElement(By.id(exercise1620012017Page.price));
        //price.getText();
        //System.out.println(price);
        exercise1620012017Page.num = Double.parseDouble(price.getText());
        //System.out.println(realPrice);
        driver.findElement(By.xpath(increaseButton)).click();
        driver.findElement(By.id(cartButton)).click();
        WebElement hiddenButton = driver.findElement(By.xpath(exercise1620012017Page.hiddenButton));
        hiddenButton.click();
        //jse.executeScript("arguments[0].click();", hiddenButton);
        //Helper.takeScreenShot("snimchica", driver);

        //jse.executeScript("document.getElementsByClassName('ty-btn ty-btn__secondary cm-notification-close').click()");

        //WebElement cartButton2 = driver.findElement(By.className("ty-minicart__icon ty-icon-moon-commerce filled"));
        //jse.executeScript("arguments[0].click();", cartButton2);
        //driver.findElement(By.xpath("//a[contains(.,'View cart')]")).click();


    }

    public void goToCart() throws IOException {
        //WebDriverWait wait = (new WebDriverWait(driver, 5));
        driver.findElement(By.xpath("")).click();
        driver.findElement(By.xpath("//a[contains(.,'View cart')]")).click();
        Helper.takeScreenShot("last", driver);

    }

    public void checkCartForHTC(){
        WebElement cartTitle = driver.findElement(checkCartForHTCPage.cartTitle);
        Assert.assertEquals(cartTitle.getText(), "Cart contents");
        WebElement quantity = driver.findElement(checkCartForHTCPage.quantity);
        quantity.getAttribute("value");
        Assert.assertEquals(quantity.getAttribute("value"), "2");
        WebElement checkOutPrice = driver.findElement(By.id("sec_product_subtotal_2147529457"));
        double num2 = Double.parseDouble(checkOutPrice.getText().replaceAll(",", ""));
        Assertions.assertThat(exercise1620012017Page.num*2).isEqualTo(num2);
        //proceed to check out



    }

    /**
     * sign in as customer
     * billing and shipping address + validation
     * assert all error messages
     * shipping options
     * billing options + validation
     */
    public void checkOut(){

    }

}
