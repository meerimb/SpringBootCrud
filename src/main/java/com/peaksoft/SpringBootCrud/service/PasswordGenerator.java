package com.peaksoft.SpringBootCrud.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String password="peaksoft";
       String encode= encoder.encode(password);
        System.out.println(encode);
    }
}
