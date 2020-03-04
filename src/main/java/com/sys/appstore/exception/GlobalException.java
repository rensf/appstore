package com.sys.appstore.exception;

import lombok.Data;

@Data
public class GlobalException extends Exception {

    private Integer code;

    public GlobalException(int code, String message) {
        super(message);
        this.code = code;
    }

}
