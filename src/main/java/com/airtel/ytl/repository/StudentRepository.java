package com.airtel.ytl.repository;


import com.airtel.ytl.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student getByName(String name);
}
