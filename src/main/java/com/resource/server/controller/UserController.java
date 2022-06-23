package com.resource.server.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/api/users")
    public String[] getUser() {
        return new String[]{"Albert", "Newton", "Gosling"};
    }

    @GetMapping("/api/users/info")
    public Map<String, Object> userInfo(Authentication currentUser) {
        Map<String, Object> result = new HashMap<>();

        result.put("DateTime", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        result.put("authentication class", currentUser.getClass().getSimpleName());
        result.put("current authentication", currentUser);

        JwtAuthenticationToken currentAuthentication = (JwtAuthenticationToken) currentUser;
        currentAuthentication.getName();

        return result;
    }
}
