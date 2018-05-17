package cn.sillycode.langrensha.enums;

import lombok.Data;

/**
 * @program: langrensha
 * @description: ${description}
 * @author: zsq
 * @create: 2018-05-17 13-31
 */
public enum ResultEnum {
    SYSTEM_ERROR(-1, "System Error"),
    SUCCESS(0, "Success"),
    ENTER_ERROR(100, "User Enter Error");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
