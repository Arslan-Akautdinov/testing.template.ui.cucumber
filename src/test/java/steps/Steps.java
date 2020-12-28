package steps;

import base.BasicTest;
import com.codeborne.selenide.Screenshots;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import wordpress.enums.WPMenu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.DriverManager;

public class Steps extends BasicTest {

    @Before
    public void before() {
        setUp();
    }

    @After
    public void after() {
        tearDown();
    }


    @Когда("я ввожу логин {string} и пароль {string}")
    public void authorize(String arg0, String arg1) {
        pages.pageAuthorization.actionAuthorize(arg0, arg1);
    }

    @То("попадаю на главную страницу сайта")
    public void authorizeCheckTrue() {
        Assertions.assertTrue(pages.barHeader.isLogin());
        screen();
    }

    @То("Получаю ошибку < Неизвестное имя пользователя. Перепроверьте или попробуйте ваш адрес email. >")
    public void authorizeCheckFalse()  {
        Assertions.assertTrue(pages.barHeader.isNotLogin());
        Assertions.assertTrue(pages.pageAuthorization.validateErrorText());
        screen();
    }

    @Когда("я перехожу на страницу статей")
    public void goToPostPage() {
        pages.barNavigation.navigateTo(WPMenu.POSTS);
    }

    @И("нажимаю на кнопку <создать новую статью> закрыв модальное окно")
    public void clickCreatePost() {
        pages.pagePostsList.clickAddPost();
        pages.pagePostEdit.clickCloseModal();
        screen();
    }

    @И("ввожу наименование статьи {string}")
    public void insertPostName(String arg0) {
        pages.pagePostEdit.insertPostTitle(arg0);
        screen();
    }

    @И("нажимаю на кнопку опубликовать")
    public void clickPublish() {
        pages.pagePostEdit.clickPublish();
        screen();
    }

    @И("подтверждаю публикацию")
    public void clickPublishAccept() {
        pages.pagePostEdit.clickPublishAccept();
        screen();
    }

    @И("из страницы редактирования статьи выхожу в меню статей")
    public void navigateToPostsList() {
        pages.pagePostEdit.navigateToPostsList();
    }

    @Тогда("наблюдаю созданную статью с наименованием {string}")
    public void checkPostIsHave(String arg0) {
        pages.pagePostsList.checkPostIsHave(arg0);
        screen();
    }
}
