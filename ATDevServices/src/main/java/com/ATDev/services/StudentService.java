package com.ATDev.services;

import java.util.List;

import com.ATDev.entities.Student;

public interface StudentService {
	public Student createStudent(Student student);
	public Student updateStudent(Student student, Integer stdId);
	public List<Student> getAllStudents();
	public Student getStudentById(Integer stdId);
	public void deleteStudent(Integer stdId);
	
}
