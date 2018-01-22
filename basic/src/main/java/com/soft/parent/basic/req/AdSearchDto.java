package com.soft.parent.basic.req;

import com.soft.parent.basic.result.SearchDto;

import java.io.Serializable;

/**
 * @Author jiangmb
 * @Time 2018/1/22.
 */
public class AdSearchDto extends SearchDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer adId;

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }
}
