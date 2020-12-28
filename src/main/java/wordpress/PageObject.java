package wordpress;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageObject {

    protected WebDriver wd;
    protected WebDriverWait waiter;
    protected Actions actions;

    public PageObject(WebDriver _wd, WebDriverWait _waiter)
    {
        wd = _wd;
        waiter = _waiter;
        actions = new Actions(_wd);
    }



    protected WebElement waitElement(By by)
    {
        return waiter.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected List<WebElement> waitElements(By by)
    {
        return waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

}
