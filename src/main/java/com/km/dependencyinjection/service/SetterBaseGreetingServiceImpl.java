package com.km.dependencyinjection.service;

import org.springframework.stereotype.Service;

@Service
public class SetterBaseGreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - Setter Base";
    }
}
