package com.proyect.course.client;

import com.proyect.course.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//nombre del microservicio al cual vamos a consultar
@FeignClient(name = "msvc-student", url = "localhost:8080/api/student")
public interface IStudentClient {
    //le indicamos específicamente a que endpoint se tiene que conectar
    @GetMapping("/search-by-course/{idCourse}")
    List<StudentDTO>findAllStudentByCourse(@PathVariable Long idCourse);
}
