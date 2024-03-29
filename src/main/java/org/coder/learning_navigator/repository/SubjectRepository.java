package org.coder.learning_navigator.repository;

import org.coder.learning_navigator.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, String> {
}
