package com.course.model;

import lombok.Data;

/**
 * @author Yansoul
 * @date 2022/5/12 - 16:41
 * 人生到处知何似，应似飞鸿踏雪泥
 */
@Data
public class UpdateUserInfoCase {
    private int id;
    private int userId;
    private String userName;
    private String sex;
    private String age;
    private String permission;
    private String isDelete;
    private String expected;
}
