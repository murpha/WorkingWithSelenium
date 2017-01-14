import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by nako i gera on 26.12.2016 г..
 */
public class BdzBgTest {
    WebDriver driver;
    @Before
    public void SetUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
//    @After
//    public void TearUp(){
//        driver.quit();
//    }
    @Test
    public void bdzBg(){
        driver.get("http://razpisanie.bdz.bg/site/search.jsp");
        driver.findElement(By.id("from_station")).sendKeys("софия");
        driver.findElement(By.id("to_station")).sendKeys("бургас");
        driver.findElement(By.xpath("//input[@type='image']")).click();
        driver.findElement(By.xpath("//td[contains(.,\"06:35\")]")).click();
    }
}
