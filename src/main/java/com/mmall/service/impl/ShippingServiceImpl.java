package com.mmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.mmall.common.ServerResponse;
import com.mmall.dao.ShippingMapper;
import com.mmall.pojo.Shipping;
import com.mmall.service.IShippingService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/27.
 */
@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService {

    @Autowired
    ShippingMapper shippingMapper;

    public ServerResponse add(Integer userId,Shipping shipping){
        shipping.setUserId(userId);
        int resultConut = shippingMapper.insert(shipping);
        if (resultConut > 0){
            Map resultMap = Maps.newHashMap();
            resultMap.put("shippingId",shipping.getId());
            return ServerResponse.createBySuccess("新建地址成功",resultMap);
        }
        return ServerResponse.createByErrorMessage("新建地址失败");
    }

    public ServerResponse delete(Integer userId,Integer shippingId){
        int resultCount = shippingMapper.deleteByShippingIdUserId(userId,shippingId);
        if (resultCount > 0){
            return ServerResponse.createBySuccessMessage("删除地址成功");
        }
        return ServerResponse.createByErrorMessage("删除地址失败");
    }

    public ServerResponse update(Integer userId,Shipping shipping){
        shipping.setUserId(userId);
        int resultCount = shippingMapper.updateByShipping(shipping);
        if (resultCount > 0){
            return ServerResponse.createBySuccessMessage("更新地址成功");
        }
        return ServerResponse.createByErrorMessage("更新地址失败");
    }

    public ServerResponse<Shipping> select(Integer userId,Integer shippingId){
        Shipping shipping = shippingMapper.selectByUserIdShippingId(userId,shippingId);
        if (shipping == null){
            return ServerResponse.createByErrorMessage("无法查询到该用户的地址");
        }
        return ServerResponse.createBySuccess("获取该地址信息成功",shipping);
    }

    public ServerResponse<PageInfo> list(int pageNum,int pageSize,Integer userId){
        PageHelper.startPage(pageNum,pageSize);
        List<Shipping> shippingList = shippingMapper.selectByUserId(userId);
        if (CollectionUtils.isEmpty(shippingList)){
            return ServerResponse.createByErrorMessage("无法查询到该用户的地址");
        }
        PageInfo pageInfo = new PageInfo(shippingList);
        return ServerResponse.createBySuccess(pageInfo);
    }
}
