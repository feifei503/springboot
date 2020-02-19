package com.feifei.springboot.listener;

import com.feifei.springboot.controller.TestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @description: session监听器
 * @author: 闲得无聊
 * @date: 2020-02-19 20:54
 **/
@Component
public class MyHttpSessionListener implements HttpSessionListener {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * 记录在线的用户数量
     */
    public Integer count = 0;

    @Override
    public synchronized void sessionCreated(HttpSessionEvent httpSessionEvent) {
        logger.info("新用户上线了");
        count++;
        httpSessionEvent.getSession().getServletContext().setAttribute("count", count);
    }

    @Override
    public synchronized void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        logger.info("用户下线了");
        count--;
        httpSessionEvent.getSession().getServletContext().setAttribute("count", count);
    }
}
