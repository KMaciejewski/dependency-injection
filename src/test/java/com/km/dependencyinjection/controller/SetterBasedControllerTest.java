package com.km.dependencyinjection.controller;

import com.km.dependencyinjection.service.ConstructorGreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterBasedControllerTest {

    SetterBasedController controller;

    @BeforeEach
    void setUp() {
        controller = new SetterBasedController();
        controller.setGreetingService(new ConstructorGreetingServiceImpl());
    }

    @Test
    void getGreeting() {
        String greeting = controller.getGreeting();
        System.out.println(greeting);
    }
}