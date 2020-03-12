package com.sys.appstore.exception;

import lombok.Data;

@Data
public class GlobalException extends Exception {

    private String code;

    public GlobalException(String code, String message) {
        super(message);
        this.code = code;
    }

}
