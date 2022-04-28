package com.peaksoft.SpringBootCrud.service;

import com.peaksoft.SpringBootCrud.model.Course;
import com.peaksoft.SpringBootCrud.repository.CompanyRepository;
import com.peaksoft.SpringBootCrud.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

//    private final CourseRepository courseRepository;
//    private final CompanyRepository companyRepository;
    @Autowired
    private CourseRepository courseRepository;


    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

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







//    @Override
//    public void updateCourse(Course course) {
//        this.courseRepository.save(course);
//    }
//
//
//    public Course mapToEntity(Course course){
//        Course course1 = new Course();
//        course1.setCourseName(course.getCourseName());
//        course1.setDuration(course.getDuration());
//        course1.setCompany(companyRepository.getById(course.getCompany().getId()));
//        return course1;
//    }
//
//    @Override
//    public Course save(Course course){
//        Course course1 = mapToEntity(course);
//        courseRepository.save(course1);
//        return course1;
//    }


}
