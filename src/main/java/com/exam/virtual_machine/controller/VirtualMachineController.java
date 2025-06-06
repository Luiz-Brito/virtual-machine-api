package com.exam.virtual_machine.controller;

import com.exam.virtual_machine.adapter.VirtualMachineAdapter;
import com.exam.virtual_machine.dto.VirtualMachineCreateDTO;
import com.exam.virtual_machine.entity.VirtualMachine;
import com.exam.virtual_machine.service.VirtualMachineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/virtual-machine")
public class VirtualMachineController {

    private final VirtualMachineService virtualMachineService;
    private final VirtualMachineAdapter virtualMachineAdapter;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid VirtualMachineCreateDTO virtualMachineCreateDTO) {
        final VirtualMachine virtualMachine = virtualMachineAdapter.toVirutalMachine(virtualMachineCreateDTO);
        virtualMachineService.save(virtualMachine);

        return ResponseEntity.ok().build();
    }
}
