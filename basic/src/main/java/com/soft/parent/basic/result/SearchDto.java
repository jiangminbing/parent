package com.soft.parent.basic.result;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询条件设置对象
 */
public class SearchDto extends Page implements Serializable {
    private static final long serialVersionUID = 1L;

    //时间段查询参数
    private Map<String,DateParam> dateMap=new HashMap<>();

    private String orderBy;
    //如果是顺序排序使用 true，否则使用false 默认true;
    private Boolean reverse = true;

    public void putDate(String key,Date d1,Date d2){
        DateParam param=new DateParam(d1,d2);
        dateMap.put(key,param);
    }
    public Map<String, DateParam> getDateMap() {
        return dateMap;
    }

    public void setDateMap(Map<String, DateParam> dateMap) {
        this.dateMap = dateMap;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Boolean getReverse() {
        return reverse;
    }

    public void setReverse(Boolean reverse) {
        this.reverse = reverse;
    }

    public class DateParam{
        private Date begin;
        private Date end;

        DateParam(Date d1,Date d2){
            this.begin=d1;
            this.end=d2;
        }

        public Date getBegin() {
            return begin;
        }

        public void setBegin(Date begin) {
            this.begin = begin;
        }

        public Date getEnd() {
            return end;
        }

        public void setEnd(Date end) {
            this.end = end;
        }
    }

}
