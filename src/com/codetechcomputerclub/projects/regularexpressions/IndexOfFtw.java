package com.codetechcomputerclub.projects.regularexpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IndexOfFtw {

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
        if (namePart.length() == 0) {
            return false;
        }

        String domainPart = input.substring(atIndex + 1);

        int extensionDotIndex = domainPart.indexOf(".");

        // Normally this would be == -1, but we need to include index 0 so we
        // fail on "abc@.abc".
        if (extensionDotIndex <= 0) {
            return false;
        }

        String tldPart = domainPart.substring(extensionDotIndex + 1);
        if (tldPart.length() == 0) {
            return false;
        }

        List<String> tldParts = IndexOfFtw.splitDots(tldPart);
        for (String part : tldParts) {
            if (part.length() == 0) {
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
