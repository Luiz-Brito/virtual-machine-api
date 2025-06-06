package com.exam.virtual_machine.adapter;

import com.exam.virtual_machine.dto.VirtualMachineCreateDTO;
import com.exam.virtual_machine.dto.VirtualMachineDTO;
import com.exam.virtual_machine.entity.VirtualMachine;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VirtualMachineAdapter {

    public VirtualMachine toVirutalMachine(VirtualMachineCreateDTO virtualMachineCreateDTO) {
        return VirtualMachine.builder()
                .name(virtualMachineCreateDTO.getName())
                .cpu(virtualMachineCreateDTO.getCpu())
                .memory(virtualMachineCreateDTO.getMemory())
                .disc(virtualMachineCreateDTO.getDisc())
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
