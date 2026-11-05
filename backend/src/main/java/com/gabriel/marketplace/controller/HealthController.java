package com.gabriel.marketplace.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class HealthController {

    @GetMapping("/status")
    public Map<String, String> status() {
        return Map.of("status", "online", "application", "marketplace-api");
    }
}
