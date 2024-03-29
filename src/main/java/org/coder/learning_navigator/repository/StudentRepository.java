package org.coder.learning_navigator.repository;

import org.coder.learning_navigator.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
