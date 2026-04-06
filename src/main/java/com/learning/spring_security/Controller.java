package com.learning.spring_security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hello")
    public String getHello() {
        return "Hello";
    }

    @GetMapping("/admin/hello")
    public String getAdminHello() {
        return "Hello, Admin!!";
    }

    @GetMapping("/user/hello")
    public String getUserHello() {
        return "Hello, User!!";
    }

}
