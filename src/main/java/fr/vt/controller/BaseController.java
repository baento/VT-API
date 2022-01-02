package fr.vt.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.vt.model.Student;
import fr.vt.service.StudentService;


@RestController
@RequestMapping
public class BaseController {
    
  @Autowired
  private StudentService studentService;

  @GetMapping("/students")
  public Collection<Student> getStudents() {
    return studentService.getAllStudents();
  }

  @GetMapping("/students/{id}")
  public Student getStudent(@PathVariable Integer id) {
    return studentService.getStudent(id);
  }

}
