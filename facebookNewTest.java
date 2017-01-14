import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by nako i gera on 17.12.2016 г..
 */
public class facebookNewTest {
    WebDriver driver;
    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @After
    public void TearDown(){
        driver.quit();
    }
    @Test
    public void testFacebookLogIn(){
        driver.get("https://facebook.com/");

    }
}
