package indi.tony.autool.object;

import indi.tony.autool.core.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommonPage {
    private BaseDriver basedriver;

    public CommonPage(BaseDriver driver) {
        this.basedriver = driver;
    }

    public WebElement getElementByLocator(String key,String locator){
        WebElement element = null;
        switch (key) {
            case "id":
                element = this.basedriver.waitAndFindElement(3, By.id(locator));
                break;
            case "name":
                element = this.basedriver.waitAndFindElement(3, By.name(locator));
                break;
            case "tag":
                element = this.basedriver.waitAndFindElement(3, By.tagName(locator));
                break;
            case "xpath":
                element = this.basedriver.waitAndFindElement(3, By.xpath(locator));
                break;
            case "css":
                element = this.basedriver.waitAndFindElement(3, By.cssSelector(locator));
                break;
            case "class":
                element = this.basedriver.waitAndFindElement(3, By.className(locator));
                break;
            case "linktext":
                element = this.basedriver.waitAndFindElement(3, By.linkText(locator));
                break;
            case "partiallinktext":
                element = this.basedriver.waitAndFindElement(3, By.partialLinkText(locator));
                break;
        }
        return element;
    }

    public String getElementAttrByLocator(String key,String locator, String attr){
        String element_attr = null;
        switch (key) {
            case "id":
                element_attr = this.basedriver.waitAndGetElementAttr(3, By.id(locator), attr);
                break;
            case "name":
                element_attr = this.basedriver.waitAndGetElementAttr(3, By.name(locator), attr);
                break;
            case "tag":
                element_attr = this.basedriver.waitAndGetElementAttr(3, By.tagName(locator), attr);
                break;
            case "xpath":
                element_attr = this.basedriver.waitAndGetElementAttr(3, By.xpath(locator), attr);
                break;
            case "css":
                element_attr = this.basedriver.waitAndGetElementAttr(3, By.cssSelector(locator), attr);
                break;
            case "class":
                element_attr = this.basedriver.waitAndGetElementAttr(3, By.className(locator), attr);
                break;
            case "linktext":
                element_attr = this.basedriver.waitAndGetElementAttr(3, By.linkText(locator), attr);
                break;
            case "partiallinktext":
                element_attr = this.basedriver.waitAndGetElementAttr(3, By.partialLinkText(locator), attr);
                break;
        }
        return element_attr;
    }

    public String getElementTextByLocator(String key,String locator){
        String element_text = null;
        switch (key) {
            case "id":
                element_text = this.basedriver.waitAndGetElementText(3, By.id(locator));
                break;
            case "name":
                element_text = this.basedriver.waitAndGetElementText(3, By.name(locator));
                break;
            case "tag":
                element_text = this.basedriver.waitAndGetElementText(3, By.tagName(locator));
                break;
            case "xpath":
                element_text = this.basedriver.waitAndGetElementText(3, By.xpath(locator));
                break;
            case "css":
                element_text = this.basedriver.waitAndGetElementText(3, By.cssSelector(locator));
                break;
            case "class":
                element_text = this.basedriver.waitAndGetElementText(3, By.className(locator));
                break;
            case "linktext":
                element_text = this.basedriver.waitAndGetElementText(3, By.linkText(locator));
                break;
            case "partiallinktext":
                element_text = this.basedriver.waitAndGetElementText(3, By.partialLinkText(locator));
                break;
        }
        return element_text;
    }
}
