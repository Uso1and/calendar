package com.example.demo.repository;

import com.example.demo.entity.Month;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthRepository extends JpaRepository<Month, Long> {
}
