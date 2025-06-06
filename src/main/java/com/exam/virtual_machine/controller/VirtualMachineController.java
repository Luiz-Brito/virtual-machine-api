package com.exam.virtual_machine.controller;

import com.exam.virtual_machine.adapter.VirtualMachineAdapter;
import com.exam.virtual_machine.dto.VirtualMachineDTO;
import com.exam.virtual_machine.dto.VirtualMachineRequestDTO;
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
    public ResponseEntity<Void> save(@RequestBody @Valid VirtualMachineRequestDTO virtualMachineRequestDTO) {
        final VirtualMachine virtualMachine = virtualMachineAdapter.toVirutalMachine(virtualMachineRequestDTO);
        virtualMachineService.save(virtualMachine);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<VirtualMachineDTO>> list() {
        final List<VirtualMachine> virtualMachines = virtualMachineService.findAll();
        final List<VirtualMachineDTO> list = virtualMachines.stream().map(virtualMachineAdapter::toVirtualMachineDTO).toList();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VirtualMachineDTO> findById(@PathVariable("id") Long id) {
        final VirtualMachine virtualMachineFound = virtualMachineService.findById(id);
        final VirtualMachineDTO virtualMachineDTO = virtualMachineAdapter.toVirtualMachineDTO(virtualMachineFound);

        return ResponseEntity.ok().body(virtualMachineDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id,
                                       @RequestBody @Valid VirtualMachineRequestDTO newVirtualMachine) {

        virtualMachineService.update(id, newVirtualMachine);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        virtualMachineService.delete(id);

        return ResponseEntity.ok().build();
    }
}
