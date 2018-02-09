package com.soft.parent.manager.po;

import java.io.Serializable;

public class PaymentKey implements Serializable {
    private Integer paymentId;

    private Byte isgeneral;

    private static final long serialVersionUID = 1L;

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Byte getIsgeneral() {
        return isgeneral;
    }

    public void setIsgeneral(Byte isgeneral) {
        this.isgeneral = isgeneral;
    }
}