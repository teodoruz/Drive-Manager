package com.example.ServiceManager.Models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private Long Id;
    private String activity;
    private List<Long> employersIds;



}
