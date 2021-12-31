package com.itattoo.Application.Config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ IllegalArgumentException.class /*, IllegalStateException.class */ })
    protected ResponseEntity<Object> onIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    // Qualquer exception, se não cair nos outros handlers, vai cair aqui
    @ExceptionHandler({ Exception.class })
    protected ResponseEntity<Object> onUnhandledException(RuntimeException ex, WebRequest request) {
        ex.printStackTrace();
        return ResponseEntity.internalServerError().body("Internal server error.");
    }

}
