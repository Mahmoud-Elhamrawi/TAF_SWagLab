package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class testBase {


    public WebDriver driver ;
    @BeforeClass
    public void setUP()
    {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");


    }


    @AfterClass
    public void cleanUp() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }



}