package com.humber.FinalProject1.controllers;

import com.humber.FinalProject1.models.Student;
import com.humber.FinalProject1.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/company/teacher")
public class TeacherController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/update/{id}")
    public String updateStudent(Model model, @PathVariable int id) {
        Optional<Student> studentToUpdate = companyService.getStudentById(id);
        model.addAttribute("student", studentToUpdate.orElse(null));
        return "admin/add-students"; // Update view; change if necessary
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
        return "students";
    }
}
