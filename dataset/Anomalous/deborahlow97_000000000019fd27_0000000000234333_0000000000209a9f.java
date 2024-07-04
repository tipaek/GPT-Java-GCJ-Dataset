import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            String result = processLine(scanner.nextLine());
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String processLine(String line) {
        StringBuilder result = new StringBuilder();
        int openParentheses = 0;
        int closeParentheses = 0;
        int previousDigit = -1;

        for (int i = 0; i < line.length(); i++) {
            int currentDigit = Character.getNumericValue(line.charAt(i));

            if (i == 0 || previousDigit == 0) {
                appendCharacters(result, '(', currentDigit);
                result.append(currentDigit);
                openParentheses += currentDigit;
            } else {
                if (previousDigit > currentDigit) {
                    appendCharacters(result, ')', previousDigit - currentDigit);
                    result.append(currentDigit);
                    closeParentheses += previousDigit - currentDigit;
                } else if (previousDigit < currentDigit) {
                    appendCharacters(result, '(', currentDigit - previousDigit);
                    result.append(currentDigit);
                    openParentheses += currentDigit - previousDigit;
                } else {
                    result.append(currentDigit);
                }
            }
            previousDigit = currentDigit;
        }

        appendCharacters(result, ')', openParentheses - closeParentheses);
        return result.toString();
    }

    public static void appendCharacters(StringBuilder sb, char character, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(character);
        }
    }
}