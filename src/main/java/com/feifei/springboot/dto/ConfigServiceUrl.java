package com.feifei.springboot.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description: 多个配置参数获取
 * @author: 闲得无聊
 * @date: 2020-02-18 21:08
 **/
@Component
@ConfigurationProperties(prefix = "url")
@Getter
@Setter
public class ConfigServiceUrl {

    private String orderUrl;
    private String userUrl;
    private String shoppingUrl;
    // 省去get和set方法

}
