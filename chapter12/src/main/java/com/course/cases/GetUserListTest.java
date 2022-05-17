package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserListCase;
import com.course.model.User;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author Yansoul
 * @date 2022/5/14 - 11:33
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class GetUserListTest {
    @Test(dependsOnGroups = "loginTrue", description = "获取用户性别为男的用户信息")
    public void getUserList() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        GetUserListCase getUserListCase = sqlSession.selectOne("getUserListCase", 1);
        System.out.println(getUserListCase.toString());
        System.out.println(TestConfig.getUserListUrl);

        //发送请求获取结果
        JSONArray result = getJsonResult(getUserListCase);

        //验证
        List<User> userList = sqlSession.selectList(getUserListCase.getExpected(), getUserListCase);
        for (User user : userList) {
            System.out.println("获取的user：" + user.toString());
        }
        JSONArray userListJson = new JSONArray(userList);
        Assert.assertEquals(userListJson.length(), result.length());
        for (int i = 0; i < userListJson.length(); i++) {
            JSONObject expect = (JSONObject) result.get(i);
            JSONObject actual = (JSONObject) userListJson.get(i);
            Assert.assertEquals(expect.toString(), actual.toString());
        }
    }

    private JSONArray getJsonResult(GetUserListCase getUserListCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.getUserListUrl);
        JSONObject param = new JSONObject();
        param.put("userName", getUserListCase.getUserName());
        param.put("sex", getUserListCase.getSex());
        param.put("age", getUserListCase.getAge());
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        String result;
        HttpResponse response = TestConfig.httpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");

        System.out.println("result is: "+ result);

        JSONArray jsonArray = new JSONArray(result);
        return jsonArray;
    }
}
