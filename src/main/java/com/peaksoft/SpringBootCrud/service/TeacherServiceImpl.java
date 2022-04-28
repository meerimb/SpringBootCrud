package com.peaksoft.SpringBootCrud.service;

import com.peaksoft.SpringBootCrud.model.Teacher;
import com.peaksoft.SpringBootCrud.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{

   private final TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public void saveTeacher(Teacher teacher) {
    this.teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacherById(long id) {
        Optional< Teacher > optional = teacherRepository.findById(id);
        Teacher teacher = null;
        if (optional.isPresent()) {
            teacher = optional.get();
        } else {
            throw new RuntimeException(" Teacher not found for id :: " + id);
        }
        return teacher;
    }

    @Override
    public void deleteTeacherById(long id) {
    this.teacherRepository.deleteById(id);
    }
}
