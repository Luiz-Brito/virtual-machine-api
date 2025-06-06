package com.exam.virtual_machine.service;

import com.exam.virtual_machine.entity.VirtualMachine;
import com.exam.virtual_machine.repository.VirtualMachineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VirtualMachineService {

    private final VirtualMachineRepository virtualMachineRepository;

    public void save(VirtualMachine virtualMachine) {
        virtualMachineRepository.save(virtualMachine);
    }

    public List<VirtualMachine> findAll() {
        return virtualMachineRepository.findAll();
    }

    public VirtualMachine findById(Long id) {
        return virtualMachineRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
