package com.humber.FinalProject1.controllers;

import com.humber.FinalProject1.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company/student")
public class StudentController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/student-names")
    public String showStudentNames(Model model) {
        model.addAttribute("students", companyService.getAllStudents());
        return "students";
    }
}
