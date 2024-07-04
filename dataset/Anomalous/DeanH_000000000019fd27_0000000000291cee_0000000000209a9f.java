import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String number = scanner.next();
            int length = number.length();
            int openBrackets = 0;
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < length; j++) {
                int currentDigit = number.charAt(j) - '0';

                if (currentDigit > openBrackets) {
                    for (int k = 0; k < currentDigit - openBrackets; k++) {
                        result.append('(');
                    }
                    openBrackets = currentDigit;
                } else if (currentDigit < openBrackets) {
                    for (int k = 0; k < openBrackets - currentDigit; k++) {
                        result.append(')');
                    }
                    openBrackets = currentDigit;
                }

                result.append(number.charAt(j));
            }

            for (int j = 0; j < openBrackets; j++) {
                result.append(')');
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}