package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Yansoul
 * @date 2022/5/9 - 22:57
 * 人生到处知何似，应似飞鸿踏雪泥
 */
@RestController
@Api(value = "/", tags = {"All my POST method"})
@RequestMapping("/v1")
public class MyPostMethod {

    private static Cookie cookie;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookie信息", httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName", required = true) String userName,
                        @RequestParam(value = "password", required = true) String password) {
        if (userName.equals("zhangsan") && password.equals("123456")) {
            cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return "恭喜你登录成功啦";
        }
        return "用户名或密码错误!";
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表", httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                            @RequestBody User u){
        User user = new User();
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            if( "login".equals(cookie.getName())
            && "true".equals(cookie.getValue())
            && "zhangsan".equals(u.getUserName())
            && "123456".equals(u.getPassword())){
                user.setName("lisi");
                user.setAge("18");
                user.setSex("male");
                return user.toString();
            }
        }
        return "参数不合法";
    }
}
