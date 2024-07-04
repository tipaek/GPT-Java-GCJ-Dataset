import java.io.*;
import java.util.*;

public class Solution {
    public static String transformString(String input) {
        boolean modified = false;
        boolean isOpen = false;
        StringBuilder result = new StringBuilder();
        int number;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == ')' || currentChar == '(') {
                result.append(currentChar);
            } else {
                number = Character.getNumericValue(currentChar);
                if (number > 0) {
                    if (!isOpen) {
                        result.append("(");
                        isOpen = true;
                    }
                    result.append(number - 1);
                    modified = true;
                } else {
                    if (isOpen) {
                        result.append(")");
                        isOpen = false;
                    }
                    result.append(number);
                }
            }
        }

        if (isOpen) {
            result.append(")");
        }

        if (modified) {
            return transformString(result.toString());
        } else {
            return result.toString();
        }
    }

    public static String addParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(') {
                depth++;
                result.append("(");
            } else if (currentChar == ')') {
                depth--;
                result.append(")");
            } else {
                result.append(depth);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            String transformed = transformString(input);
            String result = addParentheses(transformed);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}