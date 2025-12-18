package com.humber.FinalProject1.services;

import com.humber.FinalProject1.models.Student;
import com.humber.FinalProject1.repositories.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final StudentRepository studentRepository;

    public CompanyService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public int saveStudent(Student student) {
        if (student.getGrade() < 101) {
            studentRepository.save(student);
            return 1;
        }
        return 0;
    }

    public List<Student> getFilteredStudents(String searchedCategory, Integer searchedGrade) {
        return studentRepository.findByCategoryAndStudentGrade(searchedCategory, searchedGrade);
    }

    public int delete(int id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return 1;
        }
        return 0;
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public Page<Student> getPaginatedStudents(int pageSize, int pageNo, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return studentRepository.findAll(pageable);
    }

    // New method to retrieve students by class name
    public List<Student> getStudentsByClass(String className) {
        return studentRepository.findByClassName(className);
    }
}
