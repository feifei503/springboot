package com.feifei.springboot.service.impl;

import com.feifei.springboot.dao.TUserMapper;
import com.feifei.springboot.entity.TUser;
import com.feifei.springboot.listener.MyEvent;
import com.feifei.springboot.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @description: 用户service
 * @author: 闲得无聊
 * @date: 2020-02-19 18:41
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private TUserMapper userMapper;

    @Resource
    private ApplicationContext applicationContext;

    @Override
    public TUser getUserById(Long id) {

        return userMapper.selectByPrimaryKey(id);
    }


    @Override
    @Transactional
    public void insertUser(TUser user){
        userMapper.insert(user);
        throw new RuntimeException();
    }

    /**
     * 发布事件
     * @return
     */
    public TUser getUser2() {
        TUser user = new TUser();
        user.setId(1L);
        user.setUsername("1");
        user.setPassword("2");
        // 发布事件
        MyEvent event = new MyEvent(this, user);
        applicationContext.publishEvent(event);
        return user;
    }
}
