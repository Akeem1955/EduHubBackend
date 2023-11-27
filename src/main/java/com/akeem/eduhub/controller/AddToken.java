package com.akeem.eduhub.controller;

import com.akeem.eduhub.db.Token;
import com.akeem.eduhub.db.helper.TokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddToken {
    @Autowired
    TokenRepo repo;

    @PostMapping("/update_token")
    public ResponseEntity<String> updateToken(@RequestBody Token t){
        repo.saveAndFlush(t);
        return ResponseEntity.status(200).body("Success");
    }
}
