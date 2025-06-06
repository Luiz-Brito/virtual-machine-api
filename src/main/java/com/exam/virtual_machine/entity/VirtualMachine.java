package com.exam.virtual_machine.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="virtual-machines")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VirtualMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="cpu")
    private Integer cpu;

    @Column(name="memory")
    private Integer memory;

    @Column(name="disc")
    private Integer disc;

    @Column(name="created_at")
    private LocalDateTime createdAt;
}
