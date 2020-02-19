package com.feifei.springboot.service;

import com.feifei.springboot.entity.TUser;

public interface UserService {

    TUser getUserById(Long id);

    void insertUser(TUser user);


}
