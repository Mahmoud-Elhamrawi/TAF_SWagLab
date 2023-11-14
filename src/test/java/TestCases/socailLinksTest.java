package TestCases;

import Pages.autheniticationPage;
import Pages.socailLinksPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;

public class socailLinksTest extends testBase{

    autheniticationPage autheniticationPage ;
    socailLinksPage socailLinksPage ;
    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 1)
    public void validLogin() throws InterruptedException {
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/"));

        autheniticationPage = new autheniticationPage(driver);
        autheniticationPage.loginFunc("standard_user","secret_sauce");
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));
        System.out.println(driver.getCurrentUrl());

        String title ="Swag Labs" ;
        String expectTitile = autheniticationPage.assertTit().getText();
        softAssert.assertEquals(title , expectTitile);


////socail/////
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");

        socailLinksPage = new socailLinksPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(socailLinksPage.footer()));

        socailLinksPage.goToTwitter();
        Thread.sleep(2000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1000);
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://twitter.com/saucelabs"));
        System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(tabs.get(0));

        socailLinksPage.goToFB();
        Thread.sleep(2000);
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1000);
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/saucelabs"));
        System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(tabs.get(0));

        socailLinksPage.goToLinked();
        Thread.sleep(2000);
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1000);
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.linkedin.com/company/sauce-labs/"));
        System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(tabs.get(0));






        softAssert.assertAll();

    }


}
