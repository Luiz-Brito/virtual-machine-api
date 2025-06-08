package com.exam.virtual_machine.service;

import com.exam.virtual_machine.entity.VirtualMachine;
import com.exam.virtual_machine.enums.Status;
import com.exam.virtual_machine.exceptions.VirtualMachineNotFound;
import com.exam.virtual_machine.repository.VirtualMachineRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VirtualMachineServiceTest {

    @Mock
    private VirtualMachineRepository repository;

    @InjectMocks
    private VirtualMachineService service;

    Long id = 1L;

    @Test
    @DisplayName("should return a message exception")
    void findByIdFailure() {

        when(repository.findById(id)).thenReturn(Optional.empty());

        VirtualMachineNotFound exception = assertThrows(
                VirtualMachineNotFound.class,
                () -> service.findById(id)
        );

        assertEquals("Virtual Machine not found!", exception.getMessage());
    }

    @Test
    void updateStatusSuccess()  {
        LocalDateTime createdAt = LocalDateTime.now();
        Status originalStatus = Status.STOP;
        Status newStatus = Status.START;

        VirtualMachine existingVM = new VirtualMachine(id, "original", 1, 2, 3, createdAt, originalStatus);
        VirtualMachine updateVM = new VirtualMachine(id, "updated", 2, 4, 6, createdAt, newStatus);

        when(repository.findById(id)).thenReturn(Optional.of(existingVM));

        service.update(updateVM, newStatus);

        ArgumentCaptor<VirtualMachine> captor = ArgumentCaptor.forClass(VirtualMachine.class);
        verify(repository).save(captor.capture());

        VirtualMachine savedVM = captor.getValue();

        assertEquals("updated", savedVM.getName());
        assertEquals(2, savedVM.getCpu());
        assertEquals(4, savedVM.getMemory());
        assertEquals(6, savedVM.getDisc());
        assertEquals(newStatus, savedVM.getStatus());
    }
}