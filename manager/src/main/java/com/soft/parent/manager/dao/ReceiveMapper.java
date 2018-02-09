package com.soft.parent.manager.dao;

import com.soft.parent.manager.po.Receive;
import com.soft.parent.manager.po.ReceiveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceiveMapper {
    long countByExample(ReceiveExample example);

    int deleteByExample(ReceiveExample example);

    int deleteByPrimaryKey(Integer receiveId);

    int insert(Receive record);

    int insertSelective(Receive record);

    List<Receive> selectByExample(ReceiveExample example);

    Receive selectByPrimaryKey(Integer receiveId);

    int updateByExampleSelective(@Param("record") Receive record, @Param("example") ReceiveExample example);

    int updateByExample(@Param("record") Receive record, @Param("example") ReceiveExample example);

    int updateByPrimaryKeySelective(Receive record);

    int updateByPrimaryKey(Receive record);
}