package com.example.demo.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("select t  from  Teacher  t where t.email =?1")
    Optional<Teacher> findByEmail(String email);
}
