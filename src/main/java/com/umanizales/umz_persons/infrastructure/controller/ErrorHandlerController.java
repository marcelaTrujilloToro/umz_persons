package com.umanizales.umz_persons.infrastructure.controller;

import com.umanizales.umz_persons.application.dto.ErrorDTO;
import com.umanizales.umz_persons.application.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

//consejo
@ControllerAdvice
public class ErrorHandlerController {
        //metodos por cada una de las excepciones que quiero que este me transforme
        @ExceptionHandler(MethodArgumentNotValidException.class)
        protected ResponseEntity<?> handle(MethodArgumentNotValidException ex){
            List<ErrorDTO> listErrors = new ArrayList<>();
            ex.getBindingResult().getFieldErrors().forEach((error) -> {
                String fieldName = error.getField();
                String errorMessage = error.getDefaultMessage();
                listErrors.add(new ErrorDTO(HttpStatus.BAD_REQUEST.value(), fieldName +" "+ errorMessage));
            });
            String message = "Algunos campos son inválidos o faltantes, por favor corrija los errores y vuelva a intentarlo";
            ResponseDTO response = new ResponseDTO( message,null , listErrors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
}


//https://github.com/carloaiza/umz_persons