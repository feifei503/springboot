package com.feifei.springboot.controller;

import com.feifei.springboot.dto.ConfigServiceUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 获取配置参数
 * @author: 闲得无聊
 * @date: 2020-02-18 21:04
 **/
@RestController
@RequestMapping("test")
public class TestConfigController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestConfigController.class);

    @Value("${url.orderUrl}")
    private String orderUrl;

    @Resource
    private ConfigServiceUrl configServiceUrl;

    @RequestMapping("/config")
    public String testConfig() {
        LOGGER.info("=====获取的订单服务地址为：{}", orderUrl);
        return "success";
    }

    @RequestMapping("/allconfig")
    public String allconfig() {
        LOGGER.info("=====获取的订单服务地址为：{}", configServiceUrl.getOrderUrl());
        LOGGER.info("=====获取的用户服务地址为：{}", configServiceUrl.getUserUrl());
        LOGGER.info("=====获取的购物车服务地址为：{}", configServiceUrl.getShoppingUrl());

        return "success";
    }

}
