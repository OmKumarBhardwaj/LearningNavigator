package org.coder.learning_navigator.exception;

public class StudentNotEnrolledInSubject extends RuntimeException {
    public StudentNotEnrolledInSubject(String message) {
        super(message);
    }
}
