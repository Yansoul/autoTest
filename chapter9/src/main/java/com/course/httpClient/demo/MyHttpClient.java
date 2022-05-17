package com.course.httpClient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author Yansoul
 * @date 2022/5/6 - 9:56
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class MyHttpClient {

    @Test
    public void test1() throws IOException {
        //用来存放返回的结果
        String result;
        HttpGet get = new HttpGet("http://www.baidu.com");
        //用来执行get方法
        HttpClient client = HttpClientBuilder.create().build();;
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
    }
}
