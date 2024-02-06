package com.example.esd_demo.service;

import com.example.esd_demo.bean.Student;
import com.example.esd_demo.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public Student login(Student student) {
        return studentDAO.findByEmailAndPassword(student.getEmail(), student.getPassword());
    }
}