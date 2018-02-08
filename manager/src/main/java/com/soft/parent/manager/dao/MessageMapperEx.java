package com.soft.parent.manager.dao;

import com.soft.parent.manager.po.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author jiangmb
 * @Time 2018/2/8.
 */
public interface MessageMapperEx {

    List<Message> selectMessageTop(Map<String,Object> map);
    /*计算用户未读取消息数*/
    long countNoReadCount(@Param("userId") Integer userId);
    /*计算用户消息数*/
    long countMessage(@Param("userId") Integer userId);



}
