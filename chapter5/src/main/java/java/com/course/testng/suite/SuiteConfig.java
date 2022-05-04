package java.com.course.testng.suite;

import org.testng.annotations.*;

/**
 * @author Yansoul
 * @date 2022/5/2 - 13:40
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class SuiteConfig {

    @BeforeSuite
    public void BeforeSuite() {
        System.out.println("BeforeSuite is running...");
    }

    @AfterSuite
    public void AfterSuite() {
        System.out.println("AfterSuite is running...");
    }

    @BeforeTest
    public void BeforeTest() {
        System.out.println("BeforeTest is running...");
    }

    @AfterTest
    public void AfterTest() {
        System.out.println("AfterTest is running...");
    }
}
