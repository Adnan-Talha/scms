package com.admin.scholarship.controller;

import com.admin.scholarship.model.Student;
import com.admin.scholarship.repository.StudentRepository;
import com.admin.scholarship.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;

    @GetMapping("/apply")
    public String showApplyForm(Student student ,Model model) {
    	model.addAttribute("student", new Student());
    	student.setTenthPercentage(null);  
        student.setTwelfthPercentage(null); 
        student.setIncome(null); 
        return "/student/apply"; // apply.html must be inside /templates
    }
    
    @GetMapping("/student/home")
    public String showStudentHome() {
        return "/student/home"; // Maps to templates/student/home.html
    }

    @GetMapping("/login")
    public String logoutAndRedirect() {
        // Optionally clear session here
        return "/login"; // Maps to templates/login.html
    }
    
    @Autowired
    private StudentService studentService;


    @GetMapping("/admin/searchStudent")
    @ResponseBody
    public String getStudentStatus(@RequestParam String studentName) {
        Student student = studentService.findByName(studentName);
        if (student != null) {
            return student.getStatus().toString();
        } else {
            return "Student not found";
        }
    }


    
    @PostMapping("/apply")
    public String submitForm(@ModelAttribute Student student, Model model) {
        student.setStatus(Student.Status.PENDING); // default status
        studentRepository.save(student);
        model.addAttribute("message", "Application submitted successfully!");
        return "/student/home"; 
    }
    
    
}

