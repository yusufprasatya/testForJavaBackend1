package com.testForJavaBackend1.testForJavaBackend1.util;

import com.testForJavaBackend1.testForJavaBackend1.dto.ResponseDto;
import org.springframework.http.HttpStatus;

public class DtoUtil {
    public static <T> ResponseDto<T> responseDtoSuccess(T data){
        return new ResponseDto<>(
                true,
                HttpStatus.OK.toString(),
                "Data Found",
                data
        );
    }

    public static <T> ResponseDto<T> responseDtoFailed(T data){
        return new ResponseDto<>(
                true,
                HttpStatus.OK.toString(),
                "Data Not Found",
                data
        );
    }

    public static <T> ResponseDto<T> responseDtoFailed(T data, String errorMessage, HttpStatus httpStatus) {
        return new ResponseDto<>(
                false,
                httpStatus.toString(),
                errorMessage,
                data
        );
    }
}
