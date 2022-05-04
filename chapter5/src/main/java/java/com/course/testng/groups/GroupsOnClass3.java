package java.com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * @author Yansoul
 * @date 2022/5/2 - 14:32
 * 人生到处知何似，应似飞鸿踏雪泥
 */
@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void teacher1() {
        System.out.println("teacher1 in class3");
    }

    public void teacher2() {
        System.out.println("teacher2 in class3");
    }
}
