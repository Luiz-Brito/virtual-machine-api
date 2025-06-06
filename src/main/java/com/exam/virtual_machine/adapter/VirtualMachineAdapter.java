package com.exam.virtual_machine.adapter;

import com.exam.virtual_machine.dto.VirtualMachineCreateDTO;
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
}
