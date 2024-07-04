import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String inputString = scanner.next();
            StringBuilder resultBuilder = new StringBuilder();
            int previousDigit = 0;

            for (int i = 0; i < inputString.length(); i++) {
                int currentDigit = inputString.charAt(i) - '0';

                if (previousDigit > currentDigit) {
                    for (int j = currentDigit; j < previousDigit; j++) {
                        resultBuilder.append(')');
                    }
                } else if (currentDigit > previousDigit) {
                    for (int j = previousDigit; j < currentDigit; j++) {
                        resultBuilder.append('(');
                    }
                }

                previousDigit = currentDigit;
                resultBuilder.append(inputString.charAt(i));
            }

            for (int j = 0; j < previousDigit; j++) {
                resultBuilder.append(')');
            }

            System.out.println(String.format("Case #%d: %s", testCase, resultBuilder.toString()));
        }
    }
}