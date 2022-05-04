package java.com.course.testng.multiThread;

import org.testng.annotations.Test;

/**
 * @author Yansoul
 * @date 2022/5/3 - 8:55
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class MultiThreadOnXml {
    @Test
    public void test1() {
        System.out.printf("Thread ID: %s%n", Thread.currentThread().getId());
    }

    @Test
    public void test2() {
        System.out.printf("Thread ID: %s%n", Thread.currentThread().getId());
    }

    @Test
    public void test3() {
        System.out.printf("Thread ID: %s%n", Thread.currentThread().getId());
    }
}
