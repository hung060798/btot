package codegym.repository;

import codegym.model.Classroom;
import org.springframework.data.repository.CrudRepository;

public interface IClassRepo extends CrudRepository<Classroom, Long> {
}
