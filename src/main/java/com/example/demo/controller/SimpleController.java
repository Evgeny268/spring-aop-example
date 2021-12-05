package com.example.demo.controller;

import com.example.demo.aspect.SpeedMetric;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @SneakyThrows
    @GetMapping("/test")
    @SpeedMetric
    public ResponseEntity<String> test(@RequestParam(value = "value") String value) {
        Thread.sleep(100);
        return new ResponseEntity<>(value, HttpStatus.OK);
    }

}
