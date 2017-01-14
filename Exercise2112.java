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
 * Created by nako i gera on 21.12.2016 г..
 */
public class Exercise2112 {
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
    public void checkBoxes(){
        driver.get("http://demoqa.com/registration/");
        WebElement checkBoxDance = driver.findElement(By.xpath("//input[@name=\"checkbox_5[]\"]"));
        if(!checkBoxDance.isSelected()){
            checkBoxDance.click();
        }
    }@Test
    public void checkBoxes2()throws IOException {
        driver.get("https://passport.abv.bg/app/profiles/registration");
        Helper.takeScreenShot("shot1", driver);

        WebElement field = driver.findElement(By.id("regformUsername"));
        Helper.highLightElement(field, driver);

        Helper.takeScreenShot("abvShot", driver);
        WebElement box = driver.findElement(By.id("phoneRecovery1"));
        if (!box.isSelected()){
            box.click();

        }
    }
    @Test
    public void datePicker() throws IOException{
        driver.get("http://demoqa.com/datepicker/");
        driver.findElement(By.xpath("//input[@id=\"datepicker1\"]")).click();
        java.util.List<WebElement> calendar = driver.findElements(By.cssSelector("tbody a"));
        for ( WebElement element:calendar
             ) {

            if (element.getText().equals("16")){
                element.click();
                break;
            }
            Helper.takeScreenShot("shotche", driver);
        }


    }
    @Test
    public void autoComplete()throws IOException{
        driver.get("http://demoqa.com/autocomplete/");
        driver.findElement(By.id("tagss")).sendKeys("a");
        java.util.List<WebElement> autoCompleateList = driver.findElements(By.xpath("//li[@class=\"ui-menu-item\"]"));
        for (WebElement element:autoCompleateList
             ) {
            String text = element.getText();
            if (text.equals("ActionScript")){
                element.click();
                break;

            }
        }
        Helper.takeScreenShot("picture", driver);


    }
    @Test
    public void uploadFile()throws IOException{
        driver.get("http://demoqa.com/registration/");
        driver.findElement(By.id("profile_pic_10"))
                .sendKeys("C:\\Users\\nako i gera\\IdeaProjects\\ScreenShots\\abvShot.png");
      Helper.takeScreenShot("dokazatelstvo", driver);
    }
}
