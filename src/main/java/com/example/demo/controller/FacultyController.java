package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FacultyController {
    
    @Autowired
    private FacultyService facultyService;
    
    // Главная страница - показывает все факультеты
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("faculties", facultyService.getAllFaculties());
        model.addAttribute("count", facultyService.getCount());
        return "index";
    }
    
    // Страница добавления факультета
    @GetMapping("/add-faculty")
    public String showAddFacultyForm() {
        return "add-faculty";
    }
    
    // Обработка добавления факультета
    @PostMapping("/add-faculty")
    public String addFaculty(
            @RequestParam String name,
            @RequestParam String аудитория,
            @RequestParam int корпус,
            @RequestParam String телефон,
            @RequestParam String декан) {
        
        facultyService.addFaculty(name, аудитория, корпус, телефон, декан);
        return "redirect:/";
    }
    
    // Страница добавления кафедры
    @GetMapping("/add-department")
    public String showAddDepartmentForm(Model model) {
        model.addAttribute("faculties", facultyService.getAllFaculties());
        return "add-department";
    }
    
    // Обработка добавления кафедры
    @PostMapping("/add-department")
    public String addDepartment(
            @RequestParam int facultyIndex,
            @RequestParam String название,
            @RequestParam String направление) {
        
        facultyService.addDepartment(facultyIndex - 1, название, направление);
        return "redirect:/";
    }
    
    // Страница добавления преподавателя
    @GetMapping("/add-teacher")
    public String showAddTeacherForm(Model model) {
        model.addAttribute("faculties", facultyService.getAllFaculties());
        return "add-teacher";
    }
    
    // Обработка добавления преподавателя
    @PostMapping("/add-teacher")
    public String addTeacher(
            @RequestParam int facultyIndex,
            @RequestParam String фио,
            @RequestParam String кафедра,
            @RequestParam String должность,
            @RequestParam int стаж,
            @RequestParam String дисциплины) {
        
        facultyService.addTeacher(facultyIndex - 1, фио, кафедра, должность, стаж, дисциплины);
        return "redirect:/";
    }
    
    // Страница добавления сотрудника
    @GetMapping("/add-staff")
    public String showAddStaffForm(Model model) {
        model.addAttribute("faculties", facultyService.getAllFaculties());
        return "add-staff";
    }
    
    // Обработка добавления сотрудника
    @PostMapping("/add-staff")
    public String addStaff(
            @RequestParam int facultyIndex,
            @RequestParam String фио,
            @RequestParam String должность) {
        
        facultyService.addStaff(facultyIndex - 1, фио, должность);
        return "redirect:/";
    }
    
    // Сортировка по названию
    @GetMapping("/sort-by-name")
    public String sortByName() {
        facultyService.sortByName();
        return "redirect:/";
    }
    
    // Сортировка по корпусу
    @GetMapping("/sort-by-corps")
    public String sortByCorps() {
        facultyService.sortByCorps();
        return "redirect:/";
    }
    
    // Тестовая страница
    @GetMapping("/simple")
    public String simple() {
        return "simple";
    }
}