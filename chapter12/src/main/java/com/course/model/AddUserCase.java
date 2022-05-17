package com.course.model;

import lombok.Data;

/**
 * @author Yansoul
 * @date 2022/5/12 - 16:36
 * 人生到处知何似，应似飞鸿踏雪泥
 */
@Data
public class AddUserCase {
    private String userName;
    private String password;
    private String sex;
    private String age;
    private String permission;
    private String isDelete;
    private String expected;
}
