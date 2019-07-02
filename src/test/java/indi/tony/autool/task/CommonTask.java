package indi.tony.autool.task;

import indi.tony.autool.core.Assertion;
import indi.tony.autool.core.BaseDriver;
import indi.tony.autool.object.CommonPage;
import org.openqa.selenium.WebElement;

public class CommonTask {
    private BaseDriver basedriver;
    private CommonPage commonpage;
    private String screenpath;

    public CommonTask(BaseDriver driver, String screenPath) {
        this.basedriver = driver;
        this.screenpath = screenPath;
        commonpage = new CommonPage(this.basedriver);
    }

    public void commonAction(String[] operation, String steps) {
        if (operation.length > 1) {
            if (operation[0].toLowerCase().trim().equals("brw")) {
                this.basedriver.initWebDriver(operation[1].trim());
            } else if (operation[0].toLowerCase().trim().equals("url")) {
                this.basedriver.getUrl(operation[1]);
            } else if (operation[0].toLowerCase().trim().equals("verify-attr")) {
                Assertion.verifyEquals(commonpage.getElementAttrByLocator(operation[2].toLowerCase().trim(), operation[3].trim(), operation[1].trim()), operation[4]);
                System.out.println("testing");
            } else {
                WebElement element;
                element = commonpage.getElementByLocator(operation[0].toLowerCase().trim(), operation[1].trim());
                doAction(element, operation, steps);
            }
        }
    }

    private void doAction(WebElement element, String[] operation, String steps) {
        if (element != null)
            switch (operation[2].toLowerCase().trim()) {
                case "input":
                    element.sendKeys(operation[3].trim());
                    this.basedriver.screenFullShot(this.screenpath, steps);
                    break;
                case "bt":
                    this.basedriver.screenFullShot(this.screenpath, steps);
                    element.click();
                    break;
            }
    }
}
