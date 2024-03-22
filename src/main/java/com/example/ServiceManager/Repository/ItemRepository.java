package com.example.ServiceManager.Repository;

import com.example.ServiceManager.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
