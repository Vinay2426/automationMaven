package TestAutomationMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils  extends basePage
{



    //find locator and enter text class
    private void enterText (By locator, String text)
    {
        driver.findElement(locator).sendKeys(text);
    }

    //click the page after finding locator
    private String clickLocator(By by)
    {
        return driver.findElement(by).getText();
    }

    private static WebDriverWait createWait(long time)
    {
        return new WebDriverWait(driver, time);
    }
    public static void waitForClickable(By by, long time)
    {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public static void waitForAlertPresent(long time)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static String randomDate()
    {
        DateFormat format = new SimpleDateFormat("ddMMyyHHmmss");
        return format.format(new Date());
    }


}
