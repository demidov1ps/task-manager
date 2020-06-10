package ru.volnenko.se;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import ru.volnenko.se.controller.Bootstrap;


public class App {

    public static void main(String[] args) throws Exception {
        try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            context.getBean(Bootstrap.class).start();
        }
    }
}
