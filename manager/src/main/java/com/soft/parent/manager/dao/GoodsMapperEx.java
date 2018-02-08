package com.soft.parent.manager.dao;


import com.soft.parent.manager.po.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GoodsMapperEx {

    List<Goods> selectGoodsByGoodsCategory(Map<String, Object> map);

    long countGoodsByGoodsCategory(Map<String, Object> map);

    List<Goods> selectByMyStoreGoods(Map<String, Object> map);

    long countByMyStoreGoods(@Param("userId") Integer userId);
}