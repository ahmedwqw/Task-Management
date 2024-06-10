package com.TaskManagement.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        // Get the error status code
        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (statusCode != null) {
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "404"; // Return the custom 404 error page
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                return "403"; // Return the custom 403 error page
            }
        }

        // Default error handling
        return "error";
    }

    public String getErrorPath() {
        return "/error";
    }
}
