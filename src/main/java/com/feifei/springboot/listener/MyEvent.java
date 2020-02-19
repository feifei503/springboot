package com.feifei.springboot.listener;

import com.feifei.springboot.entity.TUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @description: 自定义监听器
 * @author: 闲得无聊
 * @date: 2020-02-19 20:59
 **/
@Getter
@Setter
public class MyEvent extends ApplicationEvent {

    private TUser user;

    public MyEvent(Object source, TUser user) {
        super(source);
        this.user = user;
    }

}
