package spittr.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(value = {SpittleNotFoundException.class, DuplicateSpittleException.class})
    public String handleNotFound() {
        return "error/duplicate";
    }

}
