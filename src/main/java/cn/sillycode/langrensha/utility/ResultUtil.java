package cn.sillycode.langrensha.utility;

import cn.sillycode.langrensha.entity.Result;
import cn.sillycode.langrensha.enums.ResultEnum;

/**
 * @program: langrensha
 * @description: ${description}
 * @author: zsq
 * @create: 2018-05-17 15-16
 */
public class ResultUtil {
    public static Result success(Object object){
        Result result = new Result(ResultEnum.SUCCESS, object);
        return result;
    }

    public static Result error(Object object){
        Result result = new Result(ResultEnum.SYSTEM_ERROR, object);
        return  result;
    }

    public static Result enterError(Object object){
        Result result = new Result(ResultEnum.ENTER_ERROR, object);
        return result;
    }
}
