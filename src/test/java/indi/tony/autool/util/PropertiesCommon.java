package indi.tony.autool.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesCommon {
    private String filePath;

    public PropertiesCommon(String filePath){
        this.filePath = filePath;
    }

    public String getValue(String key){
        String value = "";
        Properties pro = new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream(this.filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            pro.load(in);
            value = pro.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void main(String args[]){
        PropertiesCommon pc = new PropertiesCommon("src/test/resources/conf/main.properties");
        System.out.println(pc.getValue("webdriver.chrome.driver"));
    }
}
