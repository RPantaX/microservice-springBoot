package com.proyect.course.service.impl;

import com.proyect.course.client.IStudentClient;
import com.proyect.course.dto.StudentDTO;
import com.proyect.course.entities.Course;
import com.proyect.course.http.response.StudentByCourseResponse;
import com.proyect.course.persistence.ICourseRepository;
import com.proyect.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private ICourseRepository courseRepository;
    @Autowired
    private IStudentClient studentClient;
    @Override
    public List<Course> findAll() {
        return ((List<Course>) courseRepository.findAll());
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {
        //CONSULTAR EL CURSO
        Course course= courseRepository.findById(idCourse).orElse(new Course());
        List<StudentDTO> studentsDto = studentClient.findAllStudentByCourse(idCourse);
        StudentByCourseResponse student= StudentByCourseResponse.builder()
                .coureName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentsDto)
                .build();
        return student;
    }
}
