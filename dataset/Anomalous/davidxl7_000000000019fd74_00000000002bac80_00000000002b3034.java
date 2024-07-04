import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solve(scanner));
        }
    }

    public static String solve(Scanner scanner) {
        int numStrings = scanner.nextInt();
        String[] strings = new String[numStrings];
        StringBuilder prefix = new StringBuilder();
        
        for (int i = 0; i < numStrings; i++) {
            strings[i] = scanner.next();
        }

        while (true) {
            Set<Character> uniqueChars = new HashSet<>();
            for (int i = 0; i < numStrings; i++) {
                if (strings[i].charAt(0) != '*') {
                    uniqueChars.add(strings[i].charAt(0));
                    strings[i] = strings[i].substring(1);
                }
            }
            if (uniqueChars.isEmpty()) {
                break;
            }
            if (uniqueChars.size() == 1) {
                prefix.append(uniqueChars.iterator().next());
            } else {
                return "*";
            }
        }

        StringBuilder suffix = new StringBuilder();
        int distance = 1;
        while (true) {
            Set<Character> uniqueChars = new HashSet<>();
            for (int i = 0; i < numStrings; i++) {
                if (strings[i].length() - distance >= 0) {
                    char currentChar = strings[i].charAt(strings[i].length() - distance);
                    if (currentChar != '*') {
                        uniqueChars.add(currentChar);
                    }
                }
            }
            if (uniqueChars.isEmpty()) {
                return prefix.toString() + suffix.toString();
            }
            if (uniqueChars.size() != 1) {
                return "*";
            }
            suffix.insert(0, uniqueChars.iterator().next());
            distance++;
        }
    }
}