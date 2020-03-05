package com.sys.appstore.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code = 0;

    private String msg = "操作成功！";

    private long timestamp = System.currentTimeMillis();

    private T result;

    public Result() {

    }

    public static Result<Object> error(int code, String msg) {
        Result<Object> result = new Result<Object>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
