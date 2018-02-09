package com.soft.parent.basic.req;

import com.soft.parent.basic.result.SearchDto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author jiangmb
 * @Time 2018/2/9.
 */
public class OrderSearchDto extends SearchDto implements Serializable {
    private Integer orderId;

    private String orderNumber;

    private Integer userId;

    private Integer totalAmount;

    private Integer paidAmount;

    private Integer discountAmount;

    private Integer receiveId;

    private Date sendTime;

    private Byte logisticsState;

    private Byte invoiceTag;

    private Byte delState;

    private Integer paymentId;

    private String paymentSeq;

    private Byte payState;

    private String comment;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Integer paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Integer getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Byte getLogisticsState() {
        return logisticsState;
    }

    public void setLogisticsState(Byte logisticsState) {
        this.logisticsState = logisticsState;
    }

    public Byte getInvoiceTag() {
        return invoiceTag;
    }

    public void setInvoiceTag(Byte invoiceTag) {
        this.invoiceTag = invoiceTag;
    }

    public Byte getDelState() {
        return delState;
    }

    public void setDelState(Byte delState) {
        this.delState = delState;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentSeq() {
        return paymentSeq;
    }

    public void setPaymentSeq(String paymentSeq) {
        this.paymentSeq = paymentSeq == null ? null : paymentSeq.trim();
    }

    public Byte getPayState() {
        return payState;
    }

    public void setPayState(Byte payState) {
        this.payState = payState;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
