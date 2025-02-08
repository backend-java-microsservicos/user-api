package mz.co.muianga.userapi.exception;

import mz.co.muianga.shoppingclient.dto.ErrorDTO;
import mz.co.muianga.shoppingclient.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ControllerAdvice(basePackages = "mz.co.muianga.userapi.controller")
public class UserControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorDTO handleUserNotFoundException(UserNotFoundException ex) {
        var error = new ErrorDTO();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage("Utilizador nao encontrado");
        error.setTimestamp(new Date());

        return error;
    }
}
