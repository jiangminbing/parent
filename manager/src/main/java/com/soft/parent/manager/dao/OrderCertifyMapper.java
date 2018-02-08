package com.soft.parent.manager.dao;

import com.soft.parent.manager.po.OrderCertify;
import com.soft.parent.manager.po.OrderCertifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderCertifyMapper {
    long countByExample(OrderCertifyExample example);

    int deleteByExample(OrderCertifyExample example);

    int deleteByPrimaryKey(Integer certifyId);

    int insert(OrderCertify record);

    int insertSelective(OrderCertify record);

    List<OrderCertify> selectByExample(OrderCertifyExample example);

    OrderCertify selectByPrimaryKey(Integer certifyId);

    int updateByExampleSelective(@Param("record") OrderCertify record, @Param("example") OrderCertifyExample example);

    int updateByExample(@Param("record") OrderCertify record, @Param("example") OrderCertifyExample example);

    int updateByPrimaryKeySelective(OrderCertify record);

    int updateByPrimaryKey(OrderCertify record);
}