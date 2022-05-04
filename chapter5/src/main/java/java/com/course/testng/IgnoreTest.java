package java.com.course.testng;

import org.testng.annotations.Test;

/**
 * @author Yansoul
 * @date 2022/5/2 - 14:03
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class IgnoreTest {
    @Test
    public void Ignore1() {
        System.out.println("Ignore1 executed!");
    }

    @Test(enabled = false)
    public void Ignore2() {
        System.out.println("Ignore2 executed!");
    }

    @Test
    public void Ignore3() {
        System.out.println("Ignore3 executed!");
    }
}
