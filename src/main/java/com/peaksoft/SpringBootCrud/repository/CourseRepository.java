package com.peaksoft.SpringBootCrud.repository;

import com.peaksoft.SpringBootCrud.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}