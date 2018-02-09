package com.soft.parent.manager.dao;

import com.soft.parent.manager.model.OrderDto;
import org.apache.ibatis.annotations.Param;

public interface OrderMapperEx {
    /**
     * 订单详情关联查询
     * @param orderNum
     * @return
     */
    OrderDto selectOrderByOrderNum(@Param("orderNumber") String orderNum);
}