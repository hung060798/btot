package codegym.repository;

import codegym.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface IStudentRepo extends PagingAndSortingRepository<Student, Long> {
    @Query(value = "select s from Student as s where s.name like  concat('%', :studentName ,'%') ")
    ArrayList<Student> findByName(@Param("studentName") String studentName);
}
