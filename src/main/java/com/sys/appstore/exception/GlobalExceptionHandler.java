package com.sys.appstore.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler
    public Map errorHandler(Exception e) {
        e.printStackTrace();
        Map map = new HashMap();
        map.put("msg",e.getMessage());
        return map;
    }

}
