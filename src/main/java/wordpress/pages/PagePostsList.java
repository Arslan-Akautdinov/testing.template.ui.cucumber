package wordpress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import wordpress.PageObject;
import wordpress.locators.PagePostsListLocators;

import java.util.ArrayList;
import java.util.Arrays;

public class PagePostsList extends PageObject {
    public PagePostsList(WebDriver _wd, WebDriverWait _waiter) {
        super(_wd, _waiter);
    }

    public void clickAddPost() {
        waitElement(PagePostsListLocators.buttonAddPost).click();
    }

    public ArrayList<String> selectPosts()
    {
        ArrayList<String> resultList = new ArrayList<>();
        waitElements(PagePostsListLocators.itemPost);
        for (WebElement element: wd.findElements(PagePostsListLocators.itemPost))
        {
            resultList.add(element.getText());
        }
        return resultList;
    }

    public boolean checkPostIsHave(String articleName)
    {
        ArrayList<String> articles = selectPosts();
        return articles.contains(articleName);
    }

}
