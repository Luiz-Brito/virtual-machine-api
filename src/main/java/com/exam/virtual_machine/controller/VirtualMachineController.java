package com.exam.virtual_machine.controller;

import com.exam.virtual_machine.adapter.VirtualMachineAdapter;
import com.exam.virtual_machine.dto.VirtualMachineCreateDTO;
import com.exam.virtual_machine.dto.VirtualMachineDTO;
import com.exam.virtual_machine.entity.VirtualMachine;
import com.exam.virtual_machine.service.VirtualMachineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<VirtualMachineDTO>> list() {
        final List<VirtualMachine> virtualMachines = virtualMachineService.findAll();
        final List<VirtualMachineDTO> list = virtualMachines.stream().map(virtualMachineAdapter::toVirtualMachineDTO).toList();

        return ResponseEntity.ok().body(list);
    }
}
