package org.coder.learning_navigator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
    private String registrationId;
    private String name;
    @ManyToMany(mappedBy = "students")
    private Set<Subject> subjects;
    @ManyToMany(mappedBy = "students")
    private Set<Exam> exams;

}
