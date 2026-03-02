package com.example.demo.service;

import com.example.demo.model.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class FacultyService {
    private List<УправлениеФакультетами> всеФакультеты = new ArrayList<>();
    
    // Получить все факультеты
    public List<УправлениеФакультетами> getAllFaculties() {
        return всеФакультеты;
    }
    
    // Добавить новый факультет
    public void addFaculty(String название, String аудитория, int корпус, String телефон, String декан) {
        Факультет факультет = new Факультет(аудитория, корпус, телефон, декан) {};
        УправлениеФакультетами упр = new УправлениеФакультетами(название, факультет);
        всеФакультеты.add(упр);
    }
    
    // Добавить кафедру на факультет
    public void addDepartment(int facultyIndex, String название, String направление) {
        if (facultyIndex >= 0 && facultyIndex < всеФакультеты.size()) {
            Кафедра кафедра = new Кафедра(название, направление);
            всеФакультеты.get(facultyIndex).добавитьКафедру(кафедра);
        }
    }
    
    // Добавить преподавателя
    public void addTeacher(int facultyIndex, String фио, String кафедра, String должность, int стаж, String дисциплины) {
        if (facultyIndex >= 0 && facultyIndex < всеФакультеты.size()) {
            Преподаватель преп = new Преподаватель(фио, кафедра, должность, стаж, дисциплины);
            всеФакультеты.get(facultyIndex).добавитьПреподавателя(преп);
        }
    }
    
    // Добавить сотрудника в состав факультета
    public void addStaff(int facultyIndex, String фио, String должность) {
        if (facultyIndex >= 0 && facultyIndex < всеФакультеты.size()) {
            СоставФакультета сотрудник = new СоставФакультета(фио, должность);
            всеФакультеты.get(facultyIndex).добавитьВСостав(сотрудник);
        }
    }
    
    // Сортировка по названию факультета
    public void sortByName() {
        Collections.sort(всеФакультеты, new Comparator<УправлениеФакультетами>() {
            @Override
            public int compare(УправлениеФакультетами f1, УправлениеФакультетами f2) {
                return f1.getНазваниеФакультета().compareToIgnoreCase(f2.getНазваниеФакультета());
            }
        });
    }
    
    // Сортировка по корпусу
    public void sortByCorps() {
        Collections.sort(всеФакультеты, new Comparator<УправлениеФакультетами>() {
            @Override
            public int compare(УправлениеФакультетами f1, УправлениеФакультетами f2) {
                return Integer.compare(
                    f1.getФакультет().getКорпус(), 
                    f2.getФакультет().getКорпус()
                );
            }
        });
    }
    
    // Получить количество факультетов
    public int getCount() {
        return всеФакультеты.size();
    }
}