package com.example.springmongo;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student studentByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> studentByNameOrEmail(String name, String email) {
        return studentRepository.findByNameOrEmail(name, email);
    }

    public List<Student> getAllWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> getAllWithSorting() {
        Sort sort  = Sort.by(Sort.Direction.ASC, "name", "email","");
        return studentRepository.findAll(sort);
    }

    public List<Student> byDepartmentName(String departmentName) {
        return studentRepository.findByDepartmentDepartmentName(departmentName);
    }

    public List<Student> bySubjectName(String subjectName) {
        return studentRepository.findBySubjectsSubjectName(subjectName);
    }

    public List<Student> emailLike(String email) {
        return studentRepository.findByEmailLike(email);
    }
}
