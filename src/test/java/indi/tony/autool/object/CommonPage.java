package indi.tony.autool.object;

import indi.tony.autool.core.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommonPage {
    private BaseDriver basedriver;

    public CommonPage(BaseDriver driver) {
        this.basedriver = driver;
    }

    public WebElement getByID(String value) {
        return this.basedriver.waitAndFindElement(3, By.id(value));
    }

    public WebElement getByName(String value) {
        return this.basedriver.waitAndFindElement(3, By.name(value));
    }

    public WebElement getByTag(String value) {
        return this.basedriver.waitAndFindElement(3, By.tagName(value));
    }

    public WebElement getByXpath(String value) {
        return this.basedriver.waitAndFindElement(3, By.xpath(value));
    }

    public WebElement getByClass(String value) {
        return this.basedriver.waitAndFindElement(3, By.className(value));
    }

    public WebElement getByCssSelector(String value) {
        return this.basedriver.waitAndFindElement(3, By.cssSelector(value));
    }

    public WebElement getByLinkText(String value) {
        return this.basedriver.waitAndFindElement(3, By.linkText(value));
    }

    public WebElement getByPartialLinkText(String value) {
        return this.basedriver.waitAndFindElement(3, By.partialLinkText(value));
    }
}
