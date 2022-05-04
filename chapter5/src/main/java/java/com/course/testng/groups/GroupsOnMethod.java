package java.com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * @author Yansoul
 * @date 2022/5/2 - 14:14
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class GroupsOnMethod {
    @Test(groups = "server")
    public void test1() {
        System.out.println("1 in serverGroup");
    }

    @Test(groups = "server")
    public void test2() {
        System.out.println("2 in serverGroup");
    }

    @Test(groups = "client")
    public void test3() {
        System.out.println("3 in clientGroup");
    }

    @Test(groups = "client")
    public void test4() {
        System.out.println("4 in clientGroup");
    }
}
