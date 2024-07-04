import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            String inputString = scanner.next();
            StringBuilder resultBuilder = new StringBuilder();
            int openParentheses = 0;

            for (int i = 0; i < inputString.length(); i++) {
                int currentDigit = inputString.charAt(i) - '0';

                if (openParentheses < currentDigit) {
                    for (int j = 0; j < currentDigit - openParentheses; j++) {
                        resultBuilder.append('(');
                    }
                } else if (openParentheses > currentDigit) {
                    for (int j = 0; j < openParentheses - currentDigit; j++) {
                        resultBuilder.append(')');
                    }
                }

                resultBuilder.append(currentDigit);
                openParentheses = currentDigit;
            }

            for (int i = 0; i < openParentheses; i++) {
                resultBuilder.append(')');
            }

            System.out.printf("Case #%d: %s%n", testCase, resultBuilder.toString());
        }
    }
}