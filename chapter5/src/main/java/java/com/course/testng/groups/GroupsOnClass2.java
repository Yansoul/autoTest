package java.com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * @author Yansoul
 * @date 2022/5/2 - 14:32
 * 人生到处知何似，应似飞鸿踏雪泥
 */
@Test(groups = "stu")
public class GroupsOnClass2 {
    public void stu1() {
        System.out.println("stu1 in class2");
    }

    public void stu2() {
        System.out.println("stu2 in class2");
    }
}
