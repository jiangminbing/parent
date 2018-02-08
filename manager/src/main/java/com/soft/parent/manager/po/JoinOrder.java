package com.soft.parent.manager.po;

import java.io.Serializable;

public class JoinOrder implements Serializable {
    private Integer joinOrderId;

    private String joinOrderNumber;

    private String orderIds;

    private Integer totalPrice;

    private String orderNumbers;

    private static final long serialVersionUID = 1L;

    public Integer getJoinOrderId() {
        return joinOrderId;
    }

    public void setJoinOrderId(Integer joinOrderId) {
        this.joinOrderId = joinOrderId;
    }

    public String getJoinOrderNumber() {
        return joinOrderNumber;
    }

    public void setJoinOrderNumber(String joinOrderNumber) {
        this.joinOrderNumber = joinOrderNumber == null ? null : joinOrderNumber.trim();
    }

    public String getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(String orderIds) {
        this.orderIds = orderIds == null ? null : orderIds.trim();
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderNumbers() {
        return orderNumbers;
    }

    public void setOrderNumbers(String orderNumbers) {
        this.orderNumbers = orderNumbers == null ? null : orderNumbers.trim();
    }
}