import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by nako i gera on 16.12.2016 г..
 */
public class Exercise1612 {
    WebDriver driver;
    @Before
    public void SetUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @After
    public void TearDown(){
        driver.quit();
    }
    @Test
    public void getCssValue(){
        driver.get("http://facebook.com/");
        WebElement logInButton = driver.findElement(By.id("u_0_l"));

        System.out.println(logInButton.getCssValue("white-space"));
    }
    @Test
    public void getCssValue2(){
        driver.get("https://google.bg/");
        WebElement searchButton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        //Assert.assertEquals(searchButton.getCssValue("font-weight"), "bold");
        System.out.println(searchButton.getLocation());
    }
    @Test
    public void getText() throws Exception{
        driver.get("http://facebook.com/");
        java.util.List<WebElement> footerElements = driver.findElements(By.cssSelector("tbody .plm a"));
        for (WebElement element:footerElements
             ) {
            String text = element.getText();
            System.out.println(text);
            if (text == "About") {
                element.click();
                Thread.sleep(4000);
                break;

            }


        }
    }
    @Test
    public void getTagName(){
        driver.get("http://google.bg/");
        WebElement searchButton  = driver.findElement(By.xpath("//input[@name=\"btnI\"]"));
        Assert.assertTrue(searchButton.isEnabled());
        System.out.println(searchButton.getTagName());

    }
    @Test
    public void isSelected(){
        driver.get("http://facebook.com/");
        WebDriverWait wait2 = new WebDriverWait(driver, 5);
        WebElement radioButton = driver.findElement(By.id("u_0_h"));
        radioButton.click();
        wait2.until(ExpectedConditions.elementToBeSelected(By.id("u_0_h")));

    }
    @Test
    public void explicitWait(){
        driver.get("http://facebook.com/");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        java.util.List<WebElement> footerElements = driver.findElements(By.cssSelector("tbody .plm a"));
        wait.until(ExpectedConditions.visibilityOfAllElements(footerElements));



    }
    @Test
    public void urlContains(){
        driver.get("https://facebook.com/");
        WebDriverWait wait1 = new WebDriverWait(driver, 5);
        Assert.assertTrue(wait1.until(ExpectedConditions.urlContains("facebook")));
        Assert.assertTrue(wait1.until(ExpectedConditions.urlMatches("https://www.facebook.com/")));
    }

}
