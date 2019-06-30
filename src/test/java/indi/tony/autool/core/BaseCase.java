package indi.tony.autool.core;

import indi.tony.autool.task.CommonTask;
import indi.tony.autool.util.CalendarCommon;
import indi.tony.autool.util.ExcelCommon;
import indi.tony.autool.util.FileCommon;
import indi.tony.autool.util.PropertiesCommon;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;

public class BaseCase {
    protected CommonTask commontask;
    protected ArrayList<String> data;
    private BaseDriver basedriver;

    @BeforeClass
    public void beforeClass() {
        CalendarCommon cc = new CalendarCommon();
        FileCommon fc = new FileCommon();
        PropertiesCommon pc = new PropertiesCommon("src/test/resources/conf/main.properties");
        String childrenClassName = this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1);
        this.data = ExcelCommon.getRow(pc.getValue("data.excel.path"), pc.getValue("data.excel.sheet"), childrenClassName);
        String screenPath = fc.generateFolder(pc.getValue("screen.folder.path") + cc.suffixDate() + "/" + childrenClassName + "-" + cc.suffixTime());
        this.basedriver = new BaseDriver(pc);
        this.commontask = new CommonTask(this.basedriver, screenPath);


    }

    @AfterClass
    public void afterClass() {
        this.basedriver.closeBrw();
    }
}
