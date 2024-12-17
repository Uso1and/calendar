package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "calendar_day")
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int dayNumber; 

    @ManyToOne
    @JoinColumn(name = "month_id")
    private Month month;

    public Day() {
    }

    public Day(int dayNumber, Month month) {
        this.dayNumber = dayNumber;
        this.month = month;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }
}
