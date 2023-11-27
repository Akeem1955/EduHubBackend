package com.akeem.eduhub.servicer;

import com.akeem.eduhub.db.Token;
import com.akeem.eduhub.db.helper.TokenRepo;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.*;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public class NotificationServices {
    private ClassLoader loader;
    private TokenRepo repo;
    private List<Token> tokens;

    @Autowired
    public NotificationServices(ConfigurableApplicationContext context,TokenRepo repo) {
        this.loader = context.getClassLoader();
        this.repo= repo;
        tokens = repo.findAll();

        FileInputStream serviceAccount;
        try {
            serviceAccount = new FileInputStream(loader.getResource("app_edu_hub_services.json").getFile());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        FirebaseOptions options ;
        try {
            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://app-demo-c7915-default-rtdb.firebaseio.com")
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FirebaseApp.initializeApp(options);
    }

    public String sendNotification(String msg, String title) throws FirebaseMessagingException {
        for (Token t:tokens) {
            String registrationToken = t.getToken();
            AndroidConfig config = AndroidConfig.builder()
                    .setNotification(AndroidNotification.builder()
                            .setTitle(title)
                            .setBody(msg)
                            .setDefaultSound(true) // Specify the sound
                            .setPriority(AndroidNotification.Priority.MAX)
                            .build())
                    .build();
            Message message = Message.builder()
                    .setAndroidConfig(config)
                    .setToken(registrationToken)
                    .build();
//            String response = FirebaseMessaging.getInstance().send(message);
        }
        return "Success";
    }
}
