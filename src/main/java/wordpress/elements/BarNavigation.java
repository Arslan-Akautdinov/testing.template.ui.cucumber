package wordpress.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import wordpress.PageObject;
import wordpress.enums.WPMenu;

public class BarNavigation extends PageObject {

    public BarNavigation(WebDriver _wd, WebDriverWait _waiter) {
        super(_wd, _waiter);
    }

    public void navigateTo(WPMenu menu) {
        waitElement(new By.ById(menu.toString())).click();
    }
}
