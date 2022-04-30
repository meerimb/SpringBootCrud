package com.peaksoft.SpringBootCrud.service;

import com.peaksoft.SpringBootCrud.model.Course;
import com.peaksoft.SpringBootCrud.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void saveCourse(Course course) {
      this.courseRepository.save(course);
    }

    @Override
    public Course getCourseById(long id) {
        Optional< Course > optional = courseRepository.findById(id);
        Course course = null;
        if (optional.isPresent()) {
            course = optional.get();
        } else {
            throw new RuntimeException(" Course not found for id :: " + id);
        }
        return course;
    }

    @Override
    public void deleteCourseById(long id) {
        this.courseRepository.deleteById(id);
    }

}
