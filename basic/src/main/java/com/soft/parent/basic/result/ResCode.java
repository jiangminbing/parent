package com.soft.parent.basic.result;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author jiangmb
 * @Time 2018/1/19.
 * 各模块统一定义返回参数
 */
public enum ResCode {
    /*公共返回参数*/
    SUCCESS(200,"操作成功"),
    /*500以上定义为错误*/
    FAILED(500,"操作失败"),
    SYS_ERR(501,"系统错误"),//定义为系统异常 返回的错误信息
    UNKNOW_EXCEPTION(502,"未定义错误")
    ;


    /*api 返回参数 定义返回开始1000*/


    /*管理后台 返回参数 定义返回开始2000*/
    private int code;
    private String msg;

    ResCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private static final Map<Integer, ResCode> CODE_MAP = new HashMap<Integer, ResCode>();

    static {
        for (ResCode typeEnum : ResCode.values()) {
            CODE_MAP.put(typeEnum.getCode(), typeEnum);
        }
    }

    public static ResCode getEnum(Integer code) {
        return CODE_MAP.get(code);
    }
}
