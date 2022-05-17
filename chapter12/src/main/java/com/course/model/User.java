package com.course.model;

import lombok.Data;

/**
 * @author Yansoul
 * @date 2022/5/12 - 15:09
 * 人生到处知何似，应似飞鸿踏雪泥
 */
@Data
public class User {
    private int id;
    private String userName;
    private String password;
    private String age;
    private String sex;
    private String permission;
    private String isDelete;

    @Override
    public String toString() {
        return (
                "{id:" + id + "," +
                        "userName:" + userName + "," +
                        "password:" + password + "," +
                        "age:" + age + "," +
                        "sex:" + sex + "," +
                        "permission:" + permission + "," +
                        "isDelete:" + isDelete + "}"
        );
    }
}
