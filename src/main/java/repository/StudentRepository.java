package repository;

import domain.Student;

import java.util.List;

public interface StudentRepository {

    List<Student> selectAll();
    void insert(Student student);
}
