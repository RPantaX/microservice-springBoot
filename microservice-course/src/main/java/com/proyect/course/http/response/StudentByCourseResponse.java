package com.proyect.course.http.response;

import com.proyect.course.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//esto es lo que le responderemos al cliente
public class StudentByCourseResponse {
    private String coureName;
    private String teacher;
    private List<StudentDTO> studentDTOList;
}
