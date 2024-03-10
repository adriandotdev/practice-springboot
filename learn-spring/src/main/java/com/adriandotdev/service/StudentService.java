package com.adriandotdev.service;

import com.adriandotdev.interfaces.StudentRepository;
import com.adriandotdev.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepo;

    @Autowired
    public StudentService(@Qualifier("JDBCRepository") StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> GetAllStudents() {
        return this.studentRepo.GetAllStudents();
    }

    public Student GetStudentByID(int id) {
        return this.studentRepo.GetStudentByID(id).orElseThrow();
    }

    public int AddStudent(Student student) {
        return this.studentRepo.AddStudent(student);
    }

    public int RemoveStudent(int id) {

        return this.studentRepo.RemoveStudentById(id);
    }
}
