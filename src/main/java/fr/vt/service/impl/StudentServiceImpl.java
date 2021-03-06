package fr.vt.service.impl;

import java.util.Collection;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.vt.model.Student;
import fr.vt.repository.StudentRepository;
import fr.vt.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudent(int id) {
        return studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
