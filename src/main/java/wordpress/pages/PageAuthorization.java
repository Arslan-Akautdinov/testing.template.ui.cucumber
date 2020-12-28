package wordpress.pages;

import common.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import wordpress.PageObject;
import wordpress.locators.PageAuthorizationLocators;


public class PageAuthorization extends PageObject {
    public PageAuthorization(WebDriver _wd, WebDriverWait _waiter) {
        super(_wd, _waiter);
    }

    public void actionAuthorize() {
        insertLogin();
        insertPassword();
        clickEnter();
    }

    public void actionAuthorize(String login, String password)
    {
        insertLogin(login);
        insertPassword(password);
        clickEnter();
    }

    public void insertLogin(String login) {
        wd.findElement(PageAuthorizationLocators.inputLogin).sendKeys(login);
    }

    public void insertPassword(String password) {
        wd.findElement(PageAuthorizationLocators.inputPassword).sendKeys(password);
    }

    public void insertLogin() {
        insertLogin(ApplicationManager.config.login);
    }

    public void insertPassword() {
        insertPassword(ApplicationManager.config.password);
    }

    public void clickEnter() {
        wd.findElement(PageAuthorizationLocators.buttonEnter).click();
    }

    public String getErrorText() {
        return waitElement(PageAuthorizationLocators.textError).getText();
    }

    public boolean validateErrorText() {
        return getErrorText().equals("Неизвестное имя пользователя. Перепроверьте или попробуйте ваш адрес email.");
    }
}
