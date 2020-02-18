package com.feifei.springboot.controller;

import com.feifei.springboot.dto.User;
import com.feifei.springboot.result.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/json")

public class JsonController {

    private static final Logger logger = LoggerFactory.getLogger(JsonController.class);



    @RequestMapping("/user")
    public User getUser() {
        return new User(1L, "倪升武", "123456");
    }

    @RequestMapping("/userV1")
    public JsonResult<User> getUserV2(){
        User user = new User(1L, "倪升武", "123456");
        return new JsonResult<>(user);
    }

    @RequestMapping("/list")
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        User user1 = new User(1L, "倪升武", "123456");
        User user2 = new User(2L, "达人课", "123456");
        userList.add(user1);
        userList.add(user2);
        return userList;
    }

    @RequestMapping("/listV1")
    public JsonResult<List> getUserListV1() {
        List<User> userList = new ArrayList<>();
        User user1 = new User(1L, "倪升武", "123456");
        User user2 = new User(2L, "达人课", "123456");
        userList.add(user1);
        userList.add(user2);
        return new JsonResult<>(userList, "获取用户列表成功");
    }

    @RequestMapping("/map")
    public JsonResult<Map> getMap() {
        Map<String, Object> map = new HashMap<>(3);
        User user = new User(1L, "倪升武", null);
        map.put("作者信息", user);
        map.put("博客地址", "http://blog.itcodai.com");
        map.put("CSDN地址", "http://blog.csdn.net/eson_15");
        map.put("粉丝数量", 4153);
        return new JsonResult<>(map);
    }

    @RequestMapping("/log")
    public String testLog() {
        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");

        // 可以使用占位符打印出一些参数信息
        String str1 = "blog.itcodai.com";
        String str2 = "blog.csdn.net/eson_15";
        logger.info("======倪升武的个人博客：{}；倪升武的CSDN博客：{}", str1, str2);

        return "success";
    }


}
