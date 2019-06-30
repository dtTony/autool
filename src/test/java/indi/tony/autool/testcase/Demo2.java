package indi.tony.autool.testcase;

import indi.tony.autool.core.BaseCase;
import org.testng.annotations.Test;

public class Demo2 extends BaseCase{
    @Test
    public void main(){
        for(int i=0;i<data.size();i++){
            String steps = "Step" + i;
            commontask.commonAction(data.get(i).split("::"), steps);
        }
    }
}
