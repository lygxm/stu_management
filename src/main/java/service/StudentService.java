package service;

import domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectAll();
    void insert(Student student);
}
