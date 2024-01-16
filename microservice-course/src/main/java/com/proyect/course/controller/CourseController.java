package com.proyect.course.controller;

import com.proyect.course.entities.Course;
import com.proyect.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/course")
@RestController
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void saveCourse(@RequestBody Course course){
        courseService.save(course);
    }
    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping("/search-student/{idCourse}")
    public ResponseEntity<?> findStudentsByIdCourse(@PathVariable(name = "idCourse") Long idCourse){
        return ResponseEntity.ok(courseService.findStudentsByIdCourse(idCourse));
    }
}
