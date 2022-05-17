package com.course.model;

import lombok.Data;

/**
 * @author Yansoul
 * @date 2022/5/12 - 16:38
 * 人生到处知何似，应似飞鸿踏雪泥
 */
@Data
public class GetUserListCase {
    private String userName;
    private String age;
    private String sex;
    private String expected;
}
