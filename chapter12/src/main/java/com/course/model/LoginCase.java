package com.course.model;

import lombok.Data;

/**
 * @author Yansoul
 * @date 2022/5/12 - 16:40
 * 人生到处知何似，应似飞鸿踏雪泥
 */
@Data
public class LoginCase {
    private int id;
    private String userName;
    private String password;
    private String expected;
}
