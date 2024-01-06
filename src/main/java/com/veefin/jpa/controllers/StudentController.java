package com.veefin.jpa.controllers;

import com.veefin.jpa.models.Student;
import com.veefin.jpa.services.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final RepositoryService repositoryService;

    @Autowired
    public StudentController (RepositoryService repositoryService){
        this.repositoryService = repositoryService;
    }
    @GetMapping("/getStudents")
    public List<Student> findAllStudents(){
        return repositoryService.findAllStudents();
    }

    @GetMapping("/getActiveStudents")
    public List<Student> findAllActiveStudents(){
        return repositoryService.findAllActiveStudents();
    }

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student){
        return repositoryService.saveStudent(student);
    }

    @PutMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable Integer id, @RequestBody Student student){
        return repositoryService.updateStudent(id, student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Integer id){
        return repositoryService.deleteStudent(id);
    }
}
