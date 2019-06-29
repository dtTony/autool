package indi.tony.autool.core;

import indi.tony.autool.task.DemoTask;
import indi.tony.autool.util.ExcelCommon;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;

public class BaseCase {
    protected DemoTask demotask;
    protected ArrayList<String> data;
    private BaseDriver basedriver;

    @BeforeClass
    public void beforeClass(){
        this.basedriver = new BaseDriver();
        this.demotask = new DemoTask(this.basedriver);
        String childrenClassName = this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".")+1);
        this.data = ExcelCommon.getRow("/Users/didi/Documents/IdeaProjects/autool/src/test/resources/data/data.xls", "sheet1",childrenClassName);
    }

    @AfterClass
    public void afterClass(){
        this.basedriver.closeBrw();
    }
}
