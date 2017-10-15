package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;

import java.util.List;

/**
 * Created by Administrator on 2017/10/15.
 */
public interface ICategoryService {
    //新增分类
    public ServerResponse<Category> addCategory(String categoryName,Integer parentId);

    //修改分类名称
    public ServerResponse<String> setCategoryName(Integer id,String categoryName);

    //当前分类下的子分类
    public ServerResponse<List<Category>> getChildParalleCategory(Integer categoryId);

    public ServerResponse getCategoryAndChildrenById(Integer categoryId);
}
