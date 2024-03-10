package com.adriandotdev.interfaces;

import com.adriandotdev.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface StudentRepository {

    public List<Student> GetAllStudents();
    public Optional<Student> GetStudentByID(int id);

    public int AddStudent(Student student);

    public int RemoveStudentById(int id);
}
