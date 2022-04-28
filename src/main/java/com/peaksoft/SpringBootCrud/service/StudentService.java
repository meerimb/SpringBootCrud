package com.peaksoft.SpringBootCrud.service;

import com.peaksoft.SpringBootCrud.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void saveStudent(Student student);
    Student getStudentById(long id);
    void deleteStudentById(long id);
}
