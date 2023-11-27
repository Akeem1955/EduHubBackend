package com.akeem.eduhub.controller;

import com.akeem.eduhub.controller.parser.NotificationPayload;
import com.akeem.eduhub.servicer.NotificationServices;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentNotify {
    private  NotificationServices services;
    @Autowired
    public StudentNotify(NotificationServices notificationServices) {
        this.services = notificationServices;
    }

    @PostMapping("/notify_student")
    public ResponseEntity<String> notifyStudent(@RequestBody NotificationPayload payload){
        try {
            services.sendNotification(payload.getMsg(), payload.getTitle());
            return ResponseEntity.ok("Success");
        } catch (FirebaseMessagingException e) {
            return ResponseEntity.internalServerError().body("Failed");
        }
    }
}
