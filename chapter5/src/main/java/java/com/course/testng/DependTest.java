package java.com.course.testng;

import org.testng.annotations.Test;

/**
 * @author Yansoul
 * @date 2022/5/2 - 15:41
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class DependTest {
    @Test
    public void test1(){
        System.out.println("test1 executed");
//        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 executed");
    }
}
