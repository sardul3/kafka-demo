package com.example.kafkademo.controller;

import com.example.kafkademo.config.Gs1PropertyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("props")
public class PropController {

    @Autowired
    Gs1PropertyConfig config;

    @GetMapping
    public String getData() {
        return config.getAngle();
    }
}
