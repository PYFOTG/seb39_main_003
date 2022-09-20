package com.web.MyPetForApp.exception.error;

import lombok.Getter;

public class FileCountExceedException extends RuntimeException {
    @Getter
    private String errMsg;

    public FileCountExceedException(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
    }

}
