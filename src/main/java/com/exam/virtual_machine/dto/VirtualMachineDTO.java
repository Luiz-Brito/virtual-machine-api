package com.exam.virtual_machine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VirtualMachineDTO {
    private Long id;
    private String name;
    private Integer cpu;
    private Integer memory;
    private Integer disc;
    private LocalDateTime createdAt;
}
