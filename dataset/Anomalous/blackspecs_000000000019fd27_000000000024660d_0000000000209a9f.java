import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;
            int previousDigit = 0;

            for (int j = 0; j < input.length(); j++) {
                int currentDigit = Character.getNumericValue(input.charAt(j));

                if (currentDigit > previousDigit) {
                    for (int k = 0; k < currentDigit - previousDigit; k++) {
                        result.append("(");
                        openBrackets++;
                    }
                } else if (currentDigit < previousDigit) {
                    for (int k = 0; k < previousDigit - currentDigit; k++) {
                        result.append(")");
                        openBrackets--;
                    }
                }

                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            for (int k = 0; k < openBrackets; k++) {
                result.append(")");
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }

        scanner.close();
    }
}