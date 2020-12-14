package com.rentpal.accounts.exception;

import com.rentpal.accounts.common.Utils;
import com.rentpal.accounts.model.APIException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletException;
import java.io.IOException;

/*
 * @author frank
 * @created 14 Dec,2020 - 9:36 PM
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String FAILED="failed";
    /**
     * Handle API request exception.
     *
     * @param exception        the exception
     * @throws IOException      Signals that an I/O exception has occurred.
     * @throws ServletException the servlet exception
     * @return
     */
    @ExceptionHandler(value= {APIRequestException.class})
    public ResponseEntity<APIException> handleAPIRequestException(APIRequestException exception) throws IOException, ServletException{
        log.error(exception.getMessage(), exception);
        APIException apiException=new APIException();
        apiException.setMessage(exception.getMessage());
        apiException.setStatus(FAILED);
        apiException.setTimestamp(Utils.getDate(System.currentTimeMillis()));
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

}
