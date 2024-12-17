package com.example.demo.controller;

import com.example.demo.entity.Day;
import com.example.demo.entity.Month;
import com.example.demo.entity.Year;
import com.example.demo.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    
    @PostMapping("/years")
    public Year createYear(@RequestParam int yearNumber) {
        return calendarService.createYear(yearNumber);
    }

    @GetMapping("/years/{id}")
    public Optional<Year> getYear(@PathVariable Long id) {
        return calendarService.getYearById(id);
    }

    @GetMapping("/years")
    public List<Year> getAllYears() {
        return calendarService.getAllYears();
    }

   
    @PostMapping("/months")
    public Month createMonth(@RequestParam String name, @RequestParam Long yearId) {
        Optional<Year> year = calendarService.getYearById(yearId);
        return year.map(y -> calendarService.createMonth(name, y)).orElse(null);
    }

    @GetMapping("/months/{id}")
    public Optional<Month> getMonth(@PathVariable Long id) {
        return calendarService.getMonthById(id);
    }

    @GetMapping("/months")
    public List<Month> getAllMonths() {
        return calendarService.getAllMonths();
    }

   
    @PostMapping("/days")
    public Day createDay(@RequestParam int dayNumber, @RequestParam Long monthId) {
        Optional<Month> month = calendarService.getMonthById(monthId);
        return month.map(m -> calendarService.createDay(dayNumber, m)).orElse(null);
    }

    @GetMapping("/days/{id}")
    public Optional<Day> getDay(@PathVariable Long id) {
        return calendarService.getDayById(id);
    }

    @GetMapping("/days")
    public List<Day> getAllDays() {
        return calendarService.getAllDays();
    }
}
