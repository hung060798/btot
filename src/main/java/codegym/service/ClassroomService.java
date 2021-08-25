package codegym.service;

import codegym.model.Classroom;
import codegym.repository.IClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClassroomService implements IClassroomService{
    @Autowired
    IClassRepo iClassRepo;

    @Override
    public ArrayList<Classroom> findAll() {
        return (ArrayList<Classroom>) iClassRepo.findAll();
    }

    @Override
    public Classroom findById(long id) {
        return iClassRepo.findById(id).get();
    }
}
