package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            System.out.println("Student already exists");
        }else {
            studentRepository.save(student);
        }

    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (exists) {
            studentRepository.deleteById(studentId);
        }else {
            System.out.println("Student does not exist");
        }
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(()-> new IllegalStateException("Student not found"));
        if(name != null && !name.isEmpty() && !Objects.equals(name, student.getName())) {
            student.setName(name);
        }

        if(email != null && !email.isEmpty() && !Objects.equals(email, student.getEmail())) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Student already exists");
            }else {
                student.setEmail(email);
            }
        }
    }
}

