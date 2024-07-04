import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int numStrings = Integer.parseInt(scanner.nextLine());
            String[] patterns = new String[numStrings];

            for (int i = 0; i < numStrings; i++) {
                patterns[i] = scanner.nextLine();
            }

            String leftPart = getLeftPart(patterns);
            String rightPart = getRightPart(patterns);
            String result = "";

            if (!leftPart.equals("-") && !rightPart.equals("-")) {
                StringBuilder resultBuilder = new StringBuilder();
                resultBuilder.append(leftPart);

                for (String pattern : patterns) {
                    String[] parts = pattern.split("\\*");
                    for (int i = 1; i < parts.length - 1; i++) {
                        resultBuilder.append(parts[i]);
                    }
                    if (parts.length != 1 && pattern.charAt(pattern.length() - 1) == '*') {
                        resultBuilder.append(parts[parts.length - 1]);
                    }
                }

                resultBuilder.append(rightPart);
                result = resultBuilder.toString();
            }

            System.out.println("Case #" + t + ": " + (result.isEmpty() ? "*" : result));
        }
    }

    private static String getLeftPart(String[] patterns) {
        int[] pointers = new int[patterns.length];
        StringBuilder longestLeft = new StringBuilder();
        boolean isValid = true;

        while (isValid) {
            boolean allDone = true;
            char currentChar = 0;

            for (int i = 0; i < patterns.length; i++) {
                if (pointers[i] >= patterns[i].length()) continue;
                char ch = patterns[i].charAt(pointers[i]);

                if (ch == '*') continue;
                if (currentChar != 0 && currentChar != ch) {
                    isValid = false;
                    break;
                }
                if (currentChar == 0) currentChar = ch;

                pointers[i]++;
                allDone = false;
            }

            if (currentChar != 0) longestLeft.append(currentChar);
            if (allDone) break;
        }

        return isValid ? longestLeft.toString() : "-";
    }

    private static String getRightPart(String[] patterns) {
        int[] pointers = new int[patterns.length];
        for (int i = 0; i < patterns.length; i++) {
            pointers[i] = patterns[i].length() - 1;
        }

        StringBuilder longestRight = new StringBuilder();
        boolean isValid = true;

        while (isValid) {
            boolean allDone = true;
            char currentChar = 0;

            for (int i = 0; i < patterns.length; i++) {
                if (pointers[i] < 0) continue;
                char ch = patterns[i].charAt(pointers[i]);

                if (ch == '*') continue;
                if (currentChar != 0 && currentChar != ch) {
                    isValid = false;
                    break;
                }
                if (currentChar == 0) currentChar = ch;

                pointers[i]--;
                allDone = false;
            }

            if (currentChar != 0) longestRight.append(currentChar);
            if (allDone) break;
        }

        return isValid ? longestRight.reverse().toString() : "-";
    }
}