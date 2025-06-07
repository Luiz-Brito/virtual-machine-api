package com.exam.virtual_machine.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VirtualMachineCreateDTO {

    @NotBlank
    @Size(min = 5)
    private String name;

    @NotNull
    @Min(value = 1)
    private Integer cpu;

    @NotNull
    @Min(value = 1)
    private Integer memory;

    @NotNull
    @Min(value = 1)
    private Integer disc;
}
