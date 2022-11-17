package com.company.tasks;

import com.company.db.Database;
import com.company.entity.Student;

import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<Student> studentList = Database.getStudents();

        // student list ni pdfga jadval shaklida yozish
    }
}
