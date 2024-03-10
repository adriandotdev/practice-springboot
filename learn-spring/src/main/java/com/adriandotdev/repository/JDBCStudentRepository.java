package com.adriandotdev.repository;

import com.adriandotdev.interfaces.StudentRepository;
import com.adriandotdev.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("JDBCRepository")
@SuppressWarnings("Unused because it is Autowired")
public class JDBCStudentRepository implements StudentRepository {

    @Autowired
    public JdbcTemplate template;

    @Override
    public List<Student> GetAllStudents() {
        return template.query("SELECT *" +
                "FROM students", BeanPropertyRowMapper.newInstance(Student.class));
    }

    @Override
    public Optional<Student> GetStudentByID(int id)  {
        List<Student> students = this.template.query("SELECT *" +
                " FROM students" +
                " WHERE id = ?", BeanPropertyRowMapper.newInstance(Student.class), id);

        return Optional.ofNullable(students.isEmpty() ? null : students.get(0));
    }


    @Override
    public int AddStudent(Student student) {

        return this.template.update("INSERT INTO students " +
                "(first_name, last_name, date_of_birth) " +
                "VALUES (?,?,?)", student.getFirst_name(), student.getLast_name(), student.getDate_of_birth());
    }

    @Override
    public int RemoveStudentById(int id) {

        return this.template.update("DELETE FROM students " +
                "WHERE id = ?", id);
    }
}
