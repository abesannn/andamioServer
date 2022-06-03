/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.ausiasmarch.wildcart.Exception;

import java.util.Date;
import net.ausiasmarch.wildcart.bean.ErrorResponseBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<?> UnauthorizedException(UnauthorizedException ex, WebRequest request) {
        ErrorResponseBean errorDetails
                = new ErrorResponseBean(new Date(), HttpStatus.UNAUTHORIZED.name(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> ResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorResponseBean errorDetails
                = new ErrorResponseBean(new Date(), HttpStatus.NOT_FOUND.name(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ResourceNotModifiedException.class)
    public ResponseEntity<?> ResourceNotModifiedException(ResourceNotModifiedException ex, WebRequest request) {
        ErrorResponseBean errorDetails
                = new ErrorResponseBean(new Date(), HttpStatus.NOT_MODIFIED.name(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_MODIFIED);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> ValidationException(ValidationException ex, WebRequest request) {
        ErrorResponseBean errorDetails
                = new ErrorResponseBean(new Date(), HttpStatus.NOT_ACCEPTABLE.name(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> AppExceptionHandler(Exception ex, WebRequest request) {
        ErrorResponseBean errorDetails
                = new ErrorResponseBean(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.name(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
