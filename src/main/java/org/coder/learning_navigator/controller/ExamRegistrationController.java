package org.coder.learning_navigator.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.coder.learning_navigator.service.ExamService;

@RestController
@AllArgsConstructor
public class ExamRegistrationController {

    private ExamService examService;

    @PostMapping("/exams/{examId}/register/{studentId}")
    public ResponseEntity<?> registerStudentForExam(@PathVariable String examId, @PathVariable String studentId) {
        examService.registerStudentForExam(studentId, examId);
        return ResponseEntity.ok("Student registered for exam successfully.");
    }
}
