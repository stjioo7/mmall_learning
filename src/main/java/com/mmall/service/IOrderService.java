package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.vo.OrderVo;

/**
 * Created by Administrator on 2017/11/3.
 */
public interface IOrderService {
    //创建订单
    ServerResponse createOrder(Integer userId, Integer shippingId);

    //取消订单
    ServerResponse<String> cancelOrder(Integer userId, Long orderNo);

    ServerResponse getOrderCartProduct(Integer userId);

    //查询订单详情
    ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);

    //查询用户订单
    ServerResponse<PageInfo> getOrderList(Integer userId, int pageNum, int pageSize);

    //后台查询用户订单
    ServerResponse<PageInfo> manageList(int pageNum,int pageSize);

    //后台查询订单详情
    ServerResponse<OrderVo> manageDetail(Long orderNo);

    //后台搜索订单
    ServerResponse<PageInfo> manageSearch(Long orderNo,int pageNum,int pageSize);

    //后台进行发货
    ServerResponse manageSendGoods(Long orderNo);
}
