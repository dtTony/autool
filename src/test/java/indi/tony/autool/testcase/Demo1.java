package indi.tony.autool.testcase;

import indi.tony.autool.core.BaseCase;
import org.testng.annotations.Test;

public class Demo1 extends BaseCase{
    @Test
    public void main(){
        System.out.println(data.size());
        for(int i=0;i<data.size();i++){
            demotask.commonAction(data.get(i).split("::"));
        }
    }
}
