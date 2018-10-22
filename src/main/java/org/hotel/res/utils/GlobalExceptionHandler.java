package org.hotel.res.utils;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    //https://jira.spring.io/browse/SPR-14651
    //4.3.5 supports RedirectAttributes redirectAttributes
    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<String> handleError(MultipartException e) {

        return new ResponseEntity<String>("Error Upload : " + e.getCause().getMessage() ,  org.springframework.http.HttpStatus.NO_CONTENT);

    }
}