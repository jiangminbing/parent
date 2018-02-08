package com.soft.parent.manager.po;

import java.io.Serializable;
import java.util.Date;

public class OrderDetails implements Serializable {
    private Integer orderDetailsId;

    private Integer orderId;

    private String orderNumber;

    private Integer priceId;

    private Integer goodsId;

    private String unitName;

    private String goodsName;

    private Integer unitPrice;

    private Integer num;

    private Integer detailsAmount;

    private Date createTime;

    private String image;

    private static final long serialVersionUID = 1L;

    public Integer getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(Integer orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getDetailsAmount() {
        return detailsAmount;
    }

    public void setDetailsAmount(Integer detailsAmount) {
        this.detailsAmount = detailsAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}