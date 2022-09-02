package com.testForJavaBackend1.testForJavaBackend1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {
    private Boolean success;
    private String status;
    private String message;
    private T data;
}
