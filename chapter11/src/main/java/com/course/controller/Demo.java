package com.course.controller;

import com.alibaba.fastjson.JSONObject;
import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yansoul
 * @date 2022/5/11 - 22:33
 * 人生到处知何似，应似飞鸿踏雪泥
 */
@Log4j
@RestController
@Api(value = "v1", tags = {"a demo for first version"})
@RequestMapping("v1")
public class Demo {
    //首先获取一个执行sql语句的对象
    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount", method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到用户数", httpMethod = "GET")
    public int getUserCount() {
        return template.selectOne("getUserCount");
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户", httpMethod = "POST")
    public int addUser(@RequestBody JSONObject user) {
        return template.insert("addUser",user);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ApiOperation(value = "更新数据",httpMethod = "POST")
    public int updateUser(@RequestBody JSONObject user){
        return template.update("updateUser", user);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    @ApiOperation(value = "删除数据",httpMethod = "GET")
    public int deleteUser(@RequestParam int id){
        int result = template.delete("deleteUser",id);
        return result;
    }
}
