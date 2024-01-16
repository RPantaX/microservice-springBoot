package com.proyect.student.services;

import com.proyect.student.entities.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(Long id);
    void save (Student student);
    List<Student> findByIdCouse(Long idCourse);
}
