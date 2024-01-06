package com.veefin.jpa.services;

import com.veefin.jpa.models.Student;
import com.veefin.jpa.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepositoryService {
    private final StudentRepository studentRepository;
    @Autowired
    public RepositoryService (StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public List<Student> findAllActiveStudents(){
        return studentRepository.findAllActive();
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
    public String updateStudent(Integer id, Student student){
        if(studentRepository.existsById(id)){
            student.setId(id);
            studentRepository.save(student);
            return "Student updated";
        }else{
            return "Student not found";
        }
    }

    public String deleteStudent(Integer id){
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return "Student deleted";
        }else{
            return "Student not found";
        }
    }
}
