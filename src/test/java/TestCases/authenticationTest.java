package TestCases;

import Pages.autheniticationPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class authenticationTest  extends   testBase{


autheniticationPage autheniticationPage ;
SoftAssert softAssert = new SoftAssert();


    @Test(priority = 1)
    public void validLogin()
    {
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/"));

        autheniticationPage = new autheniticationPage(driver);
        autheniticationPage.loginFunc("standard_user","secret_sauce");
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));
        System.out.println(driver.getCurrentUrl());

        String title ="Swag Labs" ;
        String expectTitile = autheniticationPage.assertTit().getText();
        softAssert.assertEquals(title , expectTitile);

        softAssert.assertAll();

    }

    @Test(priority = 2)
    public void inValidLoginUser()
    {
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/"));

        autheniticationPage = new autheniticationPage(driver);
        autheniticationPage.loginFunc("standard_us","secret_sauce");
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/"));
        System.out.println(driver.getCurrentUrl());

        String ActualTitle ="Epic sadface: Username and password do not match any user in this service" ;
        String expectTitile = autheniticationPage.assertErrorUser().getText();
        softAssert.assertEquals(ActualTitle , expectTitile);

        System.out.println(expectTitile);
        softAssert.assertAll();

    }


    @Test(priority = 3)
    public void inValidLoginPass()
    {
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/"));

        autheniticationPage = new autheniticationPage(driver);
        autheniticationPage.loginFunc("standard_user","secret_sa");
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/"));
        System.out.println(driver.getCurrentUrl());

        String ActualTitle ="Epic sadface: Username and password do not match any user in this service" ;
        String expectTitile = autheniticationPage.assertErrorUser().getText();
        softAssert.assertEquals(ActualTitle , expectTitile);

        System.out.println(expectTitile);
        softAssert.assertAll();

    }


}
