package com.example.demo.model;

public class Преподаватель {
    private String фио;
    private String кафедра;
    private String должность;
    private int стаж;
    private String дисциплины;
    
    public Преподаватель(String фио, String кафедра, String должность, int стаж, String дисциплины) {
        this.фио = фио;
        this.кафедра = кафедра;
        this.должность = должность;
        this.стаж = стаж;
        this.дисциплины = дисциплины;
    }
    
    // Геттеры
    public String getФио() { 
        return фио; 
    }
    
    public String getКафедра() { 
        return кафедра; 
    }
    
    public String getДолжность() { 
        return должность; 
    }
    
    public int getСтаж() { 
        return стаж; 
    }
    
    public String getДисциплины() { 
        return дисциплины; 
    }
    
    @Override
    public String toString() {
        return фио + " - " + должность + " (каф. " + кафедра + "), стаж: " + стаж + " лет, дисциплины: " + дисциплины;
    }
}