package com.example.ServiceManager.Repository;

import com.example.ServiceManager.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByActivityContaining(String keyboard);
}
