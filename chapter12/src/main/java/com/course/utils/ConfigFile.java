package com.course.utils;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Yansoul
 * @date 2022/5/12 - 16:52
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class ConfigFile {
    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(InterfaceName name){
        String address = bundle.getString("test.url");
        String uri = "";

        switch(name){
            case ADD_USER_INFO -> uri = bundle.getString("addUser.uri");
            case GET_USER_INFO -> uri = bundle.getString("getUserInfo.uri");
            case UPDATE_USER_INFO -> uri = bundle.getString("updateUserInfo.uri");
            case LOGIN -> uri = bundle.getString("login.uri");
            case GET_USER_LIST -> uri = bundle.getString("getUserList.uri");
        }

        String testUrl = address + uri;
        return testUrl;
    }
}
