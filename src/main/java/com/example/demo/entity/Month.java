package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "calendar_month")
public class Month {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Название месяца

    @OneToMany(mappedBy = "month", cascade = CascadeType.ALL)
    private List<Day> days; // Дни, принадлежащие месяцу

    @ManyToOne
    @JoinColumn(name = "year_id")
    private Year year; // Год, которому принадлежит месяц

    public Month() {
    }

    public Month(String name, Year year) {
        this.name = name;
        this.year = year;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }
}
