package com.ghazal.restcrudapi.rest;

import com.ghazal.restcrudapi.entity.Student;
import com.ghazal.restcrudapi.exception.StudentErrorResponse;
import com.ghazal.restcrudapi.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Mary", "Poppins"));
        students.add(new Student("James", "Fisher"));
        students.add(new Student("Super", "Mario"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        // throw custom exception if not found
        if((studentId < 0) || (studentId >= students.size())){
            throw new StudentNotFoundException("student Id: " + studentId + " not found.");
        }
        return students.get(studentId);

    }


}
