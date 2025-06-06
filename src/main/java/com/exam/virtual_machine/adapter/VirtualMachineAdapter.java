package com.exam.virtual_machine.adapter;

import com.exam.virtual_machine.dto.VirtualMachineDTO;
import com.exam.virtual_machine.dto.VirtualMachineRequestDTO;
import com.exam.virtual_machine.entity.VirtualMachine;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VirtualMachineAdapter {

    public VirtualMachine toVirutalMachine(VirtualMachineRequestDTO virtualMachineRequestDTO) {
        return VirtualMachine.builder()
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
                .createdAt(virtualMachine.getCreatedAt())
                .build();
    }
}
