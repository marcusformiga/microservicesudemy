package com.formigadev.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formigadev.hrworker.entities.Worker;

public interface WorkerRepo extends JpaRepository<Worker, Long> {
  
}
