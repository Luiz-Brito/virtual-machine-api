package com.exam.virtual_machine.service;

import com.exam.virtual_machine.dto.VirtualMachineUpdateDTO;
import com.exam.virtual_machine.entity.VirtualMachine;
import com.exam.virtual_machine.enums.Status;
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

    public void update(VirtualMachine virtualMachine, Status status) {
        final VirtualMachine virtualMachineFound = findById(virtualMachine.getId());
        virtualMachineFound.setName(virtualMachine.getName());
        virtualMachineFound.setCpu(virtualMachine.getCpu());
        virtualMachineFound.setMemory(virtualMachine.getMemory());
        virtualMachineFound.setDisc(virtualMachine.getDisc());

        updateStatus(virtualMachineFound.getId(), status);

        virtualMachineRepository.save(virtualMachineFound);
    }

    public void delete(Long id) {
        virtualMachineRepository.deleteById(id);
    }

    public void updateStatus(Long id, Status status) {
        final VirtualMachine virtualMachine = findById(id);
        virtualMachine.setStatus(status);
    }
}
