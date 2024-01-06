package com.veefin.jpa.repos;

import com.veefin.jpa.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAll();

    @Query("SELECT s FROM Student s WHERE s.isActive = 1")
        List<Student> findAllActive();

    Student save(Student student);

    boolean existsById(Integer id);

}
