package com.feifei.springboot.controller;

import com.feifei.springboot.dto.User;
import com.feifei.springboot.entity.TUser;
import com.feifei.springboot.result.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @description 测试
 * @author 闲得无聊
 * @date 2020/2/19
 */
@RestController
@RequestMapping(value = "/test", produces = "application/json; charset=UTF-8")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "sayHello")
    public void sayHello(){
        System.out.println("hello");
    }

    /**
     * value 属性：指定请求的实际地址，value 可以省略不写
     * method 属性：指定请求的类型，主要有 GET、PUT、POST、DELETE，默认为 GET
     * produces属性：指定返回内容类型，如 produces = "application/json; charset=UTF-8"
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get(){
        return "success";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public JsonResult post(){
        return new JsonResult(null);
    }

    @PostMapping("/postV1")
    public JsonResult postV1(){
        return new JsonResult(null);
    }

    @GetMapping(value = "/user/{id}")
    public String testPathVariable(@PathVariable(value = "id") Integer idd){
        logger.info("获取到的id为{}", idd);
        return "success";
    }

    @GetMapping(value = "/user/{id}/{name}")
    public String testTooPathVariable(@PathVariable(value = "id") Integer idd, @PathVariable(value = "name") String name){
        logger.info("获取到的id为{},name为{}", idd, name);
        return "success";
    }

    /**
     * required 属性：true 表示该参数必须要传，否则就会报 404 错误，false 表示可有可无。
     * defaultValue 属性：默认值，表示如果请求中没有同名参数时的默认值。
     */
    @GetMapping("/testRequestParam")
    public String testRequestParam(@RequestParam Integer id) {
        System.out.println("获取到的id为：" + id);
        return "success";
    }

    @RequestMapping("/testRequestParamV2")
    public String testRequestParamV2(@RequestParam(value = "idd", required = false) Integer id) {
        System.out.println("获取到的id为：" + id);
        return "success";
    }

    @PostMapping("/testForm")
    public String testForm(@RequestParam String username, @RequestParam String password) {
        System.out.println("获取到的username为：" + username);
        System.out.println("获取到的password为：" + password);
        return "success";
    }

    /**
     * 很多参数 用实体接收
     */
    @PostMapping("/testFormV2")
    public String testFormV2(User user) {
        System.out.println("获取到的username为：" + user.getUsername());
        System.out.println("获取到的password为：" + user.getPassword());
        return "success";
    }

    @PostMapping("/testRequestBody")
    public String testRequestBody(@RequestBody User user) {
        System.out.println("获取到的username为：" + user.getUsername());
        System.out.println("获取到的password为：" + user.getPassword());
        return "success";
    }

    @GetMapping("/user")
    public TUser getUser(HttpServletRequest request) {
        ServletContext application = request.getServletContext();
        return (TUser) application.getAttribute("user");
    }

    /**
     * 获取当前在线人数，该方法有bug
     * @param request
     * @return
     */
    @GetMapping("/total")
    public String getTotalUser(HttpServletRequest request) {
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数：" + count;
    }

    @GetMapping("/total2")
    public String getTotalUser(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie;
        try {
            // 把sessionId记录在浏览器中
            cookie = new Cookie("JSESSIONID", URLEncoder.encode(request.getSession().getId(), "utf-8"));
            cookie.setPath("/");
            //设置cookie有效期为2天，设置长一点
            cookie.setMaxAge( 48*60 * 60);
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数：" + count;
    }

    @GetMapping("/request")
    public String getRequestInfo(HttpServletRequest request) {
        System.out.println("requestListener中的初始化的name数据：" + request.getAttribute("name"));
        return "success";
    }

    @GetMapping("/requestV1")
    public String getRequestInfoV1(HttpServletRequest request) {
        System.out.println("requestListener中的初始化的name数据：" + request.getAttribute("name"));
        return "success";
    }


}
