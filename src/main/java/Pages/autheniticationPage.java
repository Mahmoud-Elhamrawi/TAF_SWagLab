package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class autheniticationPage extends pageBase {
    public autheniticationPage(WebDriver driver) {
        super(driver);
    }


    private final By userInp = By.id("user-name");
    private final By passInp = By.id("password");
    private final By loginBtn =By.id("login-button");
    private final By assertTitle =By.className("app_logo");
    private final By assertErrorUser = By.cssSelector("h3[data-test=\"error\"]");
    private final By toggleBtn =By.id("react-burger-menu-btn");
    //logout_sidebar_link
    private final By logBtn =By.id("logout_sidebar_link");
    public void  loginFunc(String  Uname , String Upass)
    {
        enterTxt(driver.findElement(userInp),Uname );
        enterTxt(driver.findElement(passInp),Upass );
        clickEle(driver.findElement(loginBtn));
    }

    public WebElement assertTit()
    {
        return driver.findElement(assertTitle);
    }
    public WebElement assertErrorUser()
    {
        return driver.findElement(assertErrorUser);
    }

  public void clickToggleBtn()
  {
      clickEle(driver.findElement(toggleBtn));
  }

    public void logOutBtn()
    {
        clickEle(driver.findElement(logBtn));
    }


}
