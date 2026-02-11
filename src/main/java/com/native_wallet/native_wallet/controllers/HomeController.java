package com.native_wallet.native_wallet.controllers;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@AllArgsConstructor
public class HomeController {
    @GetMapping("/")
    public String home() {
        System.out.println("Cron jobs working!!");
        return "This is the root of the backend !!\n";
    }
    
}
