package com.falabella.store.MiException;

import com.falabella.store.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MiException.class)
    public ResponseEntity<ErrorDto> notFoundException(MiException ex){
        ErrorDto errorDto = new ErrorDto(404, ex.getMessage());
        return new ResponseEntity<>(errorDto,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDto>> argumentInvalid(MethodArgumentNotValidException ex){

        List<ErrorDto> errorsDto = ex.getBindingResult().getAllErrors().stream().map(error->{
            ErrorDto errorDto = new ErrorDto();
            errorDto.setStatusCode(401);
            errorDto.setMessage(error.getDefaultMessage());
            return errorDto;
        }).collect(Collectors.toList());

        return new ResponseEntity<>(errorsDto,HttpStatus.BAD_REQUEST);
    }

}
