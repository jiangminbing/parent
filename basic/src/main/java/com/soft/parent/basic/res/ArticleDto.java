package com.soft.parent.basic.res;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author jiangmb
 * @Time 2018/1/27.
 */
public class ArticleDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer articleId;

    private Integer categoryId;

    private String title;

    private String keyWords;

    private String author;

    private Date publishtime;

    private String publisher;

    private Byte recommend;

    private Byte isPublished;

    private Byte state;

    private Byte isTop;

    private String image;

    private Date createTime;

    private Date updateTime;

    private Byte delState;

    private Integer adminId;

    private String content;
}
