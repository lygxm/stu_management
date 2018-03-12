package service.impl;

import config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.ClassesService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class ClassesServiceImplTest {

    @Autowired
    private ClassesService classesService;

    @Test
    public void test() {
        classesService.selectAll().forEach(e->System.out.println(e));
    }

}