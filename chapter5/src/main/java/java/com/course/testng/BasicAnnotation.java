package java.com.course.testng;

import org.testng.annotations.*;

/**
 * @author Yansoul
 * @date 2022/5/1 - 10:59
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class BasicAnnotation {
    @Test
    public void testCase1() {
        System.out.println("testDemo1...");
    }

    @Test
    public void testCase2() {
        System.out.println("testDemo2...");
    }

    @BeforeMethod
    public void before() {
        System.out.println("BeforeMethod...");
    }

    @AfterMethod
    public void after() {
        System.out.println("AfterMethod...");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass...");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass...");
    }
}
