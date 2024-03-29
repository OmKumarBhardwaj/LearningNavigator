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
    private String name;
    @ManyToMany(mappedBy = "registeredStudents")
    private Set<Subject> subjects;
    @ManyToMany(mappedBy = "enrolledStudents")
    private Set<Exam> exams;
}
