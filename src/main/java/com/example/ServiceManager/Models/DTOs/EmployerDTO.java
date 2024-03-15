package com.example.ServiceManager.Models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDTO {
    private Long Id;
    private String name;
    private List<TaskDTO> taskDTO;
}
