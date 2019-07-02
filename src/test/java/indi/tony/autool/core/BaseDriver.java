package indi.tony.autool.core;

import indi.tony.autool.util.PropertiesCommon;
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
    private PropertiesCommon pc;

    BaseDriver(PropertiesCommon pc){
        this.pc = pc;
    }

    public void initWebDriver(String brwType) {

        switch (brwType) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", pc.getValue("webdriver.chrome.driver"));
                this.driver = new ChromeDriver();
                break;
            case "firefox":
            default:
                System.setProperty("webdriver.gecko.driver", pc.getValue("webdriver.gecko.driver"));
                this.driver = new FirefoxDriver();
                break;
        }
        this.driver.manage().window().fullscreen();
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

    public String waitAndGetElementAttr(int timeout, By locator, String attr){
        WebDriverWait driverwait = new WebDriverWait(this.driver, timeout);
        return driverwait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute(attr);
    }

    public String waitAndGetElementText(int timeout, By locator){
        WebDriverWait driverwait = new WebDriverWait(this.driver, timeout);
        return driverwait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public void screenFullShot(String filePath, String fileName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(filePath + "/"+ fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
