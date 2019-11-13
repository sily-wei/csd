package com.wn.csd.view;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author weining
 * @date 2019/11/13 9:26
 */
public class ErrorControllerAdvice {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException(){
        return "1";
    }
}
