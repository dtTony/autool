package indi.tony.autool.core;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseDriver {
    private WebDriver driver;

    public void initWebDriver(String brwType) {

        switch (brwType) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/Users/didi/Documents/IdeaProjects/autool/src/test/resources/drivers/chromedriver");
                this.driver = new ChromeDriver();
                break;
            case "firefox":
            default:
                System.setProperty("webdriver.gecko.driver", "/Users/didi/Documents/IdeaProjects/autool/src/test/resources/drivers/geckodriver");
                this.driver = new FirefoxDriver();
                break;
        }

        this.driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
        this.driver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    void closeBrw() {
        this.driver.quit();
    }

    public void getUrl(String url) {
        this.driver.get(url);
    }

    public WebElement waitAndFindElement(int timeout, By locator) {
        WebDriverWait driverwait = new WebDriverWait(this.driver, timeout);
        return driverwait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void screenFullShot(String filePath, String fileName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(filePath + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
