package com.admin.scholarship.service;


import com.admin.scholarship.model.Student;
import com.admin.scholarship.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public void updateStatus(int id, Student.Status status) {
        Student student = repo.findById(id).orElseThrow();
        student.setStatus(status);
        repo.save(student);
    }
    
    public String getStatusByName(String studentName) {
        Student student = repo.findByName(studentName);
        return (student != null) ? student.getStatus().toString() : "Student not found";
    }
    
    public Student findByName(String name) {
        return repo.findByName(name);
    }

}
