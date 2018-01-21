package com.soft.parent.basic.result;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author jiangmb
 * @Time 2018/1/19.
 */
public class Result implements Serializable {
    private static final long serialVersionUID= 1L;
    /**
     * 操作结果约定码
     */
    protected ResCode resCode;
    /**
     * 操作结果信息
     */
    protected String message;

    /**
     * 时间戳
     */
    protected Long datestamp;

    public Long getDatestamp() {
        return new Date().getTime();
    }

    public void setDatestamp(Long datestamp) {
        this.datestamp = datestamp;
    }

    public Result(){
        super();
    }

    public Result(ResCode resCode){
        this.resCode=resCode;
        this.message=resCode.getMsg();
    }
    @JSONField(name = "ret")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JSONField(name = "ret")
    public void setStatus(int code){
        this.resCode=ResCode.getEnum(code);
        if(resCode==null){
            resCode=ResCode.UNKNOW_EXCEPTION;
        }
        this.message=resCode.getMsg();
    }

    @JSONField(name = "ret")
    public Integer getStatus(){
        if(resCode==null){
            resCode=ResCode.UNKNOW_EXCEPTION;
            this.message=resCode.getMsg();
        }
        return resCode.getCode();
    }

    @JSONField(serialize = false)
    public void setCode(ResCode resCode) {
        this.resCode = resCode;
        this.message=resCode.getMsg();
    }


}
