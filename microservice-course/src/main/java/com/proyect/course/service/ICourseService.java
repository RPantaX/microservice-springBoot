package com.proyect.course.service;

import com.proyect.course.entities.Course;
import com.proyect.course.http.response.StudentByCourseResponse;

import java.util.List;

public interface ICourseService {
    List<Course> findAll();
    Course findById(Long id);
    void save(Course course);
    StudentByCourseResponse findStudentsByIdCourse(Long idCourse);
}
