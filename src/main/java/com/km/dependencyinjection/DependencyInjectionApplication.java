package com.km.dependencyinjection;

import com.km.dependencyinjection.controller.ConstructorInjectedController;
import com.km.dependencyinjection.controller.I18nController;
import com.km.dependencyinjection.controller.MyController;
import com.km.dependencyinjection.controller.PropertyInjectedController;
import com.km.dependencyinjection.controller.SetterBasedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);
        MyController myController = (MyController) context.getBean("myController");

        System.out.println("--------------- I18n ---------------");
        I18nController i18nController = (I18nController) context.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        System.out.println("--------------- Primary Bean ---------------");
        System.out.println(myController.sayHello());

        System.out.println("--------------- Property ---------------");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) context.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("--------------- Setter ---------------");
        SetterBasedController setterBasedController = (SetterBasedController) context.getBean("setterBasedController");
        System.out.println(setterBasedController.getGreeting());

        System.out.println("--------------- Constructor ---------------");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) context.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());
    }

}
