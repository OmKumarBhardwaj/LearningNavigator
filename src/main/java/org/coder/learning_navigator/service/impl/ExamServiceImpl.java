package org.coder.learning_navigator.service.impl;

import lombok.AllArgsConstructor;
import org.coder.learning_navigator.entity.Exam;
import org.coder.learning_navigator.entity.Student;
import org.coder.learning_navigator.exception.AlreadyEnrolledInExam;
import org.coder.learning_navigator.exception.ExamNotFound;
import org.coder.learning_navigator.exception.StudentNotEnrolledInSubject;
import org.coder.learning_navigator.exception.StudentNotFound;
import org.coder.learning_navigator.repository.ExamRepository;
import org.coder.learning_navigator.repository.StudentRepository;
import org.coder.learning_navigator.service.ExamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ExamServiceImpl implements ExamService {

    private StudentRepository studentRepository;

    private ExamRepository examRepository;

    @Transactional
    public void registerStudentForExam(Long studentId, Long examId) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new ExamNotFound("Exam not found with id: " + examId));

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFound("Student not found with id: " + studentId));


        if (!student.getSubjects().contains(exam.getSubject())) {
            throw new StudentNotEnrolledInSubject("Student is not enrolled in the subject of the exam");
        }

        if (student.getExams().contains(exam)) {
            throw new AlreadyEnrolledInExam("Student is already registered for this exam");
        }

        student.getExams().add(exam);
        exam.getEnrolledStudents().add(student);
        studentRepository.save(student);
        examRepository.save(exam);
    }
}
