package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class socailLinksPage extends pageBase{
    public socailLinksPage(WebDriver driver) {
        super(driver);
    }


    private final By checkFooterAppear = By.cssSelector("Footer[class=\"footer\"]");
    private final By twitterIcon = By.xpath("//a[@href=\"https://twitter.com/saucelabs\"]");
    private final By FBookIcon = By.xpath("//a[@href=\"https://www.facebook.com/saucelabs\"]");
    private final By linkedInIcon = By.xpath("//a[@href=\"https://www.linkedin.com/company/sauce-labs/\"]");

    public WebElement footer()
    {
        return driver.findElement(checkFooterAppear);
    }

    public void goToTwitter()
    {
        clickEle(driver.findElement(twitterIcon));
    }
    public void goToFB()
    {
        clickEle(driver.findElement(FBookIcon));
    }
    public void goToLinked()
    {
        clickEle(driver.findElement(linkedInIcon));
    }



}
