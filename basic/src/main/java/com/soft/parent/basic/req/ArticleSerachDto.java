package com.soft.parent.basic.req;

import com.soft.parent.basic.result.SearchDto;

import java.io.Serializable;

/**
 * @Author jiangmb
 * @Time 2018/1/27.
 */
public class ArticleSerachDto  extends SearchDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer articleId;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
