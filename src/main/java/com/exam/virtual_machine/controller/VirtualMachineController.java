package com.exam.virtual_machine.controller;

import com.exam.virtual_machine.adapter.VirtualMachineAdapter;
import com.exam.virtual_machine.dto.VirtualMachineCreateDTO;
import com.exam.virtual_machine.dto.VirtualMachineDTO;
import com.exam.virtual_machine.dto.VirtualMachineUpdateDTO;
import com.exam.virtual_machine.entity.VirtualMachine;
import com.exam.virtual_machine.enums.Status;
import com.exam.virtual_machine.service.VirtualMachineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Virtual Machine", description = "Controller for saving, updating, querying and deleting virtual machines")
@RequiredArgsConstructor
@RestController
@RequestMapping("/virtual-machine")
public class VirtualMachineController {

    private final VirtualMachineService virtualMachineService;
    private final VirtualMachineAdapter virtualMachineAdapter;

    @PostMapping
    @Operation(description = "Method to save virtual machines")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Virtual Machine created successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid request content.")
    })
    public ResponseEntity<Void> save(@RequestBody @Valid VirtualMachineCreateDTO virtualMachineCreateDTO) {
        final VirtualMachine virtualMachine = virtualMachineAdapter.toCreateVirtualMachine(virtualMachineCreateDTO);
        virtualMachineService.save(virtualMachine);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Operation(description = "Method to consult all registered virtual machines")
    @ApiResponse(responseCode = "200", description = "Consultation carried out successfully.")
    public ResponseEntity<List<VirtualMachineDTO>> list() {
        final List<VirtualMachine> virtualMachines = virtualMachineService.findAll();
        final List<VirtualMachineDTO> list = virtualMachines.stream().map(virtualMachineAdapter::toVirtualMachineDTO).toList();

        return ResponseEntity.ok().body(list);
    }


    @GetMapping("/{id}")
    @Operation(description = "Method to query a single virtual machine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Virtual Machine successfully queried."),
            @ApiResponse(responseCode = "404", description = "Virtual Machine not found.")
    })
    public ResponseEntity<VirtualMachineDTO> findById(@PathVariable("id") Long id) {
        final VirtualMachine virtualMachineFound = virtualMachineService.findById(id);
        final VirtualMachineDTO virtualMachineDTO = virtualMachineAdapter.toVirtualMachineDTO(virtualMachineFound);

        return ResponseEntity.ok().body(virtualMachineDTO);
    }

    @PatchMapping("/{id}")
    @Operation(description = "Method for upgrading a single virtual machine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Virtual machine successfully updated"),
            @ApiResponse(responseCode = "404", description = "Virtual Machine not found."),
            @ApiResponse(responseCode = "400", description = "Invalid request content.")
    })
    public ResponseEntity<Void> update(@PathVariable("id") Long id,
                                       @RequestBody @Valid VirtualMachineUpdateDTO virtualMachineUpdateDTO) {

        final VirtualMachine newVirtualMachine = virtualMachineAdapter.toUpdateVirtualMachine(id, virtualMachineUpdateDTO);
        final Status status = Status.valueOf(virtualMachineUpdateDTO.getStatus());
        virtualMachineService.update(newVirtualMachine, status);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Method to delete a single virtual machine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Virtual machine deleted successfully."),
            @ApiResponse(responseCode = "404", description = "Virtual Machine not found.")
    })
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        virtualMachineService.delete(id);

        return ResponseEntity.ok().build();
    }
}
