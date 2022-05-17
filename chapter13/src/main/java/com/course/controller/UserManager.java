package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

/**
 * @author Yansoul
 * @date 2022/5/15 - 0:13
 * 人生到处知何似，应似飞鸿踏雪泥
 */
@Slf4j
@RestController
@Api(value = "v1", tags = "UserManager System")
@RequestMapping("/v1")
public class UserManager {
    @Autowired
    private SqlSessionTemplate template;

    @ApiOperation(value = "登录接口", httpMethod = "POST")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean login(HttpServletResponse response,
                         @RequestBody User user) {
        int i = template.selectOne("login", user);
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        log.info("查看到的结果是" + i);
        if (i == 1) {
            return true;
        }

        return false;
    }

    @ApiOperation(value = "添加用户接口",httpMethod = "POST")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public boolean addUser(HttpServletRequest request,@RequestBody User user){
        Boolean x = verifyCookies(request);
        int result = 0;
        if(x != null){
            result = template.insert("addUser",user);
        }
        if(result>0){
            log.info("添加用户的数量是:"+result);
            return true;
        }
        return false;
    }

    @ApiOperation(value = "获取用户（列表）信息接口", httpMethod = "POST")
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public List<User> getUserInfo(HttpServletRequest request,
                                  @RequestBody User user) {
        if (!verifyCookies(request))
            return null;

        List<User> users = template.selectList("getUserInfo", user);
        log.info("getUserInfo获取到的用户数量是" + users.size());
        return users;
    }

    @ApiOperation(value = "更新/删除用户接口", httpMethod = "POST")
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public int updateUser(HttpServletRequest request,
                          @RequestBody User user) {
        if (!verifyCookies(request))
            return 0;

        int result = 0;
        result = template.update("updateUserInfo", user);
        log.info("更新数据的条目数为" + result);
        return result;
    }

    private boolean verifyCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            log.info("cookies为空");
            return false;
        }

        for (Cookie cookie : cookies) {
            if ("login".equals(cookie.getName())
                    && "true".equals(cookie.getValue())) {
                log.info("cookies验证通过");
                return true;
            }
        }
        return false;
    }
}
