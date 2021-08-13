package com.bridgelabz.demoproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseDTO {

    private Object data;
    private String message;
}
