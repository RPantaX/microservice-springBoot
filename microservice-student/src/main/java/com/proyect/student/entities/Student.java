package com.proyect.student.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    //trabajar con microservicios es como trabajar con si trabajaramos con relaciones
    //un estudiante puede estar inscrito en muchos cursos y un curso en muchos estudiantes
    //este id nos sirve para poder consultar los cursos en el otro microservicio. Es el parámetro por el que consultaremos al otro microservicio
    @Column(name = "course_id")
    private Long courseId;
}
