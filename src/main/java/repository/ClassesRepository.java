package repository;



import domain.Classes;

import java.util.List;

public interface ClassesRepository {

    List<Classes> selectAll();
}
