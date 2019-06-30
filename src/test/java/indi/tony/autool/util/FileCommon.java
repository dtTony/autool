package indi.tony.autool.util;

import java.io.File;

public class FileCommon {

    public String generateFolder(String folderPath) {
        File myPath = new File(folderPath);
        if (!myPath.exists()) {//若此目录不存在，则创建之
            myPath.mkdir();
        }
        return myPath.toString();
    }

    public String generateFolderWithAbsolute(String folderPath) {
        File myPath = new File(folderPath);
        if (!myPath.exists()) {//若此目录不存在，则创建之
            myPath.mkdir();
        }
        return myPath.getAbsoluteFile().toString();
    }

    public static void main(String[] args) {
        FileCommon fc = new FileCommon();
        CalendarCommon cc = new CalendarCommon();
        System.out.println(fc.generateFolder("/Users/didi/Documents/IdeaProjects/autool/src/test/screenshot/"+cc.suffixDate()+"/"+"Demo12"+"/"+cc.suffixTime()));
    }
}
