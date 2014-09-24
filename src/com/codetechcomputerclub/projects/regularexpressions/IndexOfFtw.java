package com.codetechcomputerclub.projects.regularexpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IndexOfFtw {

    public static final String alphanumeric =
            "abcdefghijklmnopqrstuvwxyz" +
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                    "0123456789" +
                    "_";

    public static final char[] validNameChars = (IndexOfFtw.alphanumeric + ".+-")
            .toCharArray();
    public static final char[] validDomainChars = (IndexOfFtw.alphanumeric + "-")
            .toCharArray();

    private static boolean inArray(char[] chars, char character) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == character) {
                return true;
            }
        }
        return false;
    }

    private static boolean stringCharsAreInArray(char[] chars, String string) {
        char[] stringChars = string.toCharArray();
        for (int i = 0; i < stringChars.length; i++) {
            if (!IndexOfFtw.inArray(chars, stringChars[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean validNamePart(String input) {
        return IndexOfFtw.stringCharsAreInArray(IndexOfFtw.validNameChars,
                input);
    }

    private static boolean validDomainPart(String input) {
        return IndexOfFtw.stringCharsAreInArray(IndexOfFtw.validDomainChars,
                input);
    }

    private static List<String> splitDots(String string) {
        int dotIndex = string.indexOf(".");
        List<String> list = new ArrayList<>();
        if (dotIndex > -1) {
            String firstPart = string.substring(0, dotIndex);
            String secondPart = string.substring(dotIndex + 1);
            list.add(firstPart);
            list.addAll(IndexOfFtw.splitDots(secondPart));
            return list;
        } else {
            list.add(string);
            return list;
        }
    }

    public static boolean isEmail(String input) {
        int atIndex = input.indexOf("@");
        if (atIndex == -1) {
            return false;
        }

        String namePart = input.substring(0, atIndex);
        if (!IndexOfFtw.validNamePart(namePart) || namePart.length() == 0) {
            return false;
        }

        String domainPart = input.substring(atIndex + 1);
        List<String> domainParts = IndexOfFtw.splitDots(domainPart);

        if (domainParts.size() < 2) {
            return false;
        }

        for (String part : domainParts) {
            if (!IndexOfFtw.validDomainPart(part) || part.length() == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an email address to validate: ");
        String input = scanner.nextLine();

        scanner.close();

        if (IndexOfFtw.isEmail(input)) {
            System.out.println("Congrats! You (probably) entered an email!");
        } else {
            System.out.println("Not an email address.");
        }

    }

}
