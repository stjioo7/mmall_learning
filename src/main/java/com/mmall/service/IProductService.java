package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;

/**
 * Created by Administrator on 2017/10/21.
 */
public interface IProductService {
    //新增或更新商品
    public ServerResponse saveOrUpdateProduct(Product product);

    //上下架商品
    public ServerResponse<String> setProductStatus(Integer productId,Integer status);

    //后台获取指定商品信息
    public ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    //分页查询 pagehelper
    public ServerResponse<PageInfo> getProductList(Integer pageNum, Integer pageSize);

    //搜索商品
    public ServerResponse<PageInfo> searchProduct(String productName,Integer productId,Integer pageNum,Integer pageSize);

    //前台获取商品信息
    public ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    //根据关键字或者分类搜索
    public ServerResponse<PageInfo> getProductByKeywordCategory(String keyword,Integer categoryId,int pageNum,int pageSize,String orderBy);
}
