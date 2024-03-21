package com.example.ServiceManager.Models.DTOs;

import com.example.ServiceManager.Models.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BudgetDTO {
    private Long Id;
    private Double value;
    private List<Item> itemList;
}
