package com.web.MyPetForApp.exception.exceptionCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionCode {
    FileCountExceed(404, "파일 개수는 10개 이하여야 합니다.");

    private int status;
    private String message;
}
