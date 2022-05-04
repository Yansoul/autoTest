package java.com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Yansoul
 * @date 2022/5/2 - 15:54
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class ParameterTest {
    @Test(dataProvider = "data")
    public void paramTest1(String name, int age){
        System.out.println(name + " " + age);
    }

    @DataProvider(name = "data")
    public Object[][] provideData(){
        Object[][] o = new Object[][]{
                {"yansoul",10},
                {"yanyan",20},
                {"yy",30}
        };

        return o;
    }
}
