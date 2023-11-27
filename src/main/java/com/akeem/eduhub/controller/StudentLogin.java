package com.akeem.eduhub.controller;


import com.akeem.eduhub.db.Instructor;
import com.akeem.eduhub.db.Student;
import com.akeem.eduhub.db.helper.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentLogin {
    @Autowired
    private StudentRepo repo;

    @PostMapping("/verify_student")
    ResponseEntity<Student> verifyStudent(@RequestBody Student s){
        if(!repo.existsById(s.getMatric_no().replaceAll("_","/"))){
            return ResponseEntity.status(401).body(null);
        }
        Student student = repo.findById(s.getMatric_no().replaceAll("_","/")).get();
        if(s.getPassword().replaceAll("_","/").equals(student.getPassword())){
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.status(401).body(null);
    }
}
