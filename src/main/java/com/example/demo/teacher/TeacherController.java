package com.example.demo.teacher;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    //get all teachers
    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.findAllTeachers();
    }

    //post
    @PostMapping
    public void addTeacher(@RequestBody @Valid Teacher teacher) {
        teacherService.addTeacher(teacher);
    }

    //put

    //delete

    //get  one

}
