import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by nako i gera on 13.1.2017 г..
 */
public class exercise14130117 extends Exercise2112 {
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
    public void dragAndDrop(){
        driver.get("https://snook.ca/technical/dragdrop/");
        WebElement E1 = driver.findElement(By.id("a"));
        WebElement E2 = driver.findElement(By.id("b"));

        Actions builder = new Actions(driver);
        builder.dragAndDrop(E1,E2).build().perform();
    }
    @Test
    public void dragAndDrop2() throws IOException {
        driver.get("http://only-testing-blog.blogspot.bg/2014/09/drag-and-drop.html");
        WebElement E1 = driver.findElement(By.id("dragdiv"));
        WebElement E2 = driver.findElement(By.id("dropdiv"));

        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(E1)
                .moveToElement(E2)
                .release(E1)
                .build();
                dragAndDrop.perform();
        Helper.takeScreenShot("snimchica", driver);
    }
    @Test
    public void moveByOffset(){
        Actions builder = new Actions(driver);

        driver.get("http://www.theautomatedtester.co.uk/demo2.html");
        WebElement element = driver.findElement(By.xpath("//div[@class=\"draggable ui-draggable\"]"));

        builder.dragAndDropBy(element, 250, 300).build().perform();
    }
    @Test
    public void rightClick(){
        driver.get("https://www.abv.bg/");
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.id("loginBut"));
        builder.contextClick(element).build().perform();
    }
    @Test
    public void doubleClick()throws Exception{
        Actions builder = new Actions(driver);
        driver.get("http://only-testing-blog.blogspot.bg/");
        WebElement button = driver.findElement(By.xpath("//button[@ondblclick=\"myFunction()\"]"));
        builder.doubleClick(button).build().perform();

    }
    @Test
    public void multySelect(){
        Actions builder = new Actions(driver);
        driver.get("http://book.theautomatedtester.co.uk/multi-select.html");
        java.util.List<WebElement> elements = driver.findElements(By.cssSelector("#selectWithMultipleEqualsMultiple option"));

        Action multySelect = builder.keyDown(Keys.CONTROL)
                .click(elements.get(1))
                .click(elements.get(2))
                .build();
        multySelect.perform();


    }
    @Test
    public void disableClass() throws IOException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.get("https://www.facebook.com/");

        jse.executeScript("document.getElementById(\"u_0_e\").className='';");
        Helper.takeScreenShot("face", driver);
        jse.executeScript("document.getElementById(\"u_0_e\").click()");





    }
    @Test
    public void displayBlock() throws IOException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.get("http://bg.sportsdirect.com//");
        jse.executeScript("document.getElementsByClassName(\"SubMenuWrapper\")[0].style.display = 'block';");
        Helper.takeScreenShot("sportal", driver);
    }



}