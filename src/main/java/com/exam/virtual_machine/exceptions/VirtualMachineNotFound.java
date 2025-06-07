package com.exam.virtual_machine.exceptions;

public class VirtualMachineNotFound extends RuntimeException {

    public VirtualMachineNotFound() {super("Virtual Machine not found!");}

    public VirtualMachineNotFound(String message) {
        super(message);
    }
}
