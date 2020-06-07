package ru.volnenko.se.controller;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class ConsoleCommandReader implements ICommandReader {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public Integer nextInteger() {
        final String value = nextLine();
        if (value == null || value.isEmpty()) return null;
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return null;
        }
    }
}
