package service.impl;

import domain.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repository.ClassesRepository;
import service.ClassesService;

import java.util.List;

@Service
@Scope("prototype")
public class ClassesServiceImpl implements ClassesService{

    @Autowired
    ClassesRepository classesRepository;

    @Transactional(
            propagation = Propagation.REQUIRED
    ,isolation = Isolation.DEFAULT)
    @Override
    public List<Classes> selectAll() {
        return classesRepository.selectAll();
    }
}
