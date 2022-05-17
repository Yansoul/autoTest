package com.course.httpClient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Yansoul
 * @date 2022/5/6 - 16:27
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    private CookieStore cookieStore;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void TestGetCookies() throws IOException {
        String result;
        cookieStore = new BasicCookieStore();
        HttpGet get = new HttpGet(this.url + bundle.getString("test.getCookies.uri"));

        HttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        //获取cookies信息
        List<Cookie> cookieList = cookieStore.getCookies();
        for(Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name=" + name + "\tvalue=" + value);
        }
    }

    @Test(dependsOnMethods = {"TestGetCookies"})
    public void testGetWithCookies() throws Exception {
        String result;
        HttpGet get = new HttpGet(this.url + bundle.getString("test.get.with.cookies"));

        HttpClient client = HttpClients.custom().setDefaultCookieStore(this.cookieStore).build();
        HttpResponse response = client.execute(get);

        //获取响应状态码
        int statusCode = response.getStatusLine().getStatusCode();

        if(statusCode == 200) {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(result);
        }
    }

}
