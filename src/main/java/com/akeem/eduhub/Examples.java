//package com.akeem.eduhub;
//
//import com.google.auth.oauth2.GoogleCredentials;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.Arrays;
//
//import static org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.ExistingWebApplicationScopes.SCOPES;
//
//public class Examples {
//    private static final String BASE_URL ="";
//    private static final String FCM_SEND_ENDPOINT = "";
//    private static final T SCOPES = "";
//
//    HttpURLConnection Examples() throws IOException {
//        URL url = new URL(BASE_URL + FCM_SEND_ENDPOINT);
//        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//        httpURLConnection.setRequestProperty("Authorization", "Bearer " + getServiceAccountAccessToken());
//        httpURLConnection.setRequestProperty("Content-Type", "application/json; UTF-8");
//        return httpURLConnection;
//    }
//
//    private String getServiceAccountAccessToken() {
//        return null;
//    }
//    private static String getAccessToken() throws IOException {
//        GoogleCredentials googleCredentials = GoogleCredentials
//                .fromStream(new FileInputStream("service-account.json"))
//                .createScoped(Arrays.asList(SCOPES));
//        googleCredentials.refresh();
//        return googleCredentials.getAccessToken().getTokenValue();
//    }
//}
