package com.company.tasks;

import com.company.db.Database;
import com.company.entity.Student;

import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<Student> studentList = Database.getStudents();

        // student list ni excelga jadval shaklida yozish
        // har bir viloyatni alohida alohida sheet ga yozish
    }
}
