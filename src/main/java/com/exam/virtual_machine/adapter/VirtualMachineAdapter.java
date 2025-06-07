package com.exam.virtual_machine.adapter;

import com.exam.virtual_machine.dto.VirtualMachineCreateDTO;
import com.exam.virtual_machine.dto.VirtualMachineDTO;
import com.exam.virtual_machine.dto.VirtualMachineUpdateDTO;
import com.exam.virtual_machine.entity.VirtualMachine;
import com.exam.virtual_machine.enums.Status;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VirtualMachineAdapter {

    public VirtualMachine toCreateVirtualMachine(VirtualMachineCreateDTO virtualMachineCreateDTO) {
        return VirtualMachine.builder()
                .name(virtualMachineCreateDTO.getName())
                .cpu(virtualMachineCreateDTO.getCpu())
                .memory(virtualMachineCreateDTO.getMemory())
                .disc(virtualMachineCreateDTO.getDisc())
                .status(Status.STOP)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public VirtualMachine toUpdateVirtualMachine(Long id, VirtualMachineUpdateDTO virtualMachineRequestDTO) {
        return VirtualMachine.builder()
                .id(id)
                .name(virtualMachineRequestDTO.getName())
                .cpu(virtualMachineRequestDTO.getCpu())
                .memory(virtualMachineRequestDTO.getMemory())
                .disc(virtualMachineRequestDTO.getDisc())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public VirtualMachineDTO toVirtualMachineDTO(VirtualMachine virtualMachine) {
        return VirtualMachineDTO.builder()
                .id(virtualMachine.getId())
                .name(virtualMachine.getName())
                .cpu(virtualMachine.getCpu())
                .memory(virtualMachine.getMemory())
                .disc(virtualMachine.getDisc())
                .status(virtualMachine.getStatus().toString())
                .createdAt(virtualMachine.getCreatedAt())
                .build();
    }
}
