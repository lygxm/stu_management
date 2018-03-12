package service.impl;

import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repository.StudentRepository;
import service.StudentService;

import java.util.List;

@Service

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> selectAll() {
        return studentRepository.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED
    ,isolation = Isolation.DEFAULT)
    public void insert(Student student) {

        studentRepository.insert(student);

    }

}
