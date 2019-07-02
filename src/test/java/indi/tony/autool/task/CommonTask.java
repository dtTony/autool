package indi.tony.autool.task;

import indi.tony.autool.core.Assertion;
import indi.tony.autool.core.BaseDriver;
import indi.tony.autool.object.CommonPage;
import org.openqa.selenium.WebElement;

public class CommonTask {
    private BaseDriver basedriver;
    private CommonPage common_page;
    private String screen_path;

    public CommonTask(BaseDriver driver, String screenPath) {
        this.basedriver = driver;
        this.screen_path = screenPath;
        common_page = new CommonPage(this.basedriver);
    }

    public void commonAction(String[] operation, String steps) {
        if (operation.length > 1) {
            switch (operation[0].toLowerCase().trim()) {
                case "brw":
                    this.basedriver.initWebDriver(operation[1].trim());
                    break;
                case "url":
                    this.basedriver.getUrl(operation[1]);
                    break;
                case "verify-attr":
                    Assertion.verifyEquals(common_page.getElementAttrByLocator(operation[2].toLowerCase().trim(), operation[3].trim(), operation[1].trim()), operation[4]);
                    break;
                case "verify-text":
                    Assertion.verifyEquals(common_page.getElementTextByLocator(operation[1].toLowerCase().trim(), operation[2].trim()), operation[3]);
                    break;
                default:
                    WebElement element;
                    element = common_page.getElementByLocator(operation[0].toLowerCase().trim(), operation[1].trim());
                    doAction(element, operation, steps);
                    break;
            }
        }
    }

    private void doAction(WebElement element, String[] operation, String steps) {
        if (element != null)
            switch (operation[2].toLowerCase().trim()) {
                case "input":
                    element.sendKeys(operation[3].trim());
                    this.basedriver.screenFullShot(this.screen_path, steps);
                    break;
                case "bt":
                    this.basedriver.screenFullShot(this.screen_path, steps);
                    element.click();
                    break;
            }
    }
}
