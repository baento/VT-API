package fr.vt.service;

import java.util.Collection;

import fr.vt.model.Student;

public interface StudentService {
    public Student getStudent(int id);

    public Collection<Student> getAllStudents();

    public Student saveStudent(Student student);
}
