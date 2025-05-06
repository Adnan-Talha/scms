package com.admin.scholarship.controller;

import com.admin.scholarship.model.Student;
//import com.admin.scholarship.service.MessageService;
import com.admin.scholarship.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StudentService studentService;
   // private MessageService messageService;
    // View student list
    @GetMapping("/applications")
    public String viewDashboard(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "admin/applications"; // src/main/resources/templates/admin/dashboard.html
    }

    // Approve student
    @PostMapping("/approve/{id}")
    public String approve(@PathVariable int id) {
        studentService.updateStatus(id, Student.Status.APPROVED);
        return "redirect:/admin/applications";
    }

    // Reject student
    @PostMapping("/reject/{id}")
    public String reject(@PathVariable int id) {
        studentService.updateStatus(id, Student.Status.REJECTED);
        return "redirect:/admin/applications";
    }

    // Other admin pages
    
    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }
    
    @GetMapping("/scholarships")
    public String scholarships() {
        return "admin/scholarships";
    }

    //@GetMapping("/messages")
    //public String messages() {
     //   return "admin/admin-messages";
    //}
    
    //@GetMapping("/messages")
    //public String viewMessages(Model model) {
    //    model.addAttribute("messages", messageService.getAllMessages());
    //    return "admin/admin-messages"; // redirect after successful submission
    //}
    
    @GetMapping("/logout")
    public String logout() {
        return "admin/logout";
    }
}
