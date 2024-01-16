package com.ATDev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ATDev.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
