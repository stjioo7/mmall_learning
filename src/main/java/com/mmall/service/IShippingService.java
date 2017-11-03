package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Shipping;

/**
 * Created by Administrator on 2017/10/27.
 */
public interface IShippingService {

    //新建地址
    public ServerResponse add(Integer userId, Shipping shipping);

    //删除地址
    public ServerResponse delete(Integer userId,Integer shippingId);

    //更新地址
    public ServerResponse update(Integer userId,Shipping shipping);

    //获取指定地址
    public ServerResponse<Shipping> select(Integer userId,Integer shippingId);

    //获取地址
    public ServerResponse<PageInfo> list(int pageNum, int pageSize, Integer userId);
}
