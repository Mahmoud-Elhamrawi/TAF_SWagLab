package TestCases;

import Pages.autheniticationPage;
import Pages.checkoutPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class checkoutTest  extends testBase{

    autheniticationPage autheniticationPage ;
    SoftAssert softAssert = new SoftAssert();


checkoutPage checkoutPage ;

    @Test
    public void checkoutFunc()
    {
        //login
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/"));

        autheniticationPage = new autheniticationPage(driver);
        autheniticationPage.loginFunc("standard_user","secret_sauce");
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));
        System.out.println(driver.getCurrentUrl());

        String title ="Swag Labs" ;
        String expectTitile = autheniticationPage.assertTit().getText();


        //add to cart//


        checkoutPage = new checkoutPage(driver);
        checkoutPage.addToCart();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.countOfCart()));

         String actualCount = "2" ;
         softAssert.assertEquals(checkoutPage.countOfCart().getText() , actualCount);

         //go to cart //
         checkoutPage.cartPage();
         softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/cart.html"));

         //go to checkout//
        checkoutPage.clickingOnCheckout();
         softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/checkout-step-one.html"));

         checkoutPage.fillPersonalData("mahmoud","rashad","252525");
         softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/checkout-step-two.html"));

         String actualTxt ="Checkout: Overview" ;

         softAssert.assertEquals(actualTxt , checkoutPage.assertTit().getText());
         checkoutPage.finishCheck();

         softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/checkout-complete.html"));


         softAssert.assertTrue(checkoutPage.assertCom().getText().contains("Thank you for your o"));

         checkoutPage.backToHome();
         softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));



















        softAssert.assertAll();





    }





}
