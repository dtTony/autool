package indi.tony.autool.task;

import indi.tony.autool.core.BaseDriver;
import indi.tony.autool.object.CommonPage;
import org.openqa.selenium.WebElement;

public class CommonTask {
    private BaseDriver basedriver;
    private CommonPage commonpage;
    private String screenPath;

    public CommonTask(BaseDriver driver, String screenPath) {
        this.basedriver = driver;
        this.screenPath = screenPath;
        commonpage = new CommonPage(this.basedriver);
    }

    public void commonAction(String[] operation, String steps) {
        if (operation.length == 2) {
            if (operation[0].toLowerCase().trim().equals("brw")) {
                this.basedriver.initWebDriver(operation[1].trim());
            } else if (operation[0].toLowerCase().trim().equals("url")) {
                this.basedriver.getUrl(operation[1]);
            }
        } else if (operation.length == 4) {
            WebElement element = null;
            switch (operation[0]) {
                case "id":
                    element = commonpage.getByID(operation[1].trim());
                    break;
                case "name":
                    element = commonpage.getByName(operation[1].trim());
                    break;
                case "tag":
                    element = commonpage.getByTag(operation[1].trim());
                    break;
                case "xpath":
                    element = commonpage.getByXpath(operation[1].trim());
                    break;
            }
            if (element != null)
                switch (operation[2]) {
                    case "input":
                        element.sendKeys(operation[3].trim());
                        this.basedriver.screenFullShot(this.screenPath, steps);
                        break;
                    case "bt":
                        this.basedriver.screenFullShot(this.screenPath, steps);
                        element.click();
                        break;
                }
        }
    }
}
