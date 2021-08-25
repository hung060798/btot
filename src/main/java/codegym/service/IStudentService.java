package codegym.service;

import codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface IStudentService {

    Student save(Student student);

    Student findById(long id);

    Page<Student> findByName(String name);

    Page<Student> findAll(Pageable pageable);

    void delete(Student customer);

}
