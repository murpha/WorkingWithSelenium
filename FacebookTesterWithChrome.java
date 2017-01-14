import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by nako i gera on 10.12.2016 г..
 */
public class FacebookTesterWithChrome {

        WebDriver driver;
        @Before
        public void setUp(){
            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\staba\\IdeaProjects\\WorkingWithSelenium\\src\\test\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        @After
        public void tearDown(){
            driver.quit();
        }

    @Test
    public void facebookLandingPage(){
        driver.get("https://www.facebook.com/");

        //WebElement LoginButton = driver.findElement(By.id("u_0_n"));
        WebElement LoginButton = driver.findElement(By.xpath("//input[@id = \"u_0_n\"]"));
        //LoginButton.click();
        List<WebElement> footerElements = driver.findElements(By.cssSelector(".uiGrid td"));
        Assert.assertTrue(footerElements.size() !=0);

        for (WebElement element: footerElements
             ) {             Assert.assertTrue(element.isDisplayed());
                    System.out.println(element.getText());
        }

        List<WebElement> pageFooterElements = driver.findElements(By.cssSelector(".uiList li"));Assert.assertTrue(pageFooterElements.size() != 0);
        for (WebElement element: pageFooterElements
             ) {
                    Assert.assertTrue(element.isDisplayed());
            System.out.println(element.getText());
        }
    }

/*        @Test
        public void tester(){
            driver.get("https://www.abv.bg/");
            // 1. Click register button
            WebElement register =  driver.findElement(By.xpath("//a [. = 'Регистрирай се!']//strong"));
            Assert.assertTrue(register.getText() == "Регистрирай се!");
            register.click();
            // 2. Click createProfileButton
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebElement createProfileBttn = driver.findElement(By.xpath("//input [@value = 'Създай АБВ Профил']"));
            Assert.assertTrue(createProfileBttn.getText() == "Създай АБВ Профил");
            createProfileBttn.click();
            // 3. Assert error messages appear on screen
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            // 4. Assert error messages

        }*/
    }

