package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class pageBase {
    public WebDriver driver ;

    public pageBase(WebDriver driver)
    {
        this.driver = driver ;
    }

    public void clickEle(WebElement ele)
    {
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(ele) ));

        ele.click();

    }


    public void enterTxt(WebElement ele ,String txt)
    {
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(ele) ));

        ele.sendKeys(txt);
    }










}
