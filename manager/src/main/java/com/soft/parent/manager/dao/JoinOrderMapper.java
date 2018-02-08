package com.soft.parent.manager.dao;

import com.soft.parent.manager.po.JoinOrder;
import com.soft.parent.manager.po.JoinOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JoinOrderMapper {
    long countByExample(JoinOrderExample example);

    int deleteByExample(JoinOrderExample example);

    int deleteByPrimaryKey(Integer joinOrderId);

    int insert(JoinOrder record);

    int insertSelective(JoinOrder record);

    List<JoinOrder> selectByExampleWithBLOBs(JoinOrderExample example);

    List<JoinOrder> selectByExample(JoinOrderExample example);

    JoinOrder selectByPrimaryKey(Integer joinOrderId);

    int updateByExampleSelective(@Param("record") JoinOrder record, @Param("example") JoinOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") JoinOrder record, @Param("example") JoinOrderExample example);

    int updateByExample(@Param("record") JoinOrder record, @Param("example") JoinOrderExample example);

    int updateByPrimaryKeySelective(JoinOrder record);

    int updateByPrimaryKeyWithBLOBs(JoinOrder record);

    int updateByPrimaryKey(JoinOrder record);
}