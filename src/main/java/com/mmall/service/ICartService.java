package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.vo.CartVo;

/**
 * Created by Administrator on 2017/10/26.
 */
public interface ICartService {
    //添加商品进入购物车
    public ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);

    //更新购物车的商品
    public ServerResponse<CartVo> update(Integer userId,Integer productId,Integer count);

    //删除购物车中的商品
    public ServerResponse<CartVo> deleteProduct(Integer userId,String productIds);

    //查看购物车
    public ServerResponse<CartVo> list(Integer userId);

    public ServerResponse<CartVo> selectOrUnSelect(Integer userId,Integer productId,Integer checked);

    public ServerResponse<Integer> getProductCount(Integer userId);

}
