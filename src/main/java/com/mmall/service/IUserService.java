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

    //获取忘记密码的问题
    public ServerResponse<String> selectQuestion(String username);

    //验证问题的答案
    public ServerResponse<String> checkAnswer(String username,String question,String answer);

    //未登录状态的重置密码
    public ServerResponse<String> forgetResetPassword(String username,String passwordNew,String forgetToken);

    //登录状态的重置密码
    public ServerResponse<String> resetPassword(User user,String passwordOld,String passwordNew);

    //修改用户信息
    public ServerResponse<User> updateInformation(User user);

    //获取用户的详细信息
    public ServerResponse<User> getInformation(Integer userId);

    //验证用户是否为管理员
    public ServerResponse<String> checkAdminRole(User user);
}
