package com.peaksoft.SpringBootCrud.repository;

import com.peaksoft.SpringBootCrud.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
