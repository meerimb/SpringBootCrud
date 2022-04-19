package com.peaksoft.SpringBootCrud.service;

import com.peaksoft.SpringBootCrud.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    void saveTeacher(Teacher teacher);
    Teacher getTeacherById(long id);
    void deleteTeacherById(long id);
}
