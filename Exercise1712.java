import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

/**
 * Created by nako i gera on 17.12.2016 г..
 */
public class Exercise1712 {
    WebDriver driver;
    @Before
    public void SetUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @After
    public void TearUp(){
        driver.quit();
    }
    @Test
    public void javaScriptExecutor(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.get("http://www.dwuser.com/education/content/the-magical-iframe-tag-an-introduction/");
        WebElement footer = driver.findElement(By.id("accountSectionLink"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("accountSectionLink")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt
                (jse.executeScript("return window.length").toString());
        System.out.println("Number of iframes = " + numberOfFrames);

    }
    @Test
    public void switchToFrame() throws Exception{
        driver.get("http://www.dwuser.com/education/content/the-magical-iframe-tag-an-introduction/");

        WebElement iframe = driver.findElement(By.cssSelector("iframe[src='http://www.weather.gov/']"));

        driver.switchTo().frame(iframe);

        WebElement title = driver.findElement(By.cssSelector("img[alt='National Weather Service']"));

        Assert.assertTrue(title.isDisplayed());

        Thread.sleep(3000);

        driver.switchTo().defaultContent();

        WebElement mainTitle = driver.findElement(By.xpath("//h1[contains(.,\"The Magical\")]"));

        Assert.assertTrue(mainTitle.isDisplayed());


    }
    @Test
        public void alertBoxes(){
            driver.get("http://www.globalsqa.com/demo-site/alertbox/");

            WebElement button = driver.findElement(By.xpath("//button[contains(.,'Try it')]"));
            button.click();
            Alert simpleAlertBox = driver.switchTo().alert();
            simpleAlertBox.accept();

    }
    @Test
    public void alertBoxes2() {
        driver.get("http://www.globalsqa.com/demo-site/alertbox/");
        driver.findElement(By.xpath("//li[@id=\"Confirmation Box\"]")).click();

        WebElement button2 = driver.findElement(By.cssSelector("button[onclick='myFunctionTab2()']"));
        button2.click();
        Alert simpleAlertBox = driver.switchTo().alert();
        String text = simpleAlertBox.getText();
        simpleAlertBox.accept();


    }
    @Test
    public void alertBoxes3() {
        driver.get("http://www.globalsqa.com/demo-site/alertbox/");
        driver.findElement(By.xpath("//li[@id=\"Prompt Box\"]")).click();

        WebElement button2 = driver.findElement(By.cssSelector("button[onclick='myFunctionTab3()']"));
        button2.click();
        Alert simpleAlertBox = driver.switchTo().alert();
        //String text = simpleAlertBox.getText();
        simpleAlertBox.sendKeys("Hello");
        simpleAlertBox.accept();


    }
}
