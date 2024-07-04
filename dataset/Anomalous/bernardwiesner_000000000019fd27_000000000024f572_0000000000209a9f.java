import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            StringBuilder result = new StringBuilder();
            String[] digits = scanner.next().split("");
            int openParentheses = Integer.parseInt(digits[0]);
            int currentValue = openParentheses;

            for (int i = 0; i < openParentheses; i++) {
                result.append("(");
            }
            result.append(digits[0]);

            for (int i = 1; i < digits.length; i++) {
                int nextValue = Integer.parseInt(digits[i]);

                if (nextValue > currentValue) {
                    for (int j = 0; j < nextValue - currentValue; j++) {
                        result.append("(");
                        openParentheses++;
                    }
                } else if (nextValue < currentValue) {
                    for (int j = 0; j < currentValue - nextValue; j++) {
                        result.append(")");
                        openParentheses--;
                    }
                }
                result.append(nextValue);
                currentValue = nextValue;
            }

            for (int i = 0; i < openParentheses; i++) {
                result.append(")");
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }
}