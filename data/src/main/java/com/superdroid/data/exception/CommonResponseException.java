package com.superdroid.data.exception;

/**
 * Created by Administrator on 2016/5/12.
 */
public class CommonResponseException extends RuntimeException {
    public CommonResponseException(Throwable throwable) {
        super(throwable);
    }

    public CommonResponseException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public CommonResponseException(String detailMessage) {
        super(detailMessage);
    }

    public CommonResponseException() {
    }
}
