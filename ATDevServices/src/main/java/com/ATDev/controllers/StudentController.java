package com.ATDev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ATDev.entities.Student;
import com.ATDev.services.StudentService;

@RestController
@RequestMapping("api/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> allStudents = studentService.getAllStudents();
		return new ResponseEntity<>(allStudents, HttpStatus.OK);
	}

	@GetMapping("/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer studentId) {
		Student student = studentService.getStudentById(studentId);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@PostMapping("/new")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student std = studentService.createStudent(student);
		return new ResponseEntity<>(std, HttpStatus.CREATED);
	}

	@PutMapping("/update/{studentId}")
	public ResponseEntity<Student> createStudent(@RequestBody Student student, @PathVariable Integer studentId) {
		Student std = studentService.updateStudent(student, studentId);
		return new ResponseEntity<>(std, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<?> createStudent(@PathVariable Integer studentId) {
		studentService.deleteStudent(studentId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
