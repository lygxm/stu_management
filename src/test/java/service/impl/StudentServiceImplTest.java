package service.impl;

import config.RootConfig;
import domain.Classes;
import domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.StudentService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testSelect() {
        studentService.selectAll()
                .forEach(e->System.out.println(e));
    }

    @Test
    public void testInsert() {
        Student student = new Student();
        student.setAge(10);
        student.setName("Tom");
        Classes classes = new Classes();
        classes.setId(3);
        student.setClasses(classes);

        studentService.insert(student);
    }

}