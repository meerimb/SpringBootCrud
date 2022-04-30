package com.peaksoft.SpringBootCrud.service;

import com.peaksoft.SpringBootCrud.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    void saveCourse(Course course);
    Course getCourseById(long id);
    void deleteCourseById(long id);
}
