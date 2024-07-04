import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        try {
            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                String inputString = scanner.nextLine();
                System.out.println("Case #" + caseNumber + ": " + resolve(inputString));
            }
        } catch (NegativeArraySizeException ex) {
            System.out.println("Exception: " + ex);
        }
    }

    public static String resolve(String str) {
        char[] characters = str.toCharArray();
        StringBuilder result = new StringBuilder();
        int openParentheses = 0;

        for (int i = 0; i < characters.length; i++) {
            int currentDigit = Character.getNumericValue(characters[i]);

            if (currentDigit != 0) {
                if (i < characters.length - 1) {
                    int nextDigit = Character.getNumericValue(characters[i + 1]);

                    if (openParentheses == 0) {
                        appendParentheses(result, openParentheses, currentDigit);
                        openParentheses = currentDigit;
                        result.append(characters[i]);

                        if (nextDigit == 0) {
                            closeParentheses(result, openParentheses, 0);
                            openParentheses = 0;
                        }
                    } else {
                        adjustParentheses(result, openParentheses, currentDigit);
                        openParentheses = currentDigit;
                        result.append(characters[i]);

                        if (nextDigit == 0) {
                            closeParentheses(result, openParentheses, 0);
                            openParentheses = 0;
                        }
                    }
                } else {
                    adjustParentheses(result, openParentheses, currentDigit);
                    openParentheses = currentDigit;
                    result.append(characters[i]);
                    closeParentheses(result, openParentheses, 0);
                }
            } else {
                result.append('0');
            }
        }

        return result.toString();
    }

    private static void appendParentheses(StringBuilder result, int openParentheses, int target) {
        while (openParentheses < target) {
            result.append('(');
            openParentheses++;
        }
    }

    private static void closeParentheses(StringBuilder result, int openParentheses, int target) {
        while (openParentheses > target) {
            result.append(')');
            openParentheses--;
        }
    }

    private static void adjustParentheses(StringBuilder result, int openParentheses, int target) {
        if (openParentheses > target) {
            closeParentheses(result, openParentheses, target);
        } else if (openParentheses < target) {
            appendParentheses(result, openParentheses, target);
        }
    }
}