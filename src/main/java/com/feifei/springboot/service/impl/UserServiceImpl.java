package com.feifei.springboot.service.impl;

import com.feifei.springboot.dao.TUserMapper;
import com.feifei.springboot.entity.TUser;
import com.feifei.springboot.service.UserService;
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
}
