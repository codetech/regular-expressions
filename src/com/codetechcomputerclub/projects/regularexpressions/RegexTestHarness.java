package com.codetechcomputerclub.projects.regularexpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestHarness {

    public static void main(String[] args) {

        @SuppressWarnings("resource")
        final Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("Enter your regex: ");
            Pattern pattern = Pattern.compile(scanner.nextLine());

            System.out.print("Enter input string to search: ");
            Matcher matcher = pattern.matcher(scanner.nextLine());

            if (!matcher.find()) {
                System.out.println("No match found.");
            }

            matcher.reset();

            while (matcher.find()) {
                System.out.printf("I found the text" +
                        " \"%s\" starting at " +
                        "index %d and ending at index %d.",
                        matcher.group(),
                        matcher.start(),
                        matcher.end());
                System.out.println();
            }

        }

    }
}
