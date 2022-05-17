package com.tester.extent.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * @author Yansoul
 * @date 2022/5/4 - 16:14
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class TestMethodsDemo {

    @Test
    public void test1() {
        Assert.assertEquals(1,2);

    }

    @Test
    public void test2() {
        Assert.assertEquals(1,1);
    }

    @Test
    public void test3() {
        Assert.assertEquals("aaa","aaa");
    }

    @Test
    public void logDemo() {
        Reporter.log("a log which we wrote");
        throw new RuntimeException("an exception wo wrote");
    }
}
