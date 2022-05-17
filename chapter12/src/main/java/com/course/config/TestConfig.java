package com.course.config;

import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * @author Yansoul
 * @date 2022/5/12 - 16:50
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class TestConfig {
    public static String loginUrl;
    public static String updateUserInfoUrl;
    public static String getUserInfoUrl;
    public static String getUserListUrl;
    public static String addUserUrl;

    public static HttpClient httpClient;
    public static CookieStore store;
}
