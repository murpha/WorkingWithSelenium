import com.sun.jna.platform.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

/**
 * Created by nako i gera on 21.12.2016 г..
 */
public class Helper {
    public static void takeScreenShot(String shotName, WebDriver driver) throws IOException{
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        System.out.println(source.getAbsolutePath());
        File destination = new File("C:\\Users\\nako i gera\\IdeaProjects\\ScreenShots\\" +shotName + ".png");
        org.apache.commons.io.FileUtils.copyFile(source, destination);

    }
    public static void highLightElement(WebElement element, WebDriver driver){

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].style.border='3px solid red'", element);


    }
}
