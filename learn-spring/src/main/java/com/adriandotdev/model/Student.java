package com.adriandotdev.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class Student {

    private int id;
    @NotBlank(message = "First name must not be blank")
    private String first_name;

    @NotBlank(message = "Last name must not be blank")
    private String last_name;

    @NotNull(message = "Date of birth must not be null")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Invalid date of birth format. Use yyyy-MM-dd")
    private String date_of_birth;


    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                '}';
    }
}
