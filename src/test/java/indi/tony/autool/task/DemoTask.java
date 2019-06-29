package indi.tony.autool.task;

import indi.tony.autool.core.BaseDriver;
import indi.tony.autool.object.DemoPage;
import org.openqa.selenium.WebElement;

public class DemoTask {
    private BaseDriver basedriver;
    private DemoPage demopage;

    public DemoTask(BaseDriver driver){
        this.basedriver = driver;
        demopage = new DemoPage(this.basedriver);
    }

    public void commonAction(String[] operation){
        if(operation.length == 2){
            if(operation[0].toLowerCase().trim().equals("brw")){
                this.basedriver.initWebDriver(operation[1].trim());
            }else if(operation[0].toLowerCase().trim().equals("url")){
                this.basedriver.getUrl(operation[1]);
            }
        }else if(operation.length == 4){
            WebElement element = null;
            switch (operation[0]){
                case "id":
                    element = demopage.getByID(operation[1].trim());
                    break;
                case "name":
                    element = demopage.getByName(operation[1].trim());
                    break;
                case "tag":
                    element = demopage.getByTag(operation[1].trim());
                    break;
                case "xpath":
                    element = demopage.getByXpath(operation[1].trim());
                    break;
            }
            if(element != null)
                switch (operation[2]){
                    case "input":
                        element.sendKeys(operation[3].trim());
                        this.basedriver.screenFullShot("src/test/captures/", "demo1");
                        break;
                    case "bt":
                        element.click();
                        break;
                }
        }
    }
}
