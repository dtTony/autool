package indi.tony.autool.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarCommon {

    public String suffixDate() {
        Calendar today = Calendar.getInstance();
        return today.get(Calendar.YEAR) + "-" + (today.get(Calendar.MONTH) + 1) + "-" + today.get(Calendar.DATE);
    }

    public String suffixTime() {
        Calendar today = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH-MM-SS");
        return dateFormat.format(today.getTime());
    }

    public static void main(String[] args) {
        CalendarCommon cc = new CalendarCommon();
        System.out.println(cc.suffixTime());
    }
}
