package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkoutPage extends pageBase{
    public checkoutPage(WebDriver driver) {
        super(driver);
    }

    private final By addToCart_bike_light = By.id("add-to-cart-sauce-labs-bike-light") ;
    private final By addToCart_labs_backpack = By.id("add-to-cart-sauce-labs-backpack");

    private final By assertCountCart = By.className("shopping_cart_badge");

    private final By goToCartPage = By.cssSelector("a[class=\"shopping_cart_link\"]");
    private final By checkoutBtn = By.id("checkout");
    private final By FnameInp = By.id("first-name");
    private final By LnameInp = By.id("last-name");
    private  final By postCodeInp = By.id("postal-code");
    private final By countiunBtn = By.id("continue");
    private final By assrtTitle = By.cssSelector("span[class=\"title\"]");
    private final By finishBtn = By.id("finish");
    private final By assertCompelet =By.className("complete-header");
    private final By backBtn = By.id("back-to-products");
    public void addToCart()
    {
        clickEle(driver.findElement(addToCart_bike_light));
        clickEle(driver.findElement(addToCart_labs_backpack));
    }

    public WebElement countOfCart()
    {
        return driver.findElement(assertCountCart);
    }

    public void cartPage()
    {
        clickEle(driver.findElement(goToCartPage));
    }

    public void clickingOnCheckout()
    {
        clickEle(driver.findElement(checkoutBtn));
    }

    public void fillPersonalData(String FN , String LN ,String PC)
    {
        enterTxt(driver.findElement(FnameInp),FN );
        enterTxt(driver.findElement(LnameInp),LN );
        enterTxt(driver.findElement(postCodeInp),PC );
        clickEle(driver.findElement(countiunBtn));
    }

      public  WebElement assertTit()
{
    return driver.findElement(assrtTitle);
}

       public void finishCheck()
   {
       clickEle(driver.findElement(finishBtn));
   }

    public  WebElement assertCom()
    {
        return driver.findElement(assertCompelet);
    }
    public void backToHome()
    {
        clickEle(driver.findElement(backBtn));
    }

}
