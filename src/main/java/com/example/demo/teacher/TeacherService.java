package com.example.demo.teacher;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    //get all teachers
    List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    //add a teacher
    void addTeacher(@NotNull Teacher teacher) {
        Optional<Teacher> optionalTeacher = teacherRepository.findByEmail(teacher.getEmail());
        if (optionalTeacher.isPresent()) {
            System.out.println("Teacher already exists");
        }else {
            teacherRepository.save(teacher);
        }
    }
}
