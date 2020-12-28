package base;

import common.ApplicationManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wordpress.PageClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class BasicTest {

    protected WebDriver driver;
    protected PageClient pages;
    protected void screen()  {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        InputStream targetStream = null;
        try {
            targetStream = new FileInputStream(screenshot);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Allure.addAttachment("Screenshot on fail", "image/png", targetStream, "png");
    }

    protected ChromeOptions chromeOptions = new ChromeOptions();{
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--ignore-certificate-errors");
    }

    protected void setUp() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver(chromeOptions);
        this.driver.get(ApplicationManager.config.url);
        this.pages = new PageClient(this.driver, new WebDriverWait(this.driver, 10));
    }

    protected void tearDown()
    {
        this.driver.quit();
    }
}
