package com.soft.parent.basic.req;

import java.io.Serializable;

/**
 * @Author jiangmb
 * @Time 2018/2/2.
 */
public class GoodsCategoryDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer categoryId;
    private Integer recommend;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }
}
