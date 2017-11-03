package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mmall.common.ServerResponse;
import com.mmall.dao.CategoryMapper;
import com.mmall.pojo.Category;
import com.mmall.service.ICategoryService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/10/15.
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public ServerResponse addCategory(String categoryName, Integer parentId) {
        if (parentId == null || StringUtils.isBlank(categoryName)){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        Category category = new Category();
        category.setName(categoryName);
        category.setParentId(parentId);
        category.setStatus(true);//该分类是可用的
        int resultCount = categoryMapper.insert(category);
        if (resultCount == 0){
            return ServerResponse.createByErrorMessage("新增分类失败");
        }
        return ServerResponse.createBySuccess(category);
    }

    @Override
    public ServerResponse<String> setCategoryName(Integer id, String categoryName) {
        if (id == null || StringUtils.isBlank(categoryName)){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        Category category = new Category();
        category.setId(id);
        category.setName(categoryName);
        int resultCount = categoryMapper.updateByPrimaryKeySelective(category);
        if (resultCount == 0){
            return ServerResponse.createByErrorMessage("修改分类名称失败");
        }
        return ServerResponse.createBySuccessMessage("修改分类名称成功");
    }

    @Override
    public ServerResponse<List<Category>> getChildParalleCategory(Integer categoryId) {
        if (categoryId == null){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        List<Category> categoryList = categoryMapper.selectCategoryChildrenById(categoryId);
        if (CollectionUtils.isEmpty(categoryList)){
            logger.info("未找到当前分类的子分类");
        }
        return ServerResponse.createBySuccess(categoryList);
    }

    @Override
    public ServerResponse<List<Integer>> getCategoryAndChildrenById(Integer categoryId) {
        if (categoryId == null){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        Set<Category> categorySet = Sets.newHashSet();
        getChildrenCategory(categorySet,categoryId);
        List<Integer> categoryIdList = Lists.newArrayList();
        for (Category categoryItem : categorySet){
            categoryIdList.add(categoryItem.getId());
        }
        return ServerResponse.createBySuccess(categoryIdList);
    }

    public Set<Category> getChildrenCategory(Set<Category> categorySet,Integer categoryId){
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if (category != null){
            categorySet.add(category);
        }
        List<Category> categoryList = categoryMapper.selectCategoryChildrenById(categoryId);
        for (Category categoryItem : categoryList){
            getChildrenCategory(categorySet,categoryItem.getId());
        }
        return categorySet;
    }


}
