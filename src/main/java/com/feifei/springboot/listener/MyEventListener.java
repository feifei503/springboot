package com.feifei.springboot.listener;

import com.feifei.springboot.entity.TUser;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @description: 自定义监听器，监听MyEvent事件
 * @author: 闲得无聊
 * @date: 2020-02-19 21:08
 **/
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {


    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        // 把事件中的信息获取到
        TUser user = myEvent.getUser();
        // 处理事件，实际项目中可以通知别的微服务或者处理其他逻辑等等
        System.out.println("用户名：" + user.getUsername());
        System.out.println("密码：" + user.getPassword());
    }
}
