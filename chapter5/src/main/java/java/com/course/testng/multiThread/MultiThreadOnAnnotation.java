package java.com.course.testng.multiThread;

import org.testng.annotations.Test;

/**
 * @author Yansoul
 * @date 2022/5/3 - 8:48
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class MultiThreadOnAnnotation {
    @Test(invocationCount = 10, threadPoolSize = 3)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread ID: %s%n", Thread.currentThread().getId());
    }
}
