package wordpress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import wordpress.PageObject;
import wordpress.locators.PagePostsEditLocators;

public class PagePostEdit extends PageObject {
    public PagePostEdit(WebDriver _wd, WebDriverWait _waiter) {
        super(_wd, _waiter);
    }

    public void clickCloseModal()
    {
        waitElement(PagePostsEditLocators.buttonCloseModal).click();
    }

    public void insertPostTitle(String postTitle) {
        waitElement(PagePostsEditLocators.fieldTitle).sendKeys(postTitle);
    }

    public void clickPublish() {
        waitElement(PagePostsEditLocators.buttonPostCreate).click();
    }

    public void clickPublishAccept() {
        waitElement(PagePostsEditLocators.buttonPostCreateAccept).click();
    }

    public void navigateToPostsList() {
        actions
                .moveToElement(waitElement(PagePostsEditLocators.buttonGoToPostsList))
                .click()
                .perform();
    }

}
