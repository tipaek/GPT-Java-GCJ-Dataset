import java.util.Scanner;

public class Solution {

    private static int openParentheses = 0;

    public static void main(String[] args) {
        processInput();
    }

    public static void processInput() {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < testCases; i++) {
            openParentheses = 0;
            String inputLine = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            result.append("Case #").append(i + 1).append(": ");
            processLine(inputLine, result);
        }
        scanner.close();
    }

    private static void processLine(String line, StringBuilder result) {
        int previousChar = 0;
        for (int i = 0; i < line.length(); i++) {
            int currentChar = Character.getNumericValue(line.charAt(i));
            if (previousChar != currentChar) {
                adjustParentheses(currentChar - openParentheses, result);
                result.append(currentChar);
            } else {
                result.append(currentChar);
            }
            int nextChar = (i != line.length() - 1) ? Character.getNumericValue(line.charAt(i + 1)) : 0;
            adjustParentheses(openParentheses - nextChar, result);
            previousChar = currentChar;
        }
        System.out.println(result);
    }

    private static void adjustParentheses(int difference, StringBuilder result) {
        if (difference > 0) {
            for (int i = 0; i < difference; i++) {
                result.append("(");
                openParentheses++;
            }
        } else {
            for (int i = 0; i < -difference; i++) {
                result.append(")");
                openParentheses--;
            }
        }
    }
}