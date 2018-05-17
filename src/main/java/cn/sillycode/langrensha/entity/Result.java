package cn.sillycode.langrensha.entity;

import cn.sillycode.langrensha.enums.ResultEnum;
import lombok.Data;

/**
 * @program: langrensha
 * @description: ${description}
 * @author: zsq
 * @create: 2018-05-17 13-22
 */
@Data
public class Result<T> {
    private Integer code;

    private String msg;

    private T data;


    public Result(){}

    public Result(ResultEnum resultEnum, T data){
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }

}
