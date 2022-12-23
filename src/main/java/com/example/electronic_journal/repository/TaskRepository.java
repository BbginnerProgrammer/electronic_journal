package com.example.electronic_journal.repository;


import com.example.electronic_journal.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Tasks, Long> {
}
