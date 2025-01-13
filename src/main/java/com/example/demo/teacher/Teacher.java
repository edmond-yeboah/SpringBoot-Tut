package com.example.demo.teacher;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )

    private Long Id;
    private String fullName;
    @NotEmpty
    @Email
    @NotNull
    private String email;
    private String phone;

    @Override
    public String toString() {
        return "Teacher{" +
                "Id=" + Id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(Id, teacher.Id) && Objects.equals(fullName, teacher.fullName) && Objects.equals(email, teacher.email) && Objects.equals(phone, teacher.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, fullName, email, phone);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Teacher(String fullName, String email, String phone) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public Teacher(Long id, String fullName, String email, String phone) {
        Id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public Teacher() {
    }
}
