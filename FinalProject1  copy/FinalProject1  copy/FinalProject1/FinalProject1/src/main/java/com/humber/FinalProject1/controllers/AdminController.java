package com.humber.FinalProject1.controllers;

import com.humber.FinalProject1.models.Student;
import com.humber.FinalProject1.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/company/admin")
public class AdminController {

    @Autowired
    private CompanyService companyService;

    @Value("${company.name}")
    private String name;

    @GetMapping("/add-students")
    public String addStudent(Model model) {
        if (isTeacher()) {
            return "redirect:/company/home"; // Redirect teacher to home page if they try to access add-students
        }
        model.addAttribute("student", new Student());
        return "admin/add-students";
    }

    @PostMapping("/add-students")
    public String addStudent(@ModelAttribute Student student, Model model) {
        if (isTeacher()) {
            return "redirect:/company/home"; // Redirect teacher to home page if they try to add a student
        }

        int statusCode = companyService.saveStudent(student);

        if (statusCode == 1) {
            return "redirect:/company/students/1?message=Student added successfully!";
        }

        model.addAttribute("error", "Grade should be less than 101");
        return "admin/add-students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        if (isTeacher()) {
            return "redirect:/company/home"; // Redirect teacher to home page if they try to delete a student
        }

        int deleteStatusCode = companyService.delete(id);

        if (deleteStatusCode == 1) {
            return "redirect:/company/students/1?message=Student deleted successfully!";
        }
        return "redirect:/company/students/1?message=Student deletion unsuccessful!";
    }

    @GetMapping("/update/{id}")
    public String updateStudent(Model model, @PathVariable int id) {
        Optional<Student> studentToUpdate = companyService.getStudentById(id);
        model.addAttribute("student", studentToUpdate.orElse(null));
        return "admin/add-students";
    }

    @PostMapping("/update-student")
    public String updateStudent(@ModelAttribute Student student) {
        companyService.updateStudent(student);
        return "redirect:/company/students/1?message=Student updated successfully!";
    }

    @GetMapping("/student-names")
    public String showStudentNames(Model model) {
        List<Student> students = companyService.getAllStudents();
        model.addAttribute("students", students);
        return "name";
    }

    // Helper method to check if the current user is a Teacher
    private boolean isTeacher() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        return userDetails.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_TEACHER"));
    }
}
