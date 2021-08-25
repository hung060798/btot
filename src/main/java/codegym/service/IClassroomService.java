package codegym.service;

import codegym.model.Classroom;

import java.util.ArrayList;

public interface IClassroomService {
    ArrayList<Classroom> findAll();
    Classroom findById(long id);
}
