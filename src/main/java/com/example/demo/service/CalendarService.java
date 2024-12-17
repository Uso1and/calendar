package com.example.demo.service;

import com.example.demo.entity.Day;
import com.example.demo.entity.Month;
import com.example.demo.entity.Year;
import com.example.demo.repository.DayRepository;
import com.example.demo.repository.MonthRepository;
import com.example.demo.repository.YearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarService {

    @Autowired
    private DayRepository dayRepository;

    @Autowired
    private MonthRepository monthRepository;

    @Autowired
    private YearRepository yearRepository;

    // Методы для работы с Year
    public Year createYear(int yearNumber) {
        Year year = new Year(yearNumber);
        return yearRepository.save(year);
    }

    public Optional<Year> getYearById(Long id) {
        return yearRepository.findById(id);
    }

    public List<Year> getAllYears() {
        return yearRepository.findAll();
    }

    // Методы для работы с Month
    public Month createMonth(String name, Year year) {
        Month month = new Month(name, year);
        return monthRepository.save(month);
    }

    public Optional<Month> getMonthById(Long id) {
        return monthRepository.findById(id);
    }

    public List<Month> getAllMonths() {
        return monthRepository.findAll();
    }

    // Методы для работы с Day
    public Day createDay(int dayNumber, Month month) {
        Day day = new Day(dayNumber, month);
        return dayRepository.save(day);
    }

    public Optional<Day> getDayById(Long id) {
        return dayRepository.findById(id);
    }

    public List<Day> getAllDays() {
        return dayRepository.findAll();
    }
}
