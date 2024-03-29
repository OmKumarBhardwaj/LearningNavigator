package org.coder.learning_navigator.repository;

import org.coder.learning_navigator.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, String> {
}
