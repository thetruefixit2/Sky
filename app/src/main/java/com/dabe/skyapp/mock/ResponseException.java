package com.dabe.skyapp.mock;

import android.annotation.TargetApi;
import android.os.Build;

import com.dabe.skyapp.model.data.enums.ErrorTypesEnum;

/**
 * Created by Daniil Belevtsev on 28.01.2017 1:53.
 * Project: SkyApp; Skype: pandamoni1
 */

public class ResponseException extends RuntimeException {

    private ErrorTypesEnum errorType;

    public ResponseException(ErrorTypesEnum errorType) {
        this.errorType = errorType;
    }

    public ResponseException(String message, ErrorTypesEnum errorType) {
        super(message);
        this.errorType = errorType;
    }

    public ResponseException(String message, Throwable cause, ErrorTypesEnum errorType) {
        super(message, cause);
        this.errorType = errorType;
    }

    public ResponseException(Throwable cause, ErrorTypesEnum errorType) {
        super(cause);
        this.errorType = errorType;
    }

    @TargetApi(Build.VERSION_CODES.N)
    public ResponseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorTypesEnum errorType) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorType = errorType;
    }

    public ErrorTypesEnum getErrorType() {
        return errorType;
    }
}
