package indi.tony.autool.core;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Assertion {

    static boolean flag = true;

    static List<Error> errors = new ArrayList<>();

    public static void verifyEquals(Object actual, Object expected){
        try{
            Assert.assertEquals(actual, expected);
        }catch(Error e){
            errors.add(e);
            flag = false;
        }
    }

    public static void verifyEquals(Object actual, Object expected, String message){
        try{
            Assert.assertEquals(actual, expected, message);
        }catch(Error e){
            errors.add(e);
            flag = false;
        }
    }

}


