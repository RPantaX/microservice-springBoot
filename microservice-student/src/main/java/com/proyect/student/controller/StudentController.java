package com.proyect.student.controller;

import com.proyect.student.entities.Student;
import com.proyect.student.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void saveStudent(@RequestBody Student student){
        studentService.save(student);
    }
    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(studentService.findById(id));
    }
    //habilitamos un enpoint para que pueda ser consumido por nuestro microservicio de course.
    @GetMapping("/search-by-course/{idCourse}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(studentService.findByIdCouse(idCourse));
    }
}
