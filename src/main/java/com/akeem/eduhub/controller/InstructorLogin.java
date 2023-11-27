package com.akeem.eduhub.controller;

import com.akeem.eduhub.db.Instructor;
import com.akeem.eduhub.db.helper.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstructorLogin {
    @Autowired
    private InstructorRepo repo;

    @PostMapping("/verify_instructor")
    ResponseEntity<Instructor> verifyIdentity(@RequestBody Instructor i){
        System.out.println(i.getId() + "Hello");
        if(!repo.existsById(i.getId())){
            return ResponseEntity.status(401).body(null);
        }
        System.out.println("We reach here ");
        Instructor instructor = repo.findById(i.getId()).get();
        if(i.getPassword().equals(instructor.getPassword())){
            return ResponseEntity.ok(instructor);
        }
        return ResponseEntity.status(401).body(null);
    }
}
