package org.coder.learning_navigator.service;

import org.coder.learning_navigator.entity.Exam;
import org.coder.learning_navigator.entity.Student;
import org.coder.learning_navigator.exception.AlreadyEnrolledInExam;
import org.coder.learning_navigator.exception.StudentNotEnrolledInSubject;
import org.coder.learning_navigator.repository.ExamRepository;
import org.coder.learning_navigator.repository.StudentRepository;
import org.coder.learning_navigator.service.impl.ExamServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExamServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private ExamRepository examRepository;

    @InjectMocks
    private ExamServiceImpl examService;

    private Student student;
    private Exam exam;

    @BeforeEach
    void setUp() {
        student = new Student();
        exam = new Exam();
    }

    @Test
    void registerStudentForExam_NotEnrolledInSubject() {
        // Setting the student as not enrolled in any subject
        student.setSubjects(new HashSet<>());
        student.setExams(new HashSet<>());

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        when(examRepository.findById(1L)).thenReturn(Optional.of(exam));

        Exception exception = assertThrows(StudentNotEnrolledInSubject.class, () -> {
            examService.registerStudentForExam(1L, 1L);
        });

        assertEquals("Student is not enrolled in the subject of the exam", exception.getMessage());
    }

    @Test
    void registerStudentForExam_AlreadyEnrolledInExam() {
        // Setting the student as already enrolled in the exam
        student.setSubjects(new HashSet<>());
        student.getSubjects().add(exam.getSubject());
        student.setExams(new HashSet<>());
        student.getExams().add(exam);

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        when(examRepository.findById(1L)).thenReturn(Optional.of(exam));

        Exception exception = assertThrows(AlreadyEnrolledInExam.class, () -> {
            examService.registerStudentForExam(1L, 1L);
        });

        assertEquals("Student is already registered for this exam", exception.getMessage());
    }
}

