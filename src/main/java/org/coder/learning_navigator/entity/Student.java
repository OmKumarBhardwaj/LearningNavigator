package org.coder.learning_navigator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long registrationId;
    @NotEmpty(message = "Name can not be empty or null")
    @Size(max = 30, message = "The length of the customer name should be between 1 and 50")
    private String name;
    @ManyToMany(mappedBy = "registeredStudents")
    private Set<Subject> subjects;
    @ManyToMany(mappedBy = "enrolledStudents")
    private Set<Exam> exams;
}
