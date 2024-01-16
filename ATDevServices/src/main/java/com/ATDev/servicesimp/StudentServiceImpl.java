package com.ATDev.servicesimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ATDev.entities.Student;
import com.ATDev.exceptions.ResourceNotFoundException;
import com.ATDev.repositories.StudentRepo;
import com.ATDev.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		Student saved = studentRepo.save(student);
		return saved;
	}

	@Override
	public Student updateStudent(Student student, Integer stdId) {
		// TODO Auto-generated method stub
		Student std = studentRepo.findById(stdId)
				.orElseThrow(() -> new ResourceNotFoundException("student", "studentId", stdId));
		std.setStudentName(student.getStudentName());
		std.setStudentEmail(student.getStudentEmail());
		std.setStudentClass(student.getStudentClass());
		std.setStudentContactNumber(student.getStudentContactNumber());
		Student updatedStudent = studentRepo.save(std);
		return updatedStudent;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> findAll = studentRepo.findAll();
		return findAll;
	}

	@Override
	public Student getStudentById(Integer stdId) {
		// TODO Auto-generated method stub
		Student student = studentRepo.findById(stdId)
				.orElseThrow(() -> new ResourceNotFoundException("student", "studentId", stdId));
		return student;
	}

	@Override
	public void deleteStudent(Integer stdId) {
		// TODO Auto-generated method stub
		Student student = studentRepo.findById(stdId)
				.orElseThrow(() -> new ResourceNotFoundException("student", "studentId", stdId));
		studentRepo.delete(student);
		
	}

}
