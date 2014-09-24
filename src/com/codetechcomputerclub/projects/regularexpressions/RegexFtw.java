package com.codetechcomputerclub.projects.regularexpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFtw {

    public static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+(?<!\\.)$");

    public static boolean isEmail(String input) {
        Matcher matcher = RegexFtw.EMAIL_PATTERN.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an email address to validate: ");
        String input = scanner.nextLine();

        scanner.close();

        if (RegexFtw.isEmail(input)) {
            System.out.println("Congrats! You (probably) entered an email!");
        } else {
            System.out.println("Not an email address.");
        }
    }

}
