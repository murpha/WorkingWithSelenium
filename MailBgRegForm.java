import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by nako i gera on 14.12.2016 г..
 */
public class MailBgRegForm {
    WebDriver driver;
    @Before
    public void SetUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @After
    public void TearDown(){
        driver.quit();
    }
    @Test
    public void MailBgRegForm()throws IOException {
        driver.get("HTTP://mail.bg");
        WebElement RegNewUser = driver.findElement(By.xpath("//a[@class=\"signup-link\"]"));
        RegNewUser.click();
        WebElement name = driver.findElement(By.id("signup_user"));
        name.sendKeys("Goshko");
        WebElement pass = driver.findElement(By.id("mail_pass_input"));
        pass.sendKeys("123456789a");
        WebElement repass = driver.findElement(By.id("mail_confpass_input"));
        repass.sendKeys("123456789a");
        WebElement jenderKey = driver.findElement(By.xpath("//span[@class=\"input_drop_down\"]"));
        jenderKey.click();
        WebElement jender = driver.findElement(By.xpath("//li[contains(.,\"Мъж\")]"));
        jender.click();
        driver.findElement
                (By.xpath("//div[@onclick=\"DropDownOpen(this,'register_select','drop_down_settings_day'); HideHint('signup_mail_hint');\"]")).click();
        driver.findElement(By.xpath("//li[@onclick=\"InputSelectValue(this,'settings_day','9');\"]")).click();
        driver.findElement(By.xpath("//div[@onclick=\"DropDownOpen(this, 'register_select', 'drop_down_settings_month'); HideHint('signup_mail_hint');\"]")).click();
        driver.findElement(By.xpath("//li[@onclick=\"InputSelectValue(this,'settings_month','6');\"]")).click();
        driver.findElement(By.xpath("//div[@onclick=\"DropDownOpen(this, 'register_select', 'drop_down_settings_year'); HideHint('signup_mail_hint');\"]")).click();
        driver.findElement(By.xpath("//li[@onclick=\"InputSelectValue(this,'settings_year','2007');\"]")).click();
        Helper.takeScreenShot("MailbgScreenShot", driver);

    }
}
