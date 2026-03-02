package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class УправлениеФакультетами {
    private String названиеФакультета;
    private Факультет факультет;
    private List<СоставФакультета> состав = new ArrayList<>();
    private List<Кафедра> кафедры = new ArrayList<>();
    private List<Преподаватель> преподаватели = new ArrayList<>();
    
    public УправлениеФакультетами(String названиеФакультета, Факультет факультет) {
        this.названиеФакультета = названиеФакультета;
        this.факультет = факультет;
    }
    
    // Методы добавления
    public void добавитьВСостав(СоставФакультета сотрудник) {
        состав.add(сотрудник);
    }
    
    public void добавитьКафедру(Кафедра кафедра) {
        кафедры.add(кафедра);
    }
    
    public void добавитьПреподавателя(Преподаватель преподаватель) {
        преподаватели.add(преподаватель);
    }
    
    // Геттеры
    public String getНазваниеФакультета() { 
        return названиеФакультета; 
    }
    
    public Факультет getФакультет() { 
        return факультет; 
    }
    
    public List<СоставФакультета> getСостав() { 
        return состав; 
    }
    
    public List<Кафедра> getКафедры() { 
        return кафедры; 
    }
    
    public List<Преподаватель> getПреподаватели() { 
        return преподаватели; 
    }
}