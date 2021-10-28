package com.artofmaes.eurder.domain.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerAdvisor {
    private final Logger logger = LoggerFactory.getLogger(ControllerAdvisor.class);

    @ExceptionHandler
    public void handleInvalidMailException(InvalidMailException exception, HttpServletResponse response) throws IOException{
        logger.error("Invalid mail: " + exception.getMessage());
        response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler
    public void handleUnauthorizedUserException(UnauthorizedUserException exception, HttpServletResponse response) throws IOException{
        logger.error("You don't have the proper authorization to do this.");
        response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }
}
