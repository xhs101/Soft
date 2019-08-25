package com.soft.demo.web.errors;

import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@ControllerAdvice
public class HaldException {

    public static final Map<String, String> map = Maps.newHashMapWithExpectedSize(2);

    @ExceptionHandler({com.soft.demo.web.exceptions.ParamException.class})
    @ResponseBody
    public Map<String,String> ParamException(Exception e){
        map.put("returnCode","0");
        map.put("solution", "请填写正确的参数");
        map.put("description", "参数异常");
        return map;

    }

    @ExceptionHandler({com.soft.demo.web.exceptions.DataException.class})
    @ResponseBody
    public Map<String,String> DataException(Exception e){
        map.put("returnCode","0");
        map.put("description", "数据不存在");
        map.put("solution", "请填写有效的参数");
        return map;
    }
}
