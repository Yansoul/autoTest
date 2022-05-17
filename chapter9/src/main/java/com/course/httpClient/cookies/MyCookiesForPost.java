package com.course.httpClient.cookies;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Yansoul
 * @date 2022/5/6 - 23:22
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    private CookieStore cookieStore;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws Exception {
        String result;
        cookieStore = new BasicCookieStore();
        HttpGet get = new HttpGet(this.url + bundle.getString("test.getCookies.uri"));

        HttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        List<Cookie> cookiesList = cookieStore.getCookies();
        for (Cookie cookie : cookiesList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name=" + name + "\tvalue=" + value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostMethode() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        String testUrl = this.url + uri;

        //声明一个client对象，用来进行方法的执行
        HttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        //声明一个post方法
        HttpPost post = new HttpPost(testUrl);

        //添加参数（JSON格式）
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");

        //设置请求信息
        post.setHeader("Content-Type", "application/json");

        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        //执行post请求
        HttpResponse response = client.execute(post);

        //获取响应结果
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);

        //处理结果 再将响应结果转化为json对象
        JSONObject resultJson = JSON.parseObject(result);

        //获取并判断返回的结果值
        String success = (String) resultJson.get("huhansan");
        Assert.assertEquals(success,"success");

        String status = (String) resultJson.get("status");
        Assert.assertEquals(status,"1");
    }
}
