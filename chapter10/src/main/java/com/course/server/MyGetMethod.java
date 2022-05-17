package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * @author Yansoul
 * @date 2022/5/8 - 15:19
 * 人生到处知何似，应似飞鸿踏雪泥
 */
@RestController
@Api(value = "/", tags = {"All my GET method"})
public class MyGetMethod {
    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到cookies", httpMethod = "GET")
    public String getCookies(HttpServletResponse response) {
        //HttpServletRequest
        //HttpServletResponse
        Cookie cookie = new Cookie("login", "value");
        response.addCookie(cookie);

        return "恭喜你获得cookies成功";
    }

    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端携带cookies访问", httpMethod = "GET")
    public String getWithCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies))
            return "你必须携带cookies信息来";

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login")
                    && cookie.getValue().equals("true"))
                return "这是一个携带cookies信息才能访问的get请求";
        }
        return "你必须携带cookies信息来";
    }

    @RequestMapping(value = "get/with/param", method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的请求方法1", httpMethod = "GET")
    public Map<String, Integer> getList(@RequestParam Integer start,
                                        @RequestParam Integer end) {
        Map<String, Integer> myList = new HashMap<String, Integer>();
        myList.put("鞋", 400);
        myList.put("小浣熊干脆面", 1);
        myList.put("衬衫", 300);
        return myList;
    }

    @RequestMapping(value = "/get/with/param/{start}/{end}", method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的请求方法2", httpMethod = "GET")
    public Map<String, Integer> myGetList(@PathVariable Integer start,
                                          @PathVariable Integer end) {
        Map<String, Integer> myList = new HashMap<String, Integer>();
        myList.put("鞋", 400);
        myList.put("小浣熊干脆面", 1);
        myList.put("衬衫", 300);
        return myList;
    }
}
