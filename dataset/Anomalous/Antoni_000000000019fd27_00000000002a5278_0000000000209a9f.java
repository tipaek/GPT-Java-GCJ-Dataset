import java.util.Scanner;

public class Solution {

    private static int openParenthesesCount = 0;

    public static void main(String[] args) {
        runCodeJam();
    }

    public static void runCodeJam() {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCases; i++) {
            openParenthesesCount = 0;
            String inputLine = scanner.nextLine();
            processLine(inputLine);
        }
        scanner.close();
    }

    private static void processLine(String line) {
        StringBuilder result = new StringBuilder();
        int previousChar = 0;
        int currentChar;
        int nextChar;

        for (int i = 0; i < line.length(); i++) {
            currentChar = Character.getNumericValue(line.charAt(i));
            if (previousChar != currentChar) {
                adjustParentheses(currentChar - openParenthesesCount, result);
                result.append(currentChar);
            } else {
                result.append(currentChar);
            }
            if (i != line.length() - 1) {
                nextChar = Character.getNumericValue(line.charAt(i + 1));
            } else {
                nextChar = 0;
            }
            adjustParentheses(openParenthesesCount - nextChar, result);
            previousChar = currentChar;
        }
        System.out.println(result);
    }

    private static void adjustParentheses(int count, StringBuilder result) {
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                result.append("(");
                openParenthesesCount++;
            }
        } else {
            for (int i = 0; i < -count; i++) {
                result.append(")");
                openParenthesesCount--;
            }
        }
    }
}