package com.codetechcomputerclub.projects.regularexpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IndexOfFtw {

    public static final String alphanumeric =
            "abcdefghijklmnopqrstuvwxyz" +
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                    "0123456789" +
                    "_";

    public static final String[] validNameChars = (IndexOfFtw.alphanumeric + ".+-")
            .split("");
    public static final String[] validDomainChars = (IndexOfFtw.alphanumeric + "-")
            .split("");

    private static boolean charsAreInArray(String[] strings, String string) {
        List<String> list = Arrays.asList(strings);
        for (String character : string.split("")) {
            if (!list.contains(character)) {
                return false;
            }
        }
        return true;
    }

    private static boolean validNamePart(String input) {
        return IndexOfFtw.charsAreInArray(IndexOfFtw.validNameChars, input);
    }

    private static boolean validDomainPart(String input) {
        return IndexOfFtw.charsAreInArray(IndexOfFtw.validDomainChars, input);
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

    public static void main(final String[] args) {

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
