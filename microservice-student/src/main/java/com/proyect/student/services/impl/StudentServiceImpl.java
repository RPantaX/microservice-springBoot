package com.proyect.student.services.impl;

import com.proyect.student.entities.Student;
import com.proyect.student.persistence.StudentRepository;
import com.proyect.student.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findByIdCouse(Long idCourse) {
        return studentRepository.findAllStudent(idCourse);
    }
}
