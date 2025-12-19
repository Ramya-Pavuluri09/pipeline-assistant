package com.pipeline.assistant.serviceImpl;

import org.springframework.stereotype.Service;

import com.pipeline.assistant.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public String generateGreeting(String name) {
        return "Hello, " + name + "!";
    }

}
