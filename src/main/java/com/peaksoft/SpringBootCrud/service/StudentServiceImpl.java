package com.peaksoft.SpringBootCrud.service;

import com.peaksoft.SpringBootCrud.model.Student;
import com.peaksoft.SpringBootCrud.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public Student getStudentById(long id) {
        Optional< Student > optional = studentRepository.findById(id);
        Student student = null;
        if (optional.isPresent()) {
            student = optional.get();
        } else {
            throw new RuntimeException(" Student not found for id :: " + id);
        }
        return student;
    }

    @Override
    public void deleteStudentById(long id) {
        this.studentRepository.deleteById(id);
    }
}
