package com.admin.scholarship.repository;

import com.admin.scholarship.model.Student;


import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByName(String username);
	
	
}
