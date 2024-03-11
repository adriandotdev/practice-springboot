package com.adriandotdev.controller;

import com.adriandotdev.model.Student;
import com.adriandotdev.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {

    public record CustomResponseEntity<T>(String message, HttpStatus status, T data) {}
    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<CustomResponseEntity<List<Student>>> GetStudents() {

        List<Student> students = this.service.GetAllStudents();

        return new ResponseEntity<>(new CustomResponseEntity<>("Success", HttpStatus.OK, students), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponseEntity<Student>> GetStudentByID(@PathVariable int id) {

        try {
           Student student = this.service.GetStudentByID(id);

           return new ResponseEntity<>(new CustomResponseEntity<>("Success", HttpStatus.OK, student), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new CustomResponseEntity<>("Student cannot find in database", HttpStatus.NOT_FOUND, null), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<CustomResponseEntity<Integer>> addStudent(@Valid @RequestBody Student student, BindingResult result) {

        if (result.hasErrors()) {
            return new ResponseEntity<>(new CustomResponseEntity<>(result.toString(), HttpStatus.BAD_REQUEST, null), HttpStatus.BAD_REQUEST);
        }
        System.out.println("SUCCESS");
        int affectedRows = this.service.AddStudent(student);

        return new ResponseEntity<>(new CustomResponseEntity<>("Successfully created new student", HttpStatus.OK, affectedRows), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponseEntity<Integer>> RemoveStudent(@PathVariable int id) {

        int affectedRows = this.service.RemoveStudent(id);

        return new ResponseEntity<>(new CustomResponseEntity<>("Successfully deleted a student with id of " + id, HttpStatus.OK, affectedRows), HttpStatus.OK);
    }
}
