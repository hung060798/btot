package codegym.service;


import codegym.model.Student;
import codegym.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService{
    @Autowired
    IStudentRepo iStudentRepo;

    @Override
    public Student save(Student student){
        return iStudentRepo.save(student);
    }

    @Override
    public Student findById(long id) {
        return iStudentRepo.findById(id).get();
    }

    @Override
    public Page<Student> findByName(String name) {
        return (Page<Student>) iStudentRepo.findByName(name);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return (Page<Student>) iStudentRepo.findAll(pageable);
    }

    @Override
    public void delete(Student student) {
        iStudentRepo.delete(student);
    }

}
