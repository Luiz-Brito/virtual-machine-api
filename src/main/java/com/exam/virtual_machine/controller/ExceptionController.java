package com.exam.virtual_machine.controller;

import com.exam.virtual_machine.exceptions.VirtualMachineNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(VirtualMachineNotFound.class)
    private ResponseEntity<String> virtualMachineNotFound(VirtualMachineNotFound exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Virtual Machine not found.");
    }
}
