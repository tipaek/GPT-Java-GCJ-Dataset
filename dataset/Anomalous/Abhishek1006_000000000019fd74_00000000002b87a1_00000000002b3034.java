import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            String[] strings = new String[size];
            int maxLength = 0;

            for (int j = 0; j < size; j++) {
                StringBuilder reversedString = new StringBuilder(scanner.nextLine()).reverse();
                strings[j] = reversedString.toString();
                maxLength = Math.max(maxLength, strings[j].length());
            }

            processPatterns(strings, i, maxLength);
        }
    }

    public static void processPatterns(String[] patterns, int caseNumber, int maxLength) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < maxLength; i++) {
            char currentChar = '*';
            char previousChar = '*';
            boolean charAdded = false;

            for (String pattern : patterns) {
                if (i < pattern.length()) {
                    currentChar = pattern.charAt(i);
                } else {
                    currentChar = '*';
                }

                if (currentChar == previousChar || currentChar == '*' || previousChar == '*') {
                    if (currentChar != '*' && !charAdded) {
                        result.append(currentChar);
                        charAdded = true;
                    }
                } else {
                    System.out.println("Case #" + caseNumber + ": *");
                    return;
                }

                previousChar = currentChar;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result.reverse().toString());
    }
}