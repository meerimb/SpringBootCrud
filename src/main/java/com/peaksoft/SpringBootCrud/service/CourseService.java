package com.peaksoft.SpringBootCrud.service;

import com.peaksoft.SpringBootCrud.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
//    void updateCourse(Course course);
    void saveCourse(Course course);
    Course getCourseById(long id);
    void deleteCourseById(long id);
//    Course save(Course course);
}
