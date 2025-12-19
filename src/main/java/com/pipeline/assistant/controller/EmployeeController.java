package com.pipeline.assistant.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pipeline.assistant.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee/greeting")
    public String getEmployeeGreeting(@RequestParam(name = "name") String name) {
        return employeeService.generateGreeting(name);
    }

}
