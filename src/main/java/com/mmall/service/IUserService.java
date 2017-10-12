package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * Created by Administrator on 2017/10/11.
 */
public interface IUserService {
    //登录
    public ServerResponse<User> login(String username,String password);

    //注册
    public ServerResponse<String> register(User user);

    //校验
    public ServerResponse<String> checkValid(String str,String type);
}
