package com.humber.FinalProject1.controllers;

import com.humber.FinalProject1.models.Student;
import com.humber.FinalProject1.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Value("${company.name}")
    private String name;

    @Value("10")
    private int pageSize;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/home")
    public String showHomePage(Model model) {
        model.addAttribute("companyName", name);
        return "home";
    }

    @GetMapping("/students")
    public String getAllStudentsWithoutPageNo(Model model,
                                              @RequestParam(required = false) String message,
                                              @RequestParam(required = false) String searchedContact,
                                              @RequestParam(required = false) Integer searchedGrade,
                                              @RequestParam(required = false) String sortField,
                                              @RequestParam(required = false) String sortDirection) {
        return getAllStudents(model, message, searchedContact, searchedGrade, 1, sortField, sortDirection);
    }

    @GetMapping("/students/{pageNo}")
    public String getAllStudents(Model model,
                                 @RequestParam(required = false) String message,
                                 @RequestParam(required = false) String searchedContact,
                                 @RequestParam(required = false) Integer searchedGrade,
                                 @PathVariable int pageNo,
                                 @RequestParam(required = false) String sortField,
                                 @RequestParam(required = false) String sortDirection) {

        sortField = (sortField == null) ? "id" : sortField;
        sortDirection = (sortDirection == null) ? "asc" : sortDirection;

        if (searchedContact != null && searchedGrade != null) {
            List<Student> filteredStudents = companyService.getFilteredStudents(searchedContact, searchedGrade);
            model.addAttribute("students", filteredStudents.isEmpty() ? companyService.getAllStudents() : filteredStudents);
            model.addAttribute("message", filteredStudents.isEmpty() ? "No students found" : "Filtered students successfully");
            return "students";
        }

        Page<Student> page = companyService.getPaginatedStudents(pageSize, pageNo, sortField, sortDirection);
        model.addAttribute("students", page.getContent());
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("reverseSortDirection", sortDirection.equals("asc") ? "desc" : "asc");

        model.addAttribute("message", message);
        return "students";
    }

    @GetMapping("/student-names")
    public String showStudentNames(Model model) {
        List<Student> students = companyService.getAllStudents();
        model.addAttribute("students", students);
        return "name";
    }

    @GetMapping("/class/CPAN-321")
    public String viewClass321(Model model) {
        List<Student> students = companyService.getStudentsByClass("CPAN-321");
        model.addAttribute("students", students);
        model.addAttribute("className", "CPAN-321");
        model.addAttribute("teacherName", "Professor Jones");
        return "students";
    }

    @GetMapping("/class/CPAN-123")
    public String viewClass123(Model model) {
        List<Student> students = companyService.getStudentsByClass("CPAN-123");
        model.addAttribute("students", students);
        model.addAttribute("className", "CPAN-123");
        model.addAttribute("teacherName", "Professor Smith");
        return "students";
    }

    @GetMapping("/class/CPAN-104")
    public String viewClass104(Model model) {
        List<Student> students = companyService.getStudentsByClass("CPAN-104");
        model.addAttribute("students", students);
        model.addAttribute("className", "CPAN-104");
        model.addAttribute("teacherName", "Professor Clark");
        return "students";
    }
}

